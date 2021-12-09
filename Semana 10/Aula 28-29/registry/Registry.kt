package registry


data class Registry(val metadata: Metadata, val entries: List<Entry>)

// Extension functions

// Calculate weeks' totals (per each line) and overall totals (last line)
fun Registry.calculate(): Registry {
    // Sum column-wise
    var newEntries: List<Entry> = emptyList()
    newEntries = this.entries
    newEntries = computeLastRow(newEntries)
    // Sum row-wise
    newEntries = computeRowSums(newEntries)
    // Create a new Registry object with the new entries
    return this.copy(entries = newEntries)
}

// Compute sums per row and replace the "total" column
fun computeRowSums(entries: List<Entry>): List<Entry> {
    var accTime: Time?
    val newEntries = entries.map {
        accTime = Time(0, 0)
        accTime = it.taskTimes.fold(accTime) { acc, time ->
            acc?.add(time)
        }
        it.copy(total = accTime)
    }
    return newEntries
}

fun computeLastRow(entries: List<Entry>): List<Entry> {
    var newEntries: List<Entry> = entries
    var newTimes: List<Time?> = emptyList()

    val numColumns = entries[0].taskTimes.size
    var accTime: Time? = null
    // Process each column
    (0..numColumns-1).forEach {  col: Int ->
        accTime = Time(0, 0)
        // Note: Exclude last line, so we go until size - 2 inclusive
        accTime = (0 .. entries.size-2).fold(accTime) { acc: Time?, line: Int ->
            acc?.add(newEntries[line].taskTimes[col])
        }
        // Replace time in the last row, in the corresponding column
        newTimes = replaceTime(newEntries[newEntries.size-1].taskTimes, col, accTime)
        val lastEntry = newEntries.last()
        newEntries = newEntries - lastEntry + lastEntry.copy(taskTimes = newTimes)
    }
    return newEntries
}



fun Registry.updateTaskTime(line: Int, col: Int, time: Time): Registry =
    this.copy(entries = this.entries.mapIndexed { index: Int, entry: Entry ->
        if (index == line)
            entry.copy(taskTimes = replaceTime(entry.taskTimes, col, time))
        else
          entry
    })

// Return a new List with Time at column "col" replaced with "time"
fun replaceTime(times: List<Time?>,
                col: Int, newTime: Time?): List<Time?> =
    times.mapIndexed { index, time ->
        if (index == col)
            newTime
        else
            time
    }

// Print registry
fun Registry.println() { // Has a "this" object
    this.metadata.println()
    this.entries.forEach { it.println() } // Calls extension function Entry.println()
}





















