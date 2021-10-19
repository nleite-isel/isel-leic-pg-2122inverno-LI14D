fun main() {

	println("Introduza uma palavra, onde vai ser extraido o primeiro caracter")
	val line: String = readLine()!! // Read a line
	val char: Char = line[0] // Gets first char of line
	
	// Test if char is an uppercase letter
	// Operator && is the Logic AND
 	if (char >= 'A' && char <= 'Z') {
 		println("Letra maiuscula: $char")
 		val lowerChar: Char = char + 32 // Adds offset 32
 		// Or, add the SPACE which has code = 32
 		// val lowerChar: Char = (char.code + ' '.code).toChar() // Adds offset 32
 		// val lowerChar: Char = (char.toInt() + ' '.toInt()).toChar() // Adds offset 32 (toInt() will be deprecated)
 		// val lowerChar: Char = char + ' '.code // Adds offset 32
 		println("$char convertido para minuscula e': $lowerChar")
 	}
 	else if (char >= 'a' && char <= 'z') {
 		println("Letra minuscula: $char")
 		val upperChar: Char = char - 32 // Subtracts offset 32
 		println("$char convertido para maiuscula e': $upperChar")
 	}
 	else {
 		println("$char nao e' uma letra")
 	}
	
}




















