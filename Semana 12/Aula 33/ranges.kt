

// ranges with until and downto keywords

const val MAX_LIMIT = 5

fun main() {
    val myRange = 0..MAX_LIMIT  // MAX_LIMIT *is* included
    val myRangeUntil = 0 until MAX_LIMIT  // MAX_LIMIT *is not* included

    println("for with range:")
    for (i in myRange) {
        println("Hello index $i")
    }

    println("for with range with until:")
    for (i in myRangeUntil) {
    // Or:
//    for (i in 0 until MAX_LIMIT) {
        println("Hello index $i")
    }

    val myRangeDownTo = MAX_LIMIT downTo 0  // Inferior limit *is* included

    println("for with range with downTo:")
//    for (i in myRangeDownTo) {
    // Or:
    for (i in MAX_LIMIT downTo 0) {
        println("Hello index $i")
    }

}