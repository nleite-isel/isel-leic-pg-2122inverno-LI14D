
// indexOf
//fun <T> List<T>.indexOf(element: T): Int
//Returns first index of element, or -1 if the list does not contain element.

//fun main() {
//    val list = listOf(1, 12, 3, 4, 5, 4, 4, 9)
//    val idx = list.indexOf(4)  // Get first index of number 4
//    println("first index of number 4: $idx") // 4 is at index 3
//    println("first index of number 10: ${list.indexOf(10)}") // -1 because 10 is not in the list
//}

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

// linearSearch as an extension method
fun List<Int>.linearSearch1(elem: Int): Int {
    for (i in 0 until this.size) {
        if (this[i] == elem)
            return i
    }
    return -1 // Element not found
}


fun main() {
    val list = listOf(1, 12, 3, 4, 5, 4, 4, 9)
    // Function linearSearch is equivalent to indexOf

    val idx1 = linearSearch(list, 4)  // Get first index of number 4
    val idx2 = linearSearch(list, 10)  // Get first index of number 4
    println("first index of number 4: $idx1") // 4 is at index 3
    println("first index of number 10: ${idx2}") // -1 because 10 is not in the list

    println("linearSearch as an extension method")
    val idx3 = list.linearSearch1(4)  // Get first index of number 4
    val idx4 = list.linearSearch1( 10)  // Get first index of number 4
    println("first index of number 4: $idx3") // 4 is at index 3
    println("first index of number 10: ${idx4}") // -1 because 10 is not in the list

}
























