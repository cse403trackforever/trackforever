package plugin

import com.beust.klaxon.Klaxon
import plugin.api.GoogleCodeAPI
import plugin.api.GoogleCodeDefaultAPI
import plugin.structures.GoogleCodeIssueStructure
import plugin.structures.GoogleCodeIssuesPageStructure
import plugin.structures.GoogleCodeProjectStructure

class GoogleCodePlugin(projectName: String, private val api: GoogleCodeAPI = GoogleCodeDefaultAPI(projectName)) : Plugin {
    private val attachmentsUrlTemplate = "https://storage.googleapis.com/google-code-attachments/$projectName"

    /*
     * Fetches and collapses issues from each issues page of the project into one array of all issues
     */
    private fun getIssues(): Array<GoogleCodeIssueStructure> {
        val issues = mutableListOf<GoogleCodeIssueStructure>()

        var i = 1 // pages are 1-indexed
        var numPages: Int
        do {
            // fetch next issues page
            val issuesPage = Klaxon().parse<GoogleCodeIssuesPageStructure>(api.fetchIssuesPage(i)) ?: break
            numPages = issuesPage.totalPages

            // pull each issue from the page
            for (issueSummary in issuesPage.issues) {
                val issue = Klaxon().parse<GoogleCodeIssueStructure>(api.fetchIssue(issueSummary.id)) ?: continue
                issues.add(issue)
            }
        } while (i++ < numPages)

        return issues.toTypedArray()
    }

    fun getAttachmentUrl(issueNum: Int, commentNum: Int, filename: String): String {
        return "$attachmentsUrlTemplate/issue-$issueNum/comment-$commentNum/$filename"
    }

    override fun import() {
        // get project
        val project = Klaxon().parse<GoogleCodeProjectStructure>(api.fetchProject())
        println(project)

        // get issues
        val issues = getIssues()
        issues.forEach { println(it) }

        // TODO: return our data structure
    }
}
