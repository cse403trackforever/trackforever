package plugin.api

import java.io.InputStream

interface GitHubAPI {
    val issues: InputStream

    fun fetchComments(issueId: Int): InputStream
}