package plugin.structures

import java.util.*

data class TrackForeverIssueStructure(
        val id: String,
        val projectId: String,
        val status: String,
        val summary: String,
        val labels: Array<String> = emptyArray(),
        val comments: Array<TrackForeverCommentStructure> = emptyArray(),
        val submitterName: String,
        val assignees: Array<String> = emptyArray(),
        val timeCreated: Long,
        val timeUpdated: Long,
        val timeClosed: Long
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as TrackForeverIssueStructure

        if (id != other.id) return false
        if (projectId != other.projectId) return false
        if (status != other.status) return false
        if (summary != other.summary) return false
        if (!Arrays.equals(labels, other.labels)) return false
        if (!Arrays.equals(comments, other.comments)) return false
        if (submitterName != other.submitterName) return false
        if (!Arrays.equals(assignees, other.assignees)) return false
        if (timeCreated != other.timeCreated) return false
        if (timeUpdated != other.timeUpdated) return false
        if (timeClosed != other.timeClosed) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + projectId.hashCode()
        result = 31 * result + status.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + Arrays.hashCode(labels)
        result = 31 * result + Arrays.hashCode(comments)
        result = 31 * result + submitterName.hashCode()
        result = 31 * result + Arrays.hashCode(assignees)
        result = 31 * result + timeCreated.hashCode()
        result = 31 * result + timeUpdated.hashCode()
        result = 31 * result + timeClosed.hashCode()
        return result
    }
}