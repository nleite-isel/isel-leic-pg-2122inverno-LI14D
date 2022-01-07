package other

data class Pair(val first: Int, val second: Int)


fun findNumbers1(array: IntArray): Pair {
    var i = 0
    var found: Boolean = false
    var resI: Int = -1;
    var resJ: Int = -1
    while (i < array.size && !found) {
        var j = i + 1
        while (j < array.size && !found) {
            if (array[i] + array[j] == 2020) {
                resI = i
                resJ = j
                found = true
            }
            ++j
        }
        ++i
    }
    return Pair(array[resI], array[resJ])
}

fun findNumbers2(array: IntArray): Pair {
    var i = 0
//    var found: Boolean = false
//    var resI: Int = -1; var resJ: Int = -1
//    while (i < array.size && !found) {
    while (i < array.size) {
        var j = i + 1
//        while (j < array.size && !found) {
        while (j < array.size) {
            if (array[i] + array[j] == 2020) {
//                resI = i
//                resJ = j
//                found = true
                return Pair(array[i], array[j])
            }
            ++j
        }
        ++i
    }
//    return Pair(array[resI], array[resJ])
    return Pair(-1, -1)
}

fun findNumbers3(array: IntArray, criterion: (a: Int, b: Int) -> Boolean ): Pair {
    var i = 0
    while (i < array.size) {
        var j = i + 1
        while (j < array.size) {
//            if (array[i] + array[j] == 2020) {
            if (criterion(array[i], array[j])) {
                return Pair(array[i], array[j])
            }
            ++j
        }
        ++i
    }
    return Pair(-1, -1)
}

fun main() {

    val expenses = intArrayOf(
        1721,
        979,
        366,
        299,
        675,
        1456
    )

//    val pair = findNumbers1(expenses)
//    val pair = findNumbers2(expenses)
    val pair = findNumbers3(expenses, {a: Int, b: Int -> Boolean
        a + b == 2020
    } )

    println("pair.first = ${pair.first}, pair.second = ${pair.second}")
    val elvesResponse = pair.first * pair.second
    println("Elves response = $elvesResponse")

}