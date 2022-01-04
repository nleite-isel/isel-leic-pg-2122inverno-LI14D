
//fun main() {
//
//}


fun test(i: Int) {
    println(i)
}

fun main(args: Array<String>) {
    println("Hello World!")

    println("args.size = ${args.size}")

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    println("Program arguments: ${args.joinToString()}")

    var i = 0
    while (i < args.size) {
        print(args[i] + " ")
        ++i
    }
    val n1 = args[1].toInt() // Converts "1" to number 1

    val n2 = args[args.lastIndex].toInt() // Converts "100" to number 100

    test(n2)

//    val n0 = args[0].toInt() // Converts "ola" to number - ERROR

    println()
    println("n1 = $n1")
    println("n2 = $n2")
    /// Creating arrays
    var array: IntArray = intArrayOf(12, 1, 9, 8)
    for (i in array) {
        println(i)
    }
    array += 10 // Create a new copy with size + 1 - Not efficient. For mutations, use mutable list


}























