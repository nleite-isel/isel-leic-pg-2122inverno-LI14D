package adventOfCode

/*
Specifically, they need you to find the two entries that sum to 2020 and then multiply those two numbers together.

For example, suppose your expense report contained the following:

1721
979
366
299
675
1456
In this list, the two entries that sum to 2020 are 1721 and 299. Multiplying them together produces 1721 * 299 = 514579, so the correct answer is 514579.
 */

data class Pair(val first: Int, val second: Int)

// Find two numbers that satisfy a given criterion (predicate)
fun findTwoNumbers(list: List<Int>, predicate: (Int, Int) -> Boolean) : Pair? {
    var i: Int = 0
    while (i < list.size) {
        var j: Int = i + 1
        while (j < list.size) {
            if (predicate(list[i], list[j])) {
                return Pair(list[i], list[j])
            }
            ++j
        }
        ++i
    }
    return null
}


fun main() {
    // Read input into list
    var list: List<Int> = emptyList()
    var line: String?
//    while (true) {
//        line = readLine()
//        if (line != null)
//            list += line.toInt()
//        else
//            break
//    }
    // Or
    do {
        line = readLine()
        if (line != null)
            list += line.toInt()
//        else
//            break
    }
    while (line != null)

    println("Read lines OK")
    val result = findTwoNumbers(list, { num1, num2 ->  num1 + num2 == 2020 })
// Or
//    val result = findTwoNumbers(list, predicate = { num1, num2 ->  num1 + num2 == 2020 })
    if (result != null) {
        println("The two numbers that sum to 2020 are ${result.first} and ${result.second}")
        val num1 = result.first
        val num2 = result.second
        val prod = num1 * num2
        println("Multiplying them together produces ${prod}")
    }
}









