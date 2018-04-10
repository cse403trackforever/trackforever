package plugin.structures

import com.beust.klaxon.Json

data class GitHubIssueStructure(
        @Json(name = "comments_url")
        val commentsUrl: String,
        val number: Int,
        val state: String,
        val title: String,
        val body: String
)
