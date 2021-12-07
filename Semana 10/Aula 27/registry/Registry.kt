package registry


data class Registry(val metadata: Metadata, val entries: List<Entry>)

// Extension functions

// Calculate weeks' totals (per each line) and overall totals (last line)
fun Registry.calculate(): Registry {
    // Sum column-wise
    // Process each column
    (0..entries[0].taskTimes.size-2).forEach {  col: Int ->
        // Or, use until (upper limit is Exclusive)
    // Note: Exclude last line
//    (0 until entries[0].taskTimes.size - 1).forEach { col: Int ->
        var accTime: Time? = Time(0, 0)
        accTime = (0 until entries.size).fold(accTime) { acc: Time?, line: Int ->
            acc?.add(entries[line].taskTimes[col])
        }
        // TODO
        //replaceTime(entries[entries.size-1].taskTimes, col, accTime)
    }
//    var newEntries = this.entries
    var newEntries : List<Entry> = emptyList()
    var accTime: Time?
    newEntries = this.entries.map {
        accTime = Time(0, 0)
        accTime = it.taskTimes.fold(accTime) { acc, time ->
            acc?.add(time)
        }
        it.copy(total = accTime)
    }
    return this.copy(entries = newEntries)
}

fun Registry.updateTaskTime(line: Int, col: Int, time: Time): Registry =
    this.copy(entries = this.entries.mapIndexed { index: Int, entry: Entry ->
        if (index == line)
            entry.copy(taskTimes = replaceTime(entry.taskTimes, col, time))
        else
          entry
    })

// Return a new List with Time at column "col" replaced with "time"
fun replaceTime(times: List<Time?>, col: Int, time: Time?): List<Time> {
    TODO("Not yet implemented")
}

// Print registry
fun Registry.println() { // Has a "this" object
    this.metadata.println()
    this.entries.forEach { it.println() } // Calls extension function Entry.println()
}





















