
// Realize um programa que dado um número n composto por três dígitos calcule a soma entre os seus dígitos. 
// 
// Exemplo: se  n = 156, então a soma dos seus dígitos será 12.

fun main() {
	println("Sum Digits")
	println("Enter an integer")
	//val n = 123
	//val n = 124
	//val n: Int = readLine()!!   // Error, readLine gets a String, not an Int
	val n: Int = readLine()!!.toInt()  // Converts string into Int
	
	val dig1 = n % 10 // Digit 1
	val quoc1 = n / 10 // Quotient 1
	
	val dig2 = quoc1 % 10 // Digit 2
	val quoc2 = quoc1 / 10 // Quotient 2
	
	val dig3 = quoc2 % 10 // Digit 3
	val quoc3 = quoc2 / 10 // Quotient 3

	val sum = dig1 + dig2 + dig3
	
	print("n = $n, então a soma dos seus dígitos será $sum\n") // '\n' is a newline
	println() // newline
}
	
/*
Output:

Sum Digits
n = 123, então a soma dos seus dígitos será 6

*/
