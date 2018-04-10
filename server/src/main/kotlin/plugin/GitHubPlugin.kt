package plugin

import com.beust.klaxon.Klaxon
import plugin.structures.GitHubCommentStructure
import plugin.structures.GitHubIssueStructure
import java.net.URL

class GitHubPlugin(ownerName: String? = null, projectName: String? = null): Plugin {

    /**
     * This is the extra constructor to handle json input
     */
    constructor(issuesJson: String, arrayCommentsJson: Array<String>) : this() {
        this.issuesJson = issuesJson
        this.arrayCommentsJson = arrayCommentsJson
    }

    private val url: URL? = if (ownerName is String && projectName is String) {
        URL("https://api.github.com/repos/$ownerName/$projectName/issues")
    } else {
        null
    }
    private var issuesJson = ""
    private var arrayCommentsJson = emptyArray<String>()

    override fun import() {
        val issues = if (url is URL) {
            Klaxon().parseArray(url.openStream())
        } else {
            Klaxon().parseArray<GitHubIssueStructure>(issuesJson)
        } ?: emptyList()

        issues.withIndex().forEach {
            val comments = if (url is URL) {
                Klaxon().parseArray(URL(it.value.commentsUrl).openStream())
            } else {
                Klaxon().parseArray<GitHubCommentStructure>(arrayCommentsJson[it.index])
            } ?: emptyList()
            println(it)
            println(comments)
        }

        // TODO: create all the necessary structures to support this
    }
}