import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

fun testEven(n :Int) = assertTrue(isEven(n),"$n must be even")
fun testOdd(n :Int) = assertFalse(isEven(n),"$n must be odd")

class TestIsEven {
    @Test fun zeroIsEven() = testEven(0)
    @Test fun oneIsOdd() = testOdd(1)
    @Test fun severalEven() {
        listOf(2,4,6,10,100,-2,-10).forEach { testEven(it) }
    }
    @Test fun severalOdd() {
        listOf(3,5,9,17,103,-1,-3).forEach { testOdd(it) }
    }
}

