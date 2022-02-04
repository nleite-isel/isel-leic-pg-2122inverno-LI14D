

// linearSearch/find

// linear search - Cost O(n) - Executes a number of operations proportional to the size of data
// The list could be sorted or unsorted - does not matter
//
// fun linearSearch is equivalent to indexOf -> returns the index of an element or -1 if not found.
// Searches linearly across the list
fun linearSearch(list: List<Int>, elem: Int): Int {
    for (i in 0 until list.size) {
        if (list[i] == elem)
            return i
    }
    return -1 // Element not found
}

// linear search - Recursive way
// Call index is incremented by each recursive call
fun linearSearchRec1(list: List<Int>, elem: Int, callIndex: Int = 0): Int {
    // Guard or Stop case
    if (list.isEmpty())
        return -1 // Element not found

    // Check if the first element is equal to the list head
    if (list[0] == elem)
        return callIndex
    // If elem not equal to list head, LINEAR SEARCH the elem in the REMAINDER of the list
//    return linearSearchRec1(copy(list, 1, list.size - 1), elem, callIndex + 1)
    // Or:
    val remainderList = copy(list, 1, list.size - 1)
    return linearSearchRec1(remainderList, elem, callIndex + 1)
}

fun copy(list: List<Int>, from: Int, to: Int): List<Int> {
    // Not very efficient with immutable list
    var subList = emptyList<Int>() // immutable list
    for (i in from..to) {
        subList += list[i]
    }
    return subList
}


fun main() {
//    val range = 1..0
//    for (i in range)
//        println(i)
    val list = listOf(1, 20, 3, 32, 4, 6, 7, 10, 12, 20, 33)
    // With indices and returning index
    println("With indices and returning index")
    val idx1 = linearSearchRec1(list, 33, 0)  // Find number 4
    println("Found number 33? ${idx1 != -1}") // 4 was found
    if (idx1 != -1)
        println("Found number 4 on index ${idx1}") // 4 was found

    val idx2 = linearSearchRec1(list, 21)  // Find number 4
    println("Found number 21? ${idx2 != -1}") // 21 was not found
    if (idx2 != -1)
        println("Found number 21 on index ${idx2}") // 21 was not found
}

















