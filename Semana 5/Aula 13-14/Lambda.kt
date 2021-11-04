
//
// High Order Functions - Lambdas
//

// From the reference book:

// Previously you're taught you about functions. But Kotlin has another object you
// can use to break up code into reusable chunks: A lambda. These have many uses,
// and become particularly useful when dealing with collections such as an array or
// map.
// A lambda expression is simply a function with no name; you can assign it to a
// variable and pass it around like any other value.
//
// Lambdas are also known as anonymous functions, and derive their name from the
// lambda calculus

// Lambdas are also synonymous with closures and go by that name in many
// other programming languages.
// Closures are so named because they have the ability to “close over” the variables and
// constants within the closure’s own scope. This simply means that a lambda can
// access, store and manipulate the value of any variable or constant from the
// surrounding context, acting as a nested function. Variables and constants used
// within the body of a lambda are said to have been captured by the lambda.

fun main() {
//    val x = readLine()!!.toInt()
//    val y = x * x
//    println(y)
    // doubleLambda1 is of type (parameters) -> return type = (Int) -> Long
//    var doubleLambda1 = { a: Int ->
////         (a * a) //  (Int) -> Int
//         (a * a).toLong() //  (Int) -> Long
//    }
//    val y = doubleLambda1(x)
//    println(y)
    ////////////////////////////////////////////////

    // Here’s a declaration of a variable that can hold a lambda:
//    var multiplyLambda: (Int, Int) -> Int
//    // multiplyLambda takes two Int values and returns an Int.
//    multiplyLambda = { a: Int, b: Int -> Int
//        a * b
//    }
//    // The -> symbol indicates the return type. The body of the
//    // lambda begins after the return type.
//    // The lambda expression returns the value of the last expression in the body.
//    // With your lambda variable defined, you can use it just as if it
//    // were a function, like so:
//    val lambdaResult = multiplyLambda(4, 2) // 8
//    println(lambdaResult)
//    //
//    // Shorthand syntax
//    //
//    // First, you can use Kotlin’s type inference to shorten the
//    // syntax by removing the type information:
//    multiplyLambda = { a, b ->
//        println("Ola")
//        a * b
//       // println("Ola")  // Error, println is of type Unit, not Int
//    }
//    val lambdaResult1 = multiplyLambda(4, 2) // 8
//    println(lambdaResult1)
    //
    // it keyword
    //
    // For a lambda that has only one parameter, you can shorten it even further
    // using the it keyword:
//    var doubleLambda = { a: Int ->   // Return type not specified. Thus, it is inferred
//        2 * a   // Last instruction specifies the return type: Int
//    }
    // Since there is only one parameter and the lambda type is now specified,
    // the lambda can be shortened to:
//    doubleLambda = { 2 * it }
//    println(doubleLambda(3))
//
//    doubleLambda = {
//        println("ola1"); 2 * it }
//    println(doubleLambda(3))
//    // You can also use "it" in a new declaration:
//    val square: (Int) -> Int = { it * it }
////    val square = { 2 * it } // Cannot infer type, function is needed in declaration

    //
    // Lambdas as arguments
    //
    fun operateOnNumbers(a: Int, b: Int, operation: (Int, Int) -> Int): Int {
        val result = operation(a, b)
        println(result)
        return result
    }
    // This declares a function named operateOnNumbers, which takes Int values as its
    // first two parameters. The third parameter is named operation and is of a function
    // type. operateOnNumbers itself returns an Int.
//    val addLambda = { a: Int, b: Int ->
//        a + b
//    }
//    operateOnNumbers(4, 2, addLambda) // 6
//    //    operateOnNumbers(4, 2, operation = addLambda) // 6
////    // Remember, lambdas are simply functions without names. So you shouldn’t be
////    // surprised to learn that you can also pass in a function as the third parameter of
////    // operateOnNumbers, like so:
//    fun addFunction(a: Int, b: Int) = a + b // Local fun in main
////    operateOnNumbers(4, 2, operation = addFunction) // Error, reference operator :: needed
//    operateOnNumbers(4, 2, operation = ::addFunction) // 6
//    operateOnNumbers(4, 2, operation = ::addFunction1) // 6
    // operateOnNumbers is called the same way, whether the operation is a function or a
    // lambda.
    // The :: operator is the reference operator (It has the effect of passing
    // the *address* of the function as argument)

//    println("With lambda inline")
//    // You can define the lambda inline with the operateOnNumbers function call, like this:
//    operateOnNumbers(4, 3, operation = { a: Int, b: Int -> // Inferred return type: Int
//        a + b
//    })
    // With named parameters - I can change the order in any way
//    operateOnNumbers(operation = { a: Int, b: Int ->
//        a + b
//    }, b = 4, a = 2)
////    // There’s no need to define the lambda and assign it to a local variable or constant.
////    // You can simply declare the lambda right where you pass it into the function as an
////    // argument!
//    operateOnNumbers(4, 2, { a, b ->
//        a + b
//    })
//    // The + operator is just an operator function
//    // plus() in the Int class that takes two arguments and returns one result so you can
//    // write:
//    println("7 + 3:")
//    operateOnNumbers(7, 3, operation = Int::plus)
////    // There’s one more way you can simplify the syntax, but it can only be done when the
////    // lambda is the final argument passed to a function. In this case, you can move the
////    // lambda outside of the function call:
//    operateOnNumbers(4, 2) { a, b ->
//        a + b
//    }
//    // This may look strange, but it’s just the same as the previous code snippet, except
//    // you’ve removed the operation label and pulled the braces outside of the function
//    // call parameter list. This is called trailing lambda syntax.
//
//    // A lambda will always return the value of its last expression, so here is how you
//    // define a lambda that takes no parameters and returns only the Unit object:
//    var unitLambda: () -> Unit /*Int*/ = {
//        println("Kotlin Apprentice is awesome!") // println returns a Unit type
//        2 + 3
//        readLine()!!.toInt()
//    }
//    unitLambda()
//    var nothingLambda: () -> Nothing = {
//        throw NullPointerException()  // Compatible with Nothing return type
////        2 + 3 // Not compatible with Nothing return type
//    }
//    nothingLambda()
//    //
//    // Capturing from the enclosing scope
//    //
//    // Let’s return to an important characteristic of lambdas, as they act as closures: they
//    // can access the variables and constants from within their own scope.
//    // Note: Recall that scope defines the range in which an entity (variable,
//    // constant, etc) is accessible. You saw a new scope introduced with if
//    // statements. Lambdas also introduce a new scope and inherit all entities visible
//    // to the scope in which they are defined.
//    // For example, take the following lambda:
    var counter = 0
    val incrementCounter = { // A lambda function
        counter += 1 // captured variable, returns Unit = type of expression
        counter
    }
    println("Before incrementing: $counter")
    println(incrementCounter()) // 1
    incrementCounter()
    incrementCounter()
    incrementCounter()
    incrementCounter()
    println("After incrementing 5 times: $counter")
//    //
//    // Iterating over collections with lambdas
//    //
//    // In Kotlin, collections implement some very handy features often associated with
//    // functional programming. These features come in the shape of functions that you
//    // can apply to a collection to perform an operation on it.
//    // Operations include things like transforming each element or filtering out certain
//    // elements. These functions make use of lambdas.
//    // The first of these functions, forEach, lets you loop over the elements in a collection
//    // and perform an operation like so:
    val values = listOf(1, 2, 3, 4, 5, 6)
    values.forEach {
        println("$it: ${it * it}")
    }
//    // 1: 1
//    // 2: 4
//    // 3: 9
//    // 4: 16
//    // 5: 25
//    // 6: 36
//    // Another function allows you to filter out certain elements:
//    var prices = listOf(1.5, 10.0, 4.99, 2.30, 8.19)
//    val largePrices = prices.filter {
//        it > 5.0
//    }
//    // filter function returns a List of the inferred type (Double)
//    println(largePrices)
//    // The filter function looks like so:
//    // public inline fun <T> Iterable<T>.filter(predicate: (T) ->
//    // Boolean): List<T>
//    //
//    // The lambda’s job for filter is to return true or false depending on whether or not
//    // the value should be kept or not. The list returned from filter will contain all
//    // elements for which the lambda returned true.
//    // In the example, largePrices will contain:
//    // [10.0, 8.19]
//    // Note: The array that is returned from filter (and all of these functions) is a
//    // new array. The original is not modified at all.
//
//    println("Enter 1st number:")
//    val i1 = readLine()?.toInt()
//    println("Enter 2nd number:")
//    val i2 = readLine()?.toInt()
//    println("Numbers: $i1 and $i2")
//
//


}

// Private here means that it cannot be exported to other files
private fun addFunction1(a: Int, b:Int) = a + b // Global fun


























