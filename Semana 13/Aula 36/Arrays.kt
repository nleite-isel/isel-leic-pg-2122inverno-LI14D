


fun main() {
    val size = 10
    val arrayOfZeros = IntArray(size) //equivalent in Java: new int[size]
    // Creates a new array of the specified size, where each element is calculated by calling the specified init function.
    // The function init is called for each array element sequentially starting from the first one.
    // It should return the value for an array element given its index.
    val numbersFromOne = IntArray(size) { it + 1 } // Initializes element with index value + 1
    val myInts = intArrayOf(1, 1, 2, 3, 5, 8, 13, 21)

    println(arrayOfZeros) // Prints char denoting the type of element stored + ID object
    // To print array contents, we need to perform a cycle
    for (i in arrayOfZeros) {
        print("$i ")
    }
    println()

    for (i in numbersFromOne) {
        print("$i ")
    }
    println()

    for (i in myInts) {
        print("$i ")
    }
    println()
    /////////////////////////////////////////////////////////////
    println("Array of objects")
    // Array of objects
    val nulls = arrayOfNulls<String>(size) //equivalent in Java: new String[size]
    val strings = Array(size) { "n = $it" }
    val myStrings = arrayOf("foo", "bar", "baz")

    val boxedInts = arrayOfNulls<Int>(size) //equivalent in Java: new Integer[size]
    val boxedZeros = Array(size) { 0 }
    // To print array contents, we need to perform a cycle
    for (i in nulls) {
        print(i.toString() + " ")
    }
    println()

    for (i in strings) {
        print("$i ")
    }
    println()

    for (i in myStrings) {
        print("$i ")
    }
    println()

    for (i in boxedInts) {
        print(i.toString() + " ")
    }
    println()

    for (i in boxedZeros) {
        print("$i ")
    }
    println()
    /////////////////////////////////////////////////////////////
    // Manipulating arrays
    println(myInts[0])

    myInts[0] = 99
    for (i in myInts) {
        print("$i ")
    }
    println()

    // Array size is FIXED
}


























