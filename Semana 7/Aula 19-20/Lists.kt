

fun main() {
    //
    // Iterating over collections with lambdas
    //
    // In Kotlin, collections implement some very handy features often associated with
    // functional programming. These features come in the shape of functions that you
    // can apply to a collection to perform an operation on it.
    // Operations include things like transforming each element or filtering out certain
    // elements. These functions make use of lambdas.
    // The first of these functions, forEach, lets you loop over the elements in a collection
    // and perform an operation like so:
    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach {
        println("$it: ${it * it}")
    }
    // 1: 1
    // 2: 4
    // 3: 9
    // 4: 16
    // 5: 25
    // 6: 36


    //
    // "filter" function
    //
    // Another function allows you to filter out certain elements:
    var prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)
    val largePrices = prices.filter {
        it > 5.0
    }
    // filter function returns a List of the inferred type (Double)
    println(largePrices)
    // The filter function looks like so:
    // public inline fun <T> Iterable<T>.filter(predicate: (T) ->
    // Boolean): List<T>
    //
    // The lambda’s job for filter is to return true or false depending on whether or not
    // the value should be kept or not. The list returned from filter will contain all
    // elements for which the lambda returned true.
    // In the example, largePrices will contain:
    // [10.0, 8.19]
    // Note: The array that is returned from filter (and all of these functions) is a
    // new array. The original is not modified at all.

    //
    // "map" function
    //
    println("prices list:")
    prices.forEach {
        println("$it")
    }
    // Imagine you’re having a sale and want to discount all items to 90% of their original
    // price. There’s a handy function named map which can achieve this:
    val salePrices = prices.map {
        it * 0.9 // each element of the output list will be a double
//        it.toInt() // Just an example...
                   // each element of the output list will be an int
    }
    // The map function will take a lambda, execute it on each item in the list and return a
    // new list containing each result with the order maintained. In this case, salePrices
    // will contain:
    // [1.35, 9.0, 4.4910000000000005, 2.07, 7.3709999999999996]
    println("salePrices list with 10% discount:")
    salePrices.forEach {
        println("$it")
    }
    // The map function can also be used to change the type.
    // You can do that like so:
    val userInput = listOf("0", "11", "haha", "42")
    val numbers = userInput.map {
        it.toIntOrNull() // It produces a null if string cannot be parsed to a number (list "numbers" must support nullable int type)
    }
    println(numbers) // [0, 11, null, 42]
    // If you want to filter out the invalid (null) values,
    // you can use mapNotNull() like so:
    val numbers2 = userInput.mapNotNull {
        it.toIntOrNull()
    }
    println(numbers2) // [0, 11, 42]
    // This is almost the same as map except it tosses out the null values.

    //////////////////////////////
    // Nullable types
    var x : Int = 10
//    x = null // Error, cannot assign null to Int
    // Create a Nullable Int
    var xNullable : Int? = 10
    xNullable = null // OK
    println("xNullable = $xNullable")
    //////////////////////////////

    //
    // "fold" function
    //
    // Another handy function is fold , which takes a starting value and a lambda. The
    // lambda takes two values: the current value and an element from the list. The lambda
    // returns the next value that should be passed into the lambda as the current value
    // parameter.
    // This could be used with the prices list to calculate the total, like so:
//    var sum = prices.fold(0.0, { a, b ->
//        a + b
//    })
    // Using lambda trailing syntax
    var sum = prices.fold(0.0) { a, b ->
        a + b  // "a" is the summation current value, and "b" is the current list element
    }
    // The initial value is 0.0. Then the lambda calculates the sum of the current value plus
    // the current iteration’s value. Thus you calculate the total of all the values in the
    // array. In this case, sum will be:
    println(sum) // > 26.980000000000004

    ///////////////////////////////////
    val intList = listOf(1, 2, 3, 4)
    val prod = intList.fold(1.0) { a, b -> a * b }
    println("prod with fold, initial = 1.0: $prod")

    val prod1 = intList.reduce { a, b -> a * b }
    println("prod with reduce, initial = 1: $prod1")  // Note that list is of Int type

    val intList1 = listOf(1, 2, 3, 4)
    val prod2 = intList1.fold(10.0) { a, b -> a * b }
    println("prod with fold, initial = 10.0: $prod2")

    val prod3 = intList1.reduce { a, b -> a * b }
    println("prod with reduce, initial = 1: $prod3")  // Note that list is of Int type
    ///////////////////////////////////

    //
    // "reduce" function
    //
    // A function closely related to fold is reduce. In Kotlin, reduce uses the first element
    // in the collection as the starting value:
    sum = prices.reduce { a, b ->
        a + b
    }
    println(sum) // > 26.980000000000004
    // Now that you’ve seen filter , map , fold , and reduce , hopefully it’s becoming clear
    // how powerful these functions can be, especially thanks to the syntax of lambdas. In
    // just a few lines of code, you have calculated some rather complex values from the
    // collection.
}

























