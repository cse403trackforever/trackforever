package plugin

import com.beust.klaxon.Klaxon
import plugin.structures.GoogleCodeIssueStructure
import java.net.URL

class GoogleCodePlugin(projectName: String): Plugin {
    private val urlTemplate = "https://storage.googleapis.com/google-code-archive/v2/code.google.com/$projectName"

    override fun import() {

        // get issue
        // url format https://storage.googleapis.com/google-code-archive/v2/code.google.com/hg4j/issues-50.json
        val issueNum = 50
        val url = URL("$urlTemplate/issues/issue-$issueNum.json")
        val issue = Klaxon().parse<GoogleCodeIssueStructure>(url.openStream())

        println(issue)


        // TODO: return our data structure
    }

    override fun export() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}