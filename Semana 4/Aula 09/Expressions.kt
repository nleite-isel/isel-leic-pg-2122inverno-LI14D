
fun main() {
    val j: Int = 10
    //val i: Int = (12.33f + j) * 10.0; // Erro, tipos incompatíveis; tipo da expressão: double
    val i: Double = (12.33f + j) * 10.0 // OK
    val i1: Int = ((12.33f + j) * 10.0).toInt() // OK, cast de double para int
    println("i = $i")
    println("i1 = $i1")

    //val i2: Int = (12.33f + j) * 10.0f; // Erro, tipos incompatíveis; tipo da expressão: float
    val i2: Float = (12.33f + j) * 10.0f
    println("i2 = $i2")
}
/*
OUTPUT:
i = 223.29999923706055
i1 = 223
i2 = 223.3
*/
