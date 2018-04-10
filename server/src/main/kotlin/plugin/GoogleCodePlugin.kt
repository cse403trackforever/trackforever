package plugin

import com.beust.klaxon.Klaxon
import plugin.structures.GoogleCodeIssueStructure
import plugin.structures.GoogleCodeIssuesPageStructure
import plugin.structures.GoogleCodeProjectStructure
import java.net.URL

class GoogleCodePlugin(private val projectName: String? = null) : Plugin {
    private val archiveUrlTemplate = "https://storage.googleapis.com/google-code-archive/v2/code.google.com/$projectName"
    private val attachmentsUrlTemplate = "https://storage.googleapis.com/google-code-attachments/$projectName"
    private var projectJson = ""
    private var issuesJson = ""
    private var arrayCommentsJson = emptyArray<String>()
    private var arrayIssuesJson = emptyArray<String>()

    /**
     * This is the extra constructor to handle json input
     */
    constructor(
            projectJson: String,
            issuesJson: String,
            arrayCommentsJson: Array<String>,
            arrayIssuesJson: Array<String>
    ) : this() {
        this.projectJson = projectJson
        this.issuesJson = issuesJson
        this.arrayCommentsJson = arrayCommentsJson
        this.arrayIssuesJson = arrayIssuesJson

    }

    private fun getIssues(): Array<GoogleCodeIssueStructure> {
        val issues = mutableListOf<GoogleCodeIssueStructure>()

        var i = 1 // pages are 1-indexed
        var numPages: Int
        do {
            val issuesPage = if (projectName is String) {
                // get next issues page
                val pageUrl = URL("$archiveUrlTemplate/issues-page-$i.json")
                Klaxon().parse<GoogleCodeIssuesPageStructure>(pageUrl.openStream())
            } else {
                Klaxon().parse<GoogleCodeIssuesPageStructure>(issuesJson)
            } ?: break
            numPages = issuesPage.totalPages

            // pull issues from page
            for (issueSummary in issuesPage.issues) {
                val issue = getIssue(issueSummary.id) ?: continue
                issues.add(issue)
            }
        } while (i++ < numPages)

        return issues.toTypedArray()
    }

    /**
     * Get individual issue
     */
    private fun getIssue(issueNum: Int) = if (projectName is String) {
        val url = URL("$archiveUrlTemplate/issues/issue-$issueNum.json")
        Klaxon().parse<GoogleCodeIssueStructure>(url.openStream())
    } else {
        Klaxon().parse<GoogleCodeIssueStructure>(arrayIssuesJson[issueNum])
    }


    fun getAttachmentUrl(issueNum: Int, commentNum: Int, filename: String): String {
        return "$attachmentsUrlTemplate/issue-$issueNum/comment-$commentNum/$filename"
    }

    override fun import() {
        // get project
        val project = if (projectName is String) {
            val projectUrl = URL("$archiveUrlTemplate/project.json")
            Klaxon().parse<GoogleCodeProjectStructure>(projectUrl.openStream())
        } else {
            Klaxon().parse<GoogleCodeProjectStructure>(projectJson)
        }

        println(project)

        // get issues
        val issues = getIssues()
        issues.forEach { println(it) }

        // TODO: return our data structure
    }
}