

fun readInt(question: String): Int {
    println(question)
    return readln().toInt()
}

fun main() {
    var list: List<Int> = emptyList()
    val len = readInt("Dimensao da lista?")
    // Read values from user
    (0..len-1).forEach {
        val value = readInt("valor?")
        list = list + value
    }
    println(list)
    // Remove 3
    list = list - 3
    println(list)
    // We could the following operators, methods, and properties
    //    list += value
    //    list -= value
    //    list[idx]
    //    list.first()
    //    list.last()
    //    list.size
    println("First: ${list.first()}")
    println("Last: ${list.last()}")
    println("Size: ${list.size}")
    // Find if a given value exist, e.g. x = 9
    val x = 9
    var found = false
    (0..list.size-1).forEach {
        if (list[it] == x)
            found = true
    }
    println("Found $x? $found")

}
/*
Dimensao da lista?
5
valor?
13
valor?
2
valor?
5
valor?
9
valor?
3
[13, 2, 5, 9, 3]
[13, 2, 5, 9]
First: 13
Last: 9
Size: 4
Found 9? true
 */












