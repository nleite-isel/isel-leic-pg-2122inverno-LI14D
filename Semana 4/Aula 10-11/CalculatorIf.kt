
fun main() {

    println("CalculatorIf")

    val op1: Double = readDouble("Introduza o 1.) operando")

    println("Introduza o operador")
    val opr: Char = readLine()!![0]

    val op2: Double = readDouble("Introduza o 2.) operando")
    var res = 0.0

    if (opr == '+')
        res = op1 + op2
    else if (opr == '-')
        res = op1 - op2
    else if (opr == '/')
        res = op1 / op2
    else if (opr == 'x')
        res = op1 * op2
    else if (opr == '%')
        res = op1 % op2
    else
        println("Operador invalido")


    println("$op1 $opr $op2 = $res")
}
/*
CalculatorIf
Introduza o 1.) operando? 3
Introduza o operador
x
Introduza o 2.) operando? 2
3.0 x 2.0 = 6.0
 */