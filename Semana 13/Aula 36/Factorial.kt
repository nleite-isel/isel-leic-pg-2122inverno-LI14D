
fun factorial(n: Int): Int {
    return if (n == 0 || n == 1)
        1
    else
        n * factorial(n - 1)
}

fun main(args: Array<String>) {
    val f4 = factorial(4)
    println("Factorial of 4 is $f4")
}
