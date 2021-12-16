package registry

import java.time.LocalDate


fun main() {
    var registry = loadRegistryFromFile()
//    var registry = createRegistry()
    // Update task time of cell (0, 1), that is, entry index = 0, task index = 1
    registry = registry?.updateTaskTime(0, 1, Time(5,5))
    // Compute total times
    registry = registry?.calculate()
    // Print registry
    registry?.println()
}

fun loadRegistryFromFile(): Registry?  {
    var line: String?
    var first = true
    var metadata: Metadata? = null
    var entries: List<Entry> = emptyList()
    do {
        //line = readlnOrNull()
        line = readLine() // If End Of File (EOF) is reached, null is returned
        if (line != null) {
            println(line)
            // Split line using as delimiter ","
            val tokens = line.split(",")
            println(tokens)
            // TODO - process line and build registry
            if (first) { // It is the first line, so build a Metadata object with the line
                first = false
                metadata = buildMetadataRow(tokens)
                /// TEST - Return immediately
//                return Registry(metadata, emptyList())
            }
            else { // It is an entry, so build an Entry object
                val entry: Entry = buildEntryRow(tokens)
                entries += entry
            }
        }
    }
    while (line != null)
    if (metadata != null)
        return Registry(metadata, entries)
    else
        return null
}

fun buildEntryRow(tokens: List<String?>): Entry =
    Entry(if (tokens[0] == "null")
        null
            else tokens[0]?.toInt(),
        if (tokens[1] != "null")
            LocalDate.parse(tokens[1])
        else
            null,
        if (tokens[2] != "null")
            LocalDate.parse(tokens[2])
        else
            null,
        buildTaskTimesList(tokens))

fun buildTaskTimesList(tokens: List<String?>): List<Time?> {
    var list = emptyList<Time?>()
    for (i in 3..tokens.size - 1) {
        if (tokens[i] != "null") {
            val components = tokens[i]?.split(':') // [hh, min]
            if (components != null)
                list += Time(components[0]?.toInt(), components[1].toInt())
        }
        else
            list += null
    }
    return list
}

fun buildMetadataRow(tokens: List<String>): Metadata =
    registry.Metadata(tokens[0],tokens[1], getTaskNamesList(tokens), tokens.last())

fun getTaskNamesList(tokens: List<String>): List<String> {
    var list = emptyList<String>()
    for (i in 2..tokens.size - 2)
        list += tokens[i]
    return list
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


