
fun readInt(quest: String): Int {
	print("$quest? ")
    return readLine()!!.trim().toInt()
}

fun readDouble(quest: String): Double {
    print("$quest? ")
    return readLine()!!.trim().toDouble()
}
