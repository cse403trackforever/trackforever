package plugin

import java.net.URL

class GitHubPlugin(ownerName: String, projectName: String): Plugin {
    private val urlTemplate = "https://api.github.com/repos/$ownerName/$projectName"

    override fun import() {
        // Note: this is the url structure for the REST api
        val issuesUrl = URL("$urlTemplate/issues") // -> Array<GitHubIssueStructure>
        val issueNumber = 1
        val commentsUrl = URL("$urlTemplate/issues/$issueNumber/comments") // -> Array<GitHubCommentStructure>
        // TODO: create all the necessary structures to support this
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun export() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}