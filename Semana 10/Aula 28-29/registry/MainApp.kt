package registry

import java.time.LocalDate


fun main() {
    var registry = loadRegistryFromFile()

//    var registry = createRegistry()
    // Update task time of cell (0, 1), that is, entry index = 0, task index = 1
//    registry = registry.updateTaskTime(0, 1, Time(5,5))
//    // Compute total times
//    registry = registry.calculate()
//    // Print registry
//    registry.println()
}

fun loadRegistryFromFile(): Registry?  {
    var line: String?
    do {
        //line = readlnOrNull()
        line = readLine() // If End Of File (EOF) is reached, null is returned
        if (line != null) {
            println(line)
            // Split line using as delimiter ","
            val tokens = line.split(",")
            println(tokens)
            // TODO - process line and build registry
        }
    }
    while (line != null)
    return null
}


fun createRegistry(): Registry =
    Registry(Metadata("Numero semana", "Periodo", listOf("Aulas ISEL", "Algebra", "PG", "Electr"), "Total Horas"),
             listOf(
                 Entry(1, LocalDate.of(2021, 1, 4), LocalDate.of(2021, 1, 10),
                            listOf(Time(22, 5), Time(4, 0), Time(5, 0), Time(3, 0))),  // Entry #0
                 Entry(2, LocalDate.of(2021, 1, 11), LocalDate.of(2021, 1, 17),
                     listOf(Time(22, 5), Time(3, 0), Time(5, 5), Time(3, 5))),  // Entry #1
                 // ... other entries
                // Last row containing totals
                 Entry(null, null, null,
                     listOf(null, null, null, null),null),  // Entry #N-1
             )
        )


