package plugin.structures

import java.util.*

class GoogleCodeIssueSummaryStructure (
        val id: Int,
        val status: String,
        val summary: String,
        val labels: Array<String>,
        val stars: Int,
        val commentCount: Int
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoogleCodeIssueSummaryStructure

        if (id != other.id) return false
        if (status != other.status) return false
        if (summary != other.summary) return false
        if (!Arrays.equals(labels, other.labels)) return false
        if (stars != other.stars) return false
        if (commentCount != other.commentCount) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + status.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + Arrays.hashCode(labels)
        result = 31 * result + stars
        result = 31 * result + commentCount
        return result
    }
}