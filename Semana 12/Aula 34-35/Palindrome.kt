// Not so efficient
fun isPalindrome1(string: String) =
    string.reversed() == string

fun isPalindrome2(string: String): Boolean {
    var i = 0;
//    var j = string.lastIndex // OK
    var j = string.length - 1 // OK
    var palindrome = true
    while (i < j && palindrome) {
        if (string[i] != string[j])
            palindrome = false
        ++i
        --j
    }
    return palindrome
}

fun isPalindrome3(string: String): Boolean {
    var i = 0;
//    var j = string.lastIndex // OK
    var j = string.length - 1 // OK
    while (i < j) {
        if (string[i] != string[j])
            return false
        ++i
        --j
    }
    return true
}

fun String.myReversed(): String {
    var reversed = ""
    for (j in this.lastIndex downTo 0)
        reversed += this[j]
    return reversed
}

fun String.myReversed1(): String {
    // c in "rada"
    // c == 'r', acc = "" -> res = "r"
    // c == 'a', acc = "r" -> res = "ar"

    var reversed = this.fold("", {acc: String, c: Char -> String
        c + acc
    })

    return reversed
}




// A string is a palindrome if we can read it from left to right and right to left
// in the same way
fun main() {
    val string = "radar"
    val string1 = "rada"
    val string2 = "xpto"

//    val string = "ana"
//    println(isPalindrome1(string))
    println(isPalindrome2(string))
    println(isPalindrome2(string1))


    println(string1.myReversed())
    println(string1.myReversed1())
    println(string.myReversed1())
    println(string2.myReversed1())





}



















