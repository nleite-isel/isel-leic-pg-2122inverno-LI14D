fun main() {
    val d = 1.0
    // double d1 = 2.0/3 + 1.0/3;   // d == d1 -> true
    // double d1 = 1.1 - 0.1;   // d == d1 -> true
    val d1 = 0.66666 + 0.33333 // d == d1 -> false
    // double d1 = 0.6666666666666666 + 0.3333333333333333;  // d == d1 -> true
    println("d = $d")
    println("d1 = $d1")
    println("d == d1 ->" + (d == d1))
    println(1.0 / 3)
    println(0.33333)
    println(1.0 / 3 == 0.33333)
    println(1.0 / 3 > 0.33333)
    println(1.0 / 3 == 0.3333333333333333)
    println("100.0 + 100.33 = " + (100.0 + 100.33)) // 200.3299999....  Este numero nao tem representacao exacta em binario
    val d4 = 100.33
    val d2 = 100.0 + 100.33
    val d3 = 200.330
    println("d4 = $d4")
    println("d2 = $d2")
    println("d3 = $d3")

    if (d3 == d2) 
        println("200.330 == 100.0 + 100.33")
    else 
    	println("Nao sao iguais")

    // Comparar doubles com uma dada precisão ou erro
    val epsilon = 1e-3
    if (Math.abs(d3 - d2) <= epsilon) {
        println("200.330 - (100.0 + 100.33) = " + (d3 - d2))
        println("200.330 == 100.0 + 100.33 com erro 1e-3")
    } else println("Nao sao iguais")
}


/*
$ kotlin DoubleProblemKt
d = 1.0
d1 = 0.99999
d == d1 ->false
0.3333333333333333
0.33333
false
true
true
100.0 + 100.33 = 200.32999999999998
200.330 - (100.0 + 100.33) = 2.8421709430404007E-14
200.330 == 100.0 + 100.33 com erro 1e-3
 
 */
