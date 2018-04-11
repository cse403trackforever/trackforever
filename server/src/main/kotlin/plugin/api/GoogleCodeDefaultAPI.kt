package plugin.api

import java.io.InputStream
import java.net.URL

class GoogleCodeDefaultAPI(projectName: String) : GoogleCodeAPI {
    private val archiveUrlTemplate = "https://storage.googleapis.com/google-code-archive/v2/code.google.com/$projectName"

    override fun fetchProject(): InputStream {
        return URL("$archiveUrlTemplate/project.json").openStream()
    }

    override fun fetchIssuesPage(pageNum: Int): InputStream {
        return URL("$archiveUrlTemplate/issues-page-$pageNum.json").openStream()
    }

    override fun fetchIssue(issueId: Int): InputStream {
        return URL("$archiveUrlTemplate/issues/issue-$issueId.json").openStream()
    }
}
