package registry

import java.time.LocalDate


fun main() {

    var registry = createRegistry()
    // Update task time of cell (0, 1), that is, entry index = 0, task index = 1
//    registry = registry.updateTaskTime(0, 1, Time(5,5))
    // Compute total times
//    registry = registry.calculate()
    // Print registry
    registry.println()
}



fun createRegistry(): Registry =
    Registry(Metadata("Numero semana", "Periodo", listOf("Aulas ISEL", "Algebra", "PG", "Electr"), "Total Horas"),
             listOf(
                 Entry(1, LocalDate.of(2021, 1, 4), LocalDate.of(2021, 1, 10),
                            listOf(Time(22, 5), Time(4, 0), Time(5, 0), Time(3, 0))),  // Entry #0
                 Entry(2, LocalDate.of(2021, 1, 11), LocalDate.of(2021, 1, 17),
                     listOf(Time(22, 5), Time(3, 0), Time(5, 5), Time(3, 5))),  // Entry #1
                 // ... other entries
             )
        )


