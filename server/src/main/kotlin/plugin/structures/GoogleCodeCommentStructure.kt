package plugin.structures

import java.util.*

data class GoogleCodeCommentStructure(
        val id: Int,
        val commenterId: Long,
        val content: String,
        val timestamp: Int,
        val attachments: Array<GoogleCodeAttachmentStructure> = emptyArray()
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoogleCodeCommentStructure

        if (id != other.id) return false
        if (commenterId != other.commenterId) return false
        if (content != other.content) return false
        if (timestamp != other.timestamp) return false
        if (!Arrays.equals(attachments, other.attachments)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + commenterId.hashCode()
        result = 31 * result + content.hashCode()
        result = 31 * result + timestamp
        result = 31 * result + Arrays.hashCode(attachments)
        return result
    }
}
