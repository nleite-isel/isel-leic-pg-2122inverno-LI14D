//timeToSecs.kt

fun main() {
	println("Enter 3 integers representing hour, min, and seconds:")
	print("hour? ")
	val hour: Int = readLine()!!.toInt()
	println()

	print("min? ")
	val min: Int = readLine()!!.toInt()	
	println()

	print("sec? ")
	val sec: Int = readLine()!!.toInt()	
	println()
	
	println(hour)
	println(min)
	println(sec)	
	
	val totalSec: Int = hour * 3600 + min * 60 + sec
	println("total seconds is $totalSec")
}
