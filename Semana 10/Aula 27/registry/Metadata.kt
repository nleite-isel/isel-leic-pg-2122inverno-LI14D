package registry


data class Metadata(val week: String, val datePeriod: String, val taskNames: List<String>,
                    val total: String)

// Extension functions
fun Metadata.println() {
    // Note:
    // this.println()
    // Or
//    println() // without parameters are recursive calls!
//    registry.println() // Error, println is not a global function of package registry, but
    // instead an extension of Metadata (which is in package registry)
    //kotlin.io.println() // OK, calls println of kotlin.io package
    kotlin.io.print("${this.week}\t${this.datePeriod}\t")
    printTaskNames(this.taskNames)
    kotlin.io.println("${this.total}")
}

fun printTaskNames(taskNames: List<String>): Unit =
    taskNames.forEach { print("${it}\t") }


fun main() {
    val metadata = Metadata("Numero semana", "Periodo",
        listOf("Aulas ISEL", "Algebra", "PG", "Electr"), "Total Horas")
    metadata.println()
}