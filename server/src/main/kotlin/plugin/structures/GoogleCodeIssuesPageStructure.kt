package plugin.structures

import java.util.*

data class GoogleCodeIssuesPageStructure (
        val pageNumber: Int,
        val totalPages: Int,
        val issues: Array<GoogleCodeIssueSummaryStructure>
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoogleCodeIssuesPageStructure

        if (pageNumber != other.pageNumber) return false
        if (totalPages != other.totalPages) return false
        if (!Arrays.equals(issues, other.issues)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = pageNumber
        result = 31 * result + totalPages
        result = 31 * result + Arrays.hashCode(issues)
        return result
    }
}