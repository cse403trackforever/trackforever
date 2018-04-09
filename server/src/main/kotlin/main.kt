import plugin.GitHubPlugin
import plugin.GoogleCodePlugin

fun main(args: Array<String>) {
    println("test")

    GoogleCodePlugin("hg4j").import()

    GitHubPlugin("cse403trackforever", "trackforever").import()
}