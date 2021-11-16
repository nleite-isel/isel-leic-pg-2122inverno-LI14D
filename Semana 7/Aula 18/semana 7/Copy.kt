package `semana 7`

///*data */class Time(val hour: Int, val min: Int, val sec: Int)
// data class already implements copy and toString functions. class doesn't.
data class Time(val hour: Int, val min: Int, val sec: Int) 


fun main() {
    val time: Time = Time(1, 2, 7)
    // Class Time, if defined as a data class, has methods toString and copy
    println(time.toString())

//    val time2 = time.copy()
//    // We can also copy only some attributes
//    val time3 = time.copy(hour = 3)
//    println(time2.toString())
//    println(time3.toString())
    // Copy only some attributes using copy1 function
    val time4 = time.copy1(hour = 3)
    println(time4.toString())

}









// If we want, we could implement copy extension function explicitly
fun Time.copy1(hour: Int = this.hour, min: Int = this.min, sec: Int = this.sec) = Time(hour, min, sec)
