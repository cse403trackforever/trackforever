package plugin.api

import java.io.InputStream

interface GoogleCodeAPI {
    fun fetchProject(): InputStream

    fun fetchIssuesPage(pageNum: Int): InputStream

    fun fetchIssue(issueId: Int): InputStream
}
