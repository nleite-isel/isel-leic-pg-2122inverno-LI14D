
// Implementation #1
fun unique1(list: List<Int>): List<Int> {
    var unique: List<Int> = emptyList()
    var i = 0
    while (i < list.size) {
        if (list[i] !in unique)
            unique += list[i]
        ++i
    }
    return unique
}

// Implementation #2 - using nested cycle + break
fun unique2(list: List<Int>): List<Int> {
    var unique: List<Int> = emptyList()
    var i = 0
    var found: Boolean
    while (i < list.size) {
        found = false
        for (j in 0..i-1) {
            if (list[i] == list[j]) {
                found = true
                break
            }
        }
        if (!found)
            unique += list[i]
        ++i
    }
    return unique
}

// Implementation #3 - Not using break
fun unique3(list: List<Int>): List<Int> {
    var unique: List<Int> = emptyList()
    var i = 0
    var found: Boolean
    while (i < list.size) {
        found = false
        var j = i-1 // Added
//        for (j in 0..i-1) {
        while (j >= 0 && !found) { // Added
            if (list[i] == list[j]) {
                found = true
//                break
            }
            --j
        }
        if (!found)
            unique += list[i]
        ++i
    }
    return unique
}


//////////////////////////////////////////////////
// Other implementations
//
// As an extension function of List<Int>
fun List<Int>.unique4(): List<Int> {
    var unique: List<Int> = emptyList()
    this.forEach {
        // Search if current element ("elem" argument) exists at the left (seen) elements in the list
        //if (!unique.contains(it))
        if (!unique.myContains(it))
            unique += it // same as unique = unique + it
    }
    return unique
}

fun List<Int>.myContains(elem: Int): Boolean {
    this.forEach {
        if (elem == it)
            return true
    }
    // If it reaches here, "elem" was not fount ->  return false
    return false
}

// Using mapIndexNotNull
fun unique5(list: List<Int>): List<Int> {
    val unique: List<Int> = list.mapIndexedNotNull { index: Int, elem: Int -> Int
        var found = false
        // Search if current element ("elem" argument) exists at the left (seen) elements in the list
        for (i in (0..index - 1)) { // The left elements are in the range (0..index-1)
            if (list[i] == elem) {
                found = true
                break
            }
        }
        if (!found)
            elem
        else
            null
    }
    return unique
}


//////////////////////////////////////////////////

fun main() {
    /////////////////////////////////////////
    // Print unique
    val list = listOf(1, 3, 1, 4, 1, 3, 5, 4, 5)
    // "size" property
    println("list.size = ${list.size}")
    // Functions "first()" and "last()"
    println("list.first = ${list.first()}")
    println("list.last = ${list.last()}")

    println(unique1(list))
    println(unique2(list))
    println(unique3(list))
    println(list.unique4())
    println(unique5(list))
}

















