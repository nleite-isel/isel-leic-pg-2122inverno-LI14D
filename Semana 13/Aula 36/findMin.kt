import java.lang.Exception

fun findMin(list: List<Int>): Int {
    var min: Int
    // Set min to the first element of list (if not empty)
    if (list.isEmpty())
        throw Exception("Empty list")
    // if not empty, compute minimum
    min = list[0]
    // Compare from the second on with the current min, and update min if necessary
    for (i in 1 until list.size) {
        if (list[i] < min)
            min = list[i]
    }
    return min
}

fun findMin(array: IntArray): Int {
    var min: Int
    // Set min to the first element of list (if not empty)
    if (array.isEmpty())
        throw Exception("Empty list")
    // if not empty, compute minimum
    min = array[0]
    // Compare from the second on with the current min, and update min if necessary
    for (i in 1 until array.size) {
        if (array[i] < min)
            min = array[i]
    }
    return min
}

// Using indices
fun findMin1(array: IntArray): Int {
//    var min: Int
    var minIdx: Int
    // Set minIdx to the first index of list (if not empty)
    if (array.isEmpty())
        throw Exception("Empty list")
    // if not empty, compute minimum
//    min = array[0]
    minIdx = 0
    // Compare from the second on with the current max, and update max if necessary
    for (i in 1 until array.size) {
//        if (array[i] < min)
//            min = array[i]
        if (array[i] < array[minIdx])
            minIdx = i
    }
//    return min
    return array[minIdx]
}

fun findIndexMin(array: IntArray): Int {
    var minIdx: Int
    // Set minIdx to the first index of list (if not empty)
    if (array.isEmpty())
        throw Exception("Empty list")
    // if not empty, compute minimum
    minIdx = 0
    // Compare from the second on with the current max, and update max if necessary
    for (i in 1 until array.size) {
        if (array[i] < array[minIdx])
            minIdx = i
    }
//    return array[minIdx]
    return minIdx
}

fun main() {
    val list = listOf<Int>(10, 2, 1, 9, -3, 23, 4, -9)

    var min = findMin(list)
    println("Min = $min")

    val array = intArrayOf(10, 2, 1, 9, -3, 23, 4, -9)
    min = findMin(array)
    println("Min = $min")

    min = findMin1(array)
    println("Min = $min")

    val minIdx = findIndexMin(array)
    println("Index of Min = $minIdx")

}





