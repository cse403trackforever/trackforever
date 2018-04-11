package plugin

import com.beust.klaxon.Klaxon
import plugin.api.GitHubAPI
import plugin.api.GitHubDefaultAPI
import plugin.structures.GitHubCommentStructure
import plugin.structures.GitHubIssueStructure

class GitHubPlugin(
        ownerName: String,
        projectName: String,
        private val api: GitHubAPI = GitHubDefaultAPI(ownerName, projectName)
): Plugin {

    override fun import() {
        val issues = Klaxon().parseArray<GitHubIssueStructure>(api.issues) ?: emptyList()

        issues.forEach {
            val comments = Klaxon().parseArray<GitHubCommentStructure>(api.fetchComments(it.number)) ?: emptyList()
            println(it)
            println(comments)
        }

        // TODO: create all the necessary structures to support this
    }
}