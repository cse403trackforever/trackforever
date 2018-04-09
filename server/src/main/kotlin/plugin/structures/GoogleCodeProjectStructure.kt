package plugin.structures

import java.util.*

data class GoogleCodeProjectStructure(
        val domain: String,
        val name: String,
        val summary: String,
        val description: String,
        val stars: Int,

        /*
        This one doesn't appear in the schema in code.google.com/archive/schema
        but it appears anyway in
        https://storage.googleapis.com/google-code-archive/v2/code.google.com/hg4j/project.json
        It seems to be the same as contentLicense.
         */
        val license: String? = null,

        val contentLicense: String,
        val labels: Array<String>,
        val links: Array<GoogleCodeLinkStructure> = emptyArray(),
        val blogs: Array<GoogleCodeLinkStructure> = emptyArray(),
        val creationTime: Int? = null,
        val hasSource: Boolean,
        val repoType: String,
        val subrepos: Array<String> = emptyArray(),
        val ancestorRepo: String? = null,
        val logoName: String? = null,
        val imageUrl: String? = null,
        val movedTo: String? = null
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as GoogleCodeProjectStructure

        if (domain != other.domain) return false
        if (name != other.name) return false
        if (summary != other.summary) return false
        if (description != other.description) return false
        if (stars != other.stars) return false
        if (license != other.license) return false
        if (contentLicense != other.contentLicense) return false
        if (!Arrays.equals(labels, other.labels)) return false
        if (!Arrays.equals(links, other.links)) return false
        if (!Arrays.equals(blogs, other.blogs)) return false
        if (creationTime != other.creationTime) return false
        if (hasSource != other.hasSource) return false
        if (repoType != other.repoType) return false
        if (!Arrays.equals(subrepos, other.subrepos)) return false
        if (ancestorRepo != other.ancestorRepo) return false
        if (logoName != other.logoName) return false
        if (imageUrl != other.imageUrl) return false
        if (movedTo != other.movedTo) return false

        return true
    }

    override fun hashCode(): Int {
        var result = domain.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + summary.hashCode()
        result = 31 * result + description.hashCode()
        result = 31 * result + stars
        result = 31 * result + (license?.hashCode() ?: 0)
        result = 31 * result + contentLicense.hashCode()
        result = 31 * result + Arrays.hashCode(labels)
        result = 31 * result + Arrays.hashCode(links)
        result = 31 * result + Arrays.hashCode(blogs)
        result = 31 * result + (creationTime ?: 0)
        result = 31 * result + hasSource.hashCode()
        result = 31 * result + repoType.hashCode()
        result = 31 * result + Arrays.hashCode(subrepos)
        result = 31 * result + (ancestorRepo?.hashCode() ?: 0)
        result = 31 * result + (logoName?.hashCode() ?: 0)
        result = 31 * result + (imageUrl?.hashCode() ?: 0)
        result = 31 * result + (movedTo?.hashCode() ?: 0)
        return result
    }
}