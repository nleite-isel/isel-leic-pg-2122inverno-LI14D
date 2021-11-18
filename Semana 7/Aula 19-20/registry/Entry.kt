package registry

import java.time.LocalDate

data class Entry(val weekNumber: Int, val from: LocalDate, val to: LocalDate, val taskTimes: List<Time>, val total: Time = Time(0, 0))
// NOTE: val from: LocalDate, val to: LocalDate, could be replaced by: val datePeriod: Pair<LocalDate, LocalDate>

// Extension functions