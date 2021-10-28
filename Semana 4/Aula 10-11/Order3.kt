
fun main() {
    var first: Int
    var second: Int
    var third: Int
    // Read ints
    first = readInt("1.) valor")
    second = readInt("2.) valor")
    third = readInt("3.) valor")
    //
    // 1st process - swaps
    //
    var tmp: Int
    // swap between second, third
    if (third < second) {
        tmp = second
        second = third
        third = tmp
    }
    // swap between first, second
    if (second < first) {
        tmp = first
        first = second
        second = tmp
    }
    // swap between second, third
    if (third < second) {
        tmp = second
        second = third
        third = tmp
    }
    println("Values in increasing order: $first, $second, $third")

    //
    // 2nd process - compares
    //
//    if (first > second && first > third) {
//        if (second > third)
//            println("Values in increasing order: $third, $second, $first")
//        else
//            println("Values in increasing order: $second, $third, $first")
//    } else if (second > first && second > third) {
//        if (first > third)
//            println("Values in increasing order: $third, $first, $second")
//        else
//            println("Values in increasing order: $first, $third, $second")
//    } else { // Third is the greatest
//        if (first > second)
//            println("Values in increasing order: $second, $first, $third")
//        else
//            println("Values in increasing order: $first, $second, $third")
//    }
}
/*
1.) valor? 7
2.) valor? 3
3.) valor? 1
Values in increasing order: 1, 3, 7
 */