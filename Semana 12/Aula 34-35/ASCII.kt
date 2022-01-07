

fun main() {

    println("Code\tCharacter")

    for (i in 32..127) {
        val code = i
        val character = i.toChar()
        println("$code\t$character")
    }

}