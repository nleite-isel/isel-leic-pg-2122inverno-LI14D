

fun main() {

    // Read first interval values
    val low1 = readInt("Intervalo A limite inferior")
    val high1 = readInt("Intervalo A limite superior")
    // Read second interval values
    val low2 = readInt("Intervalo A limite inferior")
    val high2 = readInt("Intervalo A limite superior")
    // Assume low1 < high1 and low2 < high2
    if (high1 < low2 || high2 < low1) println("A and B = Empty") else {
        // Intervals intersect
        //
        // Get largest of lowest limits
        var low: Int = low1
        if (low2 > low) low = low2
        // Get smallest of largest limits
        var high: Int = high1
        if (high2 < high) high = high2
        println("A and B = [$low, $high]")
    }

}