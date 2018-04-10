import plugin.GitHubPlugin
import plugin.GoogleCodePlugin

fun main(args: Array<String>) {
    println("test")

    GitHubPlugin("cse403trackforever", "trackforever").import()
    GoogleCodePlugin("migratordotnet").import()
}