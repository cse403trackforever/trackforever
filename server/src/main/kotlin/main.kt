import plugin.GitHubPlugin
import plugin.GoogleCodePlugin

fun main(args: Array<String>) {
    println("test")

    GitHubPlugin("cse403trackforever", "trackforever").import() // -> OUR STRUCT
    GoogleCodePlugin("migratordotnet").import()
}

fun factorial(n: Int): Int {
    var result = 1
    for (i in 2..n)
        result *= i
    return result
}