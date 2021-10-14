// Elabore um programa em REPL que converta graus Celsius para Fahrenheit, usando a fórmula: 
// 
// Cº = 5 * (Fº - 32) / 9 
//

fun main() {
	println("Celsius to Fahrenheit")
	println("Enter a double value representing a Celsius temperature")
//	val celsius : Double = 36.7
	// Read a line (String)
	val line: String = readLine()!!
	println("Entered line: $line")
	val celsius : Double = line.toDouble()
		
	//celsius // Print val contents in REPL only
	
	val fahrenheit : Double = (9 * celsius) / 5 + 32
	
	//fahrenheit // Print val contents in REPL only
	
	// Print results
/*	print(celsius) 
	print(" ºC é igual a ")
	print(fahrenheit)
	print(" ºF")
	println() // Send buffer to output
*/
	// Using $
	println("$celsius ºC é igual a $fahrenheit ºF")


}

/*
Compilar:

kotlinc Celsius.kt

Executar/correr interpretador JVM:

kotlin CelsiusKt

Ou:

java CelsiusKt

*/

/*
Output:

CelsiusKt 
Celsius to Fahrenheit
36.7 ºC é igual a 98.06 ºF
*/
