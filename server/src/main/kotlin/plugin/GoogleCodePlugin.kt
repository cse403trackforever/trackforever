package plugin

import com.beust.klaxon.Klaxon
import plugin.structures.GoogleCodeIssueStructure
import plugin.structures.GoogleCodeIssuesPageStructure
import plugin.structures.GoogleCodeProjectStructure
import java.net.URL

class GoogleCodePlugin(projectName: String) : Plugin {
    private val archiveUrlTemplate = "https://storage.googleapis.com/google-code-archive/v2/code.google.com/$projectName"
    private val attachementsUrlTemplate = "https://storage.googleapis.com/google-code-attachments/$projectName"

    fun getIssues(): Array<GoogleCodeIssueStructure> {
        val issues = mutableListOf<GoogleCodeIssueStructure>()

        var i = 1 // pages are 1-indexed
        var numPages: Int
        do {
            // get next issues page
            val pageUrl = URL("$archiveUrlTemplate/issues-page-$i.json")
            val issuesPage = Klaxon().parse<GoogleCodeIssuesPageStructure>(pageUrl.openStream()) ?: break
            numPages = issuesPage.totalPages

            // pull issues from page
            for (issueSummary in issuesPage.issues) {
                val issue = getIssue(issueSummary.id) ?: continue
                issues.add(issue)
            }
        } while (i++ < numPages)

        return issues.toTypedArray()
    }

    fun getIssue(issueNum: Int): GoogleCodeIssueStructure? {
        // get issue
        // url format https://storage.googleapis.com/google-code-archive/v2/code.google.com/hg4j/issues-50.json
        val url = URL("$archiveUrlTemplate/issues/issue-$issueNum.json")
        return Klaxon().parse<GoogleCodeIssueStructure>(url.openStream())
    }

    fun getAttachmentUrl(issueNum: Int, commentNum: Int, filename: String): String {
        return "$attachementsUrlTemplate/issue-$issueNum/comment-$commentNum/$filename"
    }

    override fun import() {
        // get project
        val projectUrl = URL("$archiveUrlTemplate/project.json")
        val project = Klaxon().parse<GoogleCodeProjectStructure>(projectUrl.openStream())
        println(project)

        // get issues
        val issues = getIssues()
        issues.forEach { println(it) }

        // TODO: return our data structure
    }

    override fun export() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}