
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


//fun main() {
//    val list = listOf(1, 12, 3, 4, 5, 4, 4, 9)
//    val idx1 = linearSearch(list, 4)  // Get first index of number 4
//    val idx2 = linearSearch(list, 10)  // Get first index of number 4
//    println("first index of number 4: $idx1") // 4 is at index 3
//    println("first index of number 10: ${idx2}") // -1 because 10 is not in the list
//
//    println("linearSearch as an extension method")
//    val idx3 = list.linearSearch1(4)  // Get first index of number 4
//    val idx4 = list.linearSearch1( 10)  // Get first index of number 4
//    println("first index of number 4: $idx3") // 4 is at index 3
//    println("first index of number 10: ${idx4}") // -1 because 10 is not in the list
//
//}

//
// binary or dichotomic search
//
// binary search - Cost O(log2 n) - Executes a number of operations proportional to the log2(size of data)
// The list MUST be SORTED
// E.g. n = 2^10 = 1 Mega -> log2(n) = log2(2^10) = 10 -> It only executes 10 steps to find an element in a list
// with 1 Mega of size

// binary search returning boolean
// a) with array copy
// b) with indices

// a) with array copy

fun binarySearch(list: List<Int>, elem: Int): Boolean {
    // Guard or stop case
    if (list.isEmpty())
        return false
    // middle index = (left index + right index) / 2
    val middleIndex = (0 + list.size-1) / 2
    val middle = list[middleIndex]

    if (elem == middle)
        return true
    else if (elem < middle) {
        // search left subarray
        val leftSubArray = copy(list, 0, middleIndex - 1)
        return binarySearch(leftSubArray, elem) // Recursive algorithm!
    }
    else if (elem > middle) {
        // search right subarray
        val rightSubArray = copy(list, middleIndex + 1, list.size - 1)
        return binarySearch(rightSubArray, elem) // Recursive algorithm!
    }
    return false
}


fun copy(list: List<Int>, from: Int, to: Int): List<Int> {
    // Not very efficient with immutable list
    var subList = emptyList<Int>() // immutable list
    for (i in from..to) {
        subList += list[i]
    }
    return subList
}
/////////////////////////////////////////////
// binary search returning boolean
// b) with indices


// Now, it receives left and right indices
fun binarySearch1(list: List<Int>, elem: Int, left: Int, right: Int): Boolean {
    // Guard or stop case
//    if (list.isEmpty())
//        return false
    if (left > right) // Subarray is empty
        return false

    // middle index = (left index + right index) / 2
    //val middleIndex = (0 + list.size-1) / 2
    val middleIndex = (left + right) / 2
    val middle = list[middleIndex]

    if (elem == middle)
        return true
    else if (elem < middle) {
        // search left subarray
        //val leftSubArray = copy(list, 0, middleIndex - 1)
        //return binarySearch(leftSubArray, elem) // Recursive algorithm!
        return binarySearch1(list, elem, left, middleIndex - 1) // Recursive algorithm!
    }
    else if (elem > middle) {
        // search right subarray
//        val rightSubArray = copy(list, middleIndex + 1, list.size - 1)
//        return binarySearch(rightSubArray, elem) // Recursive algorithm!
        return binarySearch1(list, elem, middleIndex + 1, right) // Recursive algorithm!
    }
    return false
}



// binary search returning Int
// a) with indices

// Now, it receives left and right indices
fun binarySearch2(list: List<Int>, elem: Int, left: Int, right: Int): Int {
    // Guard or stop case
//    if (list.isEmpty())
//        return false
    if (left > right) // Subarray is empty
        return -1

    // middle index = (left index + right index) / 2
    //val middleIndex = (0 + list.size-1) / 2
    val middleIndex = (left + right) / 2
    val middle = list[middleIndex]

    if (elem == middle)
        return middleIndex
    else if (elem < middle) {
        // search left subarray
        //val leftSubArray = copy(list, 0, middleIndex - 1)
        //return binarySearch(leftSubArray, elem) // Recursive algorithm!
        return binarySearch2(list, elem, left, middleIndex - 1) // Recursive algorithm!
    }
    else if (elem > middle) {
        // search right subarray
//        val rightSubArray = copy(list, middleIndex + 1, list.size - 1)
//        return binarySearch(rightSubArray, elem) // Recursive algorithm!
        return binarySearch2(list, elem, middleIndex + 1, right) // Recursive algorithm!
    }
    return -1
}

fun main() {
    // SORTED list
    val list = listOf(1, 3, 4, 6, 7, 10, 12, 20, 33)
    val found = binarySearch(list, 4)  // Find number 4
    println("Found number 4? $found") // 4 was found
    val found1 = binarySearch(list, 21)  // Find number 21
    println("Found number 21? $found1") // 21 was not found
    // With indices
    println("With indices")
    val found2 = binarySearch1(list, 4, 0, list.size - 1)  // Find number 4
    println("Found number 4? $found2") // 4 was found
    val found3 = binarySearch1(list, 21, 0, list.size - 1)  // Find number 21
    println("Found number 21? $found3") // 21 was not found

    // With indices and returning index
    println("With indices and returning index")
    val idx1 = binarySearch2(list, 4, 0, list.size - 1)  // Find number 4
    println("Found number 4? ${idx1 != -1}") // 4 was found
    if (idx1 != -1)
        println("Found number 4 on index ${idx1}") // 4 was found

    val idx2 = binarySearch2(list, 21, 0, list.size - 1)  // Find number 4
    println("Found number 21? ${idx2 != -1}") // 21 was not found
    if (idx2 != -1)
        println("Found number 21 on index ${idx2}") // 21 was not found

}

/*
Indices:
0, 1, 2, 3, 4, 5,  6,  7,  8
List:
1, 3, 4, 6, 7, 10, 12, 20, 33

Binary Search algorithm:
- Compare elem to search with the middle elem
  * if equal, returns true
- Otherwise, if elem < middle then searchs in LEFT subarray
- Else, if elem > middle then searchs in RIGHT subarray

Elem to search = 4
Indices:
0, 1, 2, 3, 4, 5,  6,  7,  8
List:
1, 3, 4, 6, 7, 10, 12, 20, 33

middle index = left index + (right index - left index) / 2
       = (2 * left index + right index - left index) / 2
       = (left index + right index) / 2

4 == middle -> 4 == 7? false
4 < 7 -> search left subarray

left subarray: 1, 3, 4, 6

4 == middle -> 4 == 3? false

4 < 3 -> false
4 > 3 -> search right subarray

right subarray:  4, 6

4 == middle -> 4 == 4? true

 */
























