package plugin.structures

import java.util.*

data class GoogleCodeIssueStructure(
        val id: Int,
        val status: String,
        val summary: String,
        val labels: Array<String>,
        val stars: Int,
        val commentCount: Int,
        val comments: Array<GoogleCodeCommentStructure> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoogleCodeIssueStructure

        if (id != other.id) return false
        if (status != other.status) return false
        if (summary != other.summary) return false
        if (!Arrays.equals(labels, other.labels)) return false
        if (stars != other.stars) return false
        if (commentCount != other.commentCount) return false
        if (!Arrays.equals(comments, other.comments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + status.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + Arrays.hashCode(labels)
        result = 31 * result + stars
        result = 31 * result + commentCount
        result = 31 * result + Arrays.hashCode(comments)
        return result
    }
}