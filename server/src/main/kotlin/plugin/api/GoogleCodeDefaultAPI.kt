package plugin.api

import java.io.InputStream
import java.net.URL

class GoogleCodeDefaultAPI(projectName: String) : GoogleCodeAPI {
    private val archiveUrlTemplate = "https://storage.googleapis.com/google-code-archive/v2/code.google.com/$projectName"

    override fun fetchProject(): InputStream
            = URL("$archiveUrlTemplate/project.json").openStream()

    override fun fetchIssuesPage(pageNum: Int): InputStream
            = URL("$archiveUrlTemplate/issues-page-$pageNum.json").openStream()

    override fun fetchIssue(issueId: Int): InputStream
            = URL("$archiveUrlTemplate/issues/issue-$issueId.json").openStream()
}
