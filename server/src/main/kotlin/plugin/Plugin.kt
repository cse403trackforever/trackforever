package plugin

interface Plugin {

    // TODO: add return type for our data structure
    fun import()

    // TODO: is this necessary?
    fun export()

    // TODO: add pass through testing method to avoid http requests when testing
    // fun testImport()
}