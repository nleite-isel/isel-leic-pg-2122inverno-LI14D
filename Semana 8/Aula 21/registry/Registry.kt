package registry


data class Registry(val metadata: Metadata, val entries: List<Entry>)

// Extension functions

// Calculate weeks' totals (per each line) and overall totals (last line)
fun Registry.calculate(): Registry {
    TODO("Not yet implemented")
}

fun Registry.updateTaskTime(line: Int, col: Int, time: Time): Registry =
    this.copy(entries = this.entries.mapIndexed { index: Int, entry: Entry ->
        if (index == line)
            entry.copy(taskTimes = replaceTime(entry.taskTimes, col, time))
        else
          entry
    })

// Return a new List with Time at column "col" replaced with "time"
fun replaceTime(times: List<Time>, col: Int, time: Time): List<Time> {
    TODO("Not yet implemented")
}

// Print registry
fun Registry.println() { // Has a "this" object
    this.metadata.println()
    this.entries.forEach { it.println() } // Calls extension function Entry.println()
}





















