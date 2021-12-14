

enum class PaymentStatus(val value: Int) {
    PAID(1),
    UNPAID(2)
}

fun f(x: Int): String  {
    val foo = when (x) {
        PaymentStatus.PAID.value -> "PAID"
        PaymentStatus.UNPAID.value -> "UNPAID"
        else -> throw IllegalStateException()
    }
    return foo
}

fun fEnum(status: PaymentStatus): String {
    val foo = when (status) {
        PaymentStatus.PAID -> "PAID"
        PaymentStatus.UNPAID -> "UNPAID"
        else -> throw IllegalStateException()
    }
    return foo
}

fun main() {
    println("Testing with ints")
    println(f(1))
    println(f(2))
    println(f(3)) // Exception

    // With enum
    println("Testing with enums")
    println(fEnum(PaymentStatus.PAID))
    println(fEnum(PaymentStatus.UNPAID))
}