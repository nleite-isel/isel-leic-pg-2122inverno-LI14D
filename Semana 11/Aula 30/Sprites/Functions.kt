import kotlin.random.Random

data class Robot(val name: String, val strength: Int)


fun createRobots(): List<Robot> {
    val participants = listOf<Robot>(
        Robot("Extra-Terrestrial Neutralization Bot", 10),
        Robot("Generic Evasion Droid", 20),
//        Robot("Dummy 1", 20),
//        Robot("Dummy 2", 20),
        Robot("Self-Reliant War Management Device", 10),
        Robot("Advanced Nullification Android", 30),
        Robot("Rational Network Defense Droid", 10),
        Robot("Motorized Shepherd Cyborg", 5),
        Robot("Reactive Algorithm Entity", 5),
        Robot("Ultimate Safety Guard Golem", 20),
        Robot("Nuclear Processor Machine", 20),
        Robot("Preliminary Space Navigation Machine", 10)
    )
    return participants
}


fun main() {
    //////////////////////////////////////////////
    // Example 1
    var myList = listOf<Int>()
    for (i in 1..10) {
        myList += (1..100).random()
    }
    val topNumbers = myList
        .filter { it > 50 }
        .take(3)
//        .sortedBy { -it } // Descending order
        .sortedBy { it } // Ascending order


    println("topNumbers = $topNumbers")
    //////////////////////////////////////////////
    // Example 2
    val participants = createRobots()

    val topRobots = participants
        // 1 - filter robots which have strength > 10
        .filter { it.strength > 10 }
        // 2 - From the previous result, take the first 3 elements
        .take(3)
        // 3 - From the previous result, sort by name
        .sortedBy { it.name }
    // Or, written in one line>
    val topRobots1 = participants.filter { it.strength > 10 }.take(3).sortedBy { it.name }

    println("topRobots = $topRobots")
    println("topRobots1 = $topRobots1")

    //////////////////////////////////////////////
    // Example 3
    val randomValues = List(10) { Random.nextInt(0, 100) }
    // prints new sequence every time
    println("randomValues = $randomValues")
    // Shuffle values in the list
    println("randomValues.shuffled() = ${randomValues.shuffled()}")

    val listFromRange = (0..10).toList()
    println("listFromRange = $listFromRange")
    // Shuffle values in the list
    println("listFromRange.shuffled() = ${listFromRange.shuffled()}")

    val randomValues1 = List(10) { Random.nextInt(0, 5) }
    // prints new sequence every time
    println("randomValues = $randomValues1")
    // Get distinct
    println("randomValues.distinct() = ${randomValues1.distinct()}")
}
















