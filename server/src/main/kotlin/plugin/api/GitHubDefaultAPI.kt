package plugin.api

import java.io.InputStream
import java.net.URL

class GitHubDefaultAPI(ownerName: String, projectName: String) : GitHubAPI {
    private val urlTemplate = "https://api.github.com/repos/$ownerName/$projectName/issues"
    override val issues: InputStream
        get() = URL(urlTemplate).openStream()

    override fun fetchComments(issueId: Int): InputStream = URL("$urlTemplate/$issueId/comments").openStream()
}