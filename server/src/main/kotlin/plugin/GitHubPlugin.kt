package plugin

import com.beust.klaxon.Klaxon
import plugin.structures.GitHubCommentStructure
import plugin.structures.GitHubIssueStructure
import java.net.URL

class GitHubPlugin(ownerName: String, projectName: String): Plugin {
    private val urlTemplate = "https://api.github.com/repos/$ownerName/$projectName"

    override fun import() {
        val issuesUrl = URL("$urlTemplate/issues")
        val issues = Klaxon().parseArray<GitHubIssueStructure>(issuesUrl.openStream()) ?: emptyList()
        issues.forEach {
            val comments = Klaxon().parseArray<GitHubCommentStructure>(URL(it.commentsUrl).openStream()) ?: emptyList()
            println(it)
            println(comments)
        }

        // TODO: create all the necessary structures to support this
    }

    override fun export() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}