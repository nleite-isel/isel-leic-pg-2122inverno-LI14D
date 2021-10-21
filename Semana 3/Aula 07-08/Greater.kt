


// Correcao do T.P.C.

fun main() {
//    val num1 = readInt("1. Numero")
//    val num2 = readInt("2. Numero")
//
//    // Greater2
//    val greater : Int
//    if (num1 > num2)
//        greater = num1
//    else
//        greater = num2
//
//    println("O maior entre $num1 e $num2 e' $greater")
    ///////////////////////////////////////////

    // Greater3
//    val num1 = readInt("1. Numero")
//    val num2 = readInt("2. Numero")
//    val num3 = readInt("3. Numero")

    // 1. Implementacao
//    val greater : Int
//    if (num1 > num2 && num1 > num3)
//        greater = num1
//    else if (num2 > num1 && num2 > num3)
//        greater = num2
//    else
//        greater = num3

    // 2. Implementacao
    /*
    num1    num2     num3
      \    /          /
      greater        /
           \        /
            \      /
             greater1
*/

//    val greater : Int
//    if (num1 > num2)
//        greater = num1
//    else
//        greater = num2
//
//    val greater1 : Int
//    if (num3 > greater)
//        greater1 = num3
//    else
//        greater1 = greater
//
//    println("O maior entre $num1, $num2, e $num3 e' $greater1")

    /////////////////////////////////////////////
//    val num1 = readInt("1. Numero")
//    val num2 = readInt("2. Numero")
//    // Greater2
//
//    val greater = greater2(num1, num2)
//
//    println("O maior entre $num1 e $num2 e' $greater")

    // Greater3
    val num1 = readInt("1. Numero")
    val num2 = readInt("2. Numero")
    val num3 = readInt("3. Numero")

    val greater = greater3(num1, num2, num3)

    println("O maior entre $num1, $num2, e $num3 e' $greater")

}

fun greater3(num1: Int, num2: Int, num3: Int): Int {
    val greater = greater2(num1, num2)
    return greater2(greater, num3)
}

fun greater2(num1: Int, num2: Int) : Int {
    val greater : Int
    if (num1 > num2)
        greater = num1
    else
        greater = num2
    return greater
}









