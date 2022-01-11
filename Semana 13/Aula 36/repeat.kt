
// Kotlin's fun repeat(times: Int, action: (Int) -> Unit)
//Executes the given function action specified number of times.
//
//A zero-based index of current iteration is passed as a parameter to action.
// greets three times
//repeat(3) {
//    println("Hello")
//}
//
// greets with an index
//repeat(3) { index ->
//    println("Hello with index $index")
//}
fun repeat(times: Int, action: (Int) -> Unit) {
    println("PG repeat function")
//    var i = 0
//    while (i < times) {
//        action(i)
//        ++i
//    }
    // OR:
    for (i in 0 until times) {
        action(i)
    }
}


fun main() {
    // greets three times
    repeat(3) {
        println("Hello")
    }
    repeat(3) {
        println("Hello with it = $it")
    }

    // greets with an index
    repeat(3) { index ->
        println("Hello with index $index")
    }
}








