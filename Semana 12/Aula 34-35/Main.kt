
fun main(args: Array<String>) {
    //
    // Differences between Array, immutable list, mutable list
    // Based on StackOverflow thread
    //
    // Array is a colection of elements of *fixed* size but its elements *can* be mutated (changed)
    val a = arrayOf(1, 2, 3)
    a[0] = a[1] // OK
    println(a.asList())

    // Immutable list is a colection of elements of *fixed* size and its elements *cannot* be mutated (changed)
    val l = listOf(1, 2, 3)
//    l[0] = l[1] // doesn't compile

    // Mutable list is a colection of elements of *variable* size and its elements *can* be mutated (changed)
    val m = mutableListOf(1, 2, 3)
    m[0] = m[1] // OK
    println(m)


    // Arrays have fixed size and cannot expand or shrink retaining identity (you need to copy an array to resize it).
    // As to the lists, MutableList<T> has add and remove functions, so that it can increase and reduce its size.

    val arr = arrayOf(1, 2, 3)
    println(arr.size) // will always be 3 for this array

    val l1 = mutableListOf(1, 2, 3)
    l1.add(4)
    println(l1.size) // 4
    l1.removeAt(1) // Remove element at index 1
    println(l1.size) // 3
}
























