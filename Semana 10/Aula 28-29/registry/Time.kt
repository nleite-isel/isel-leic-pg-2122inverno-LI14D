package registry

data class Time(val hour: Int, val min: Int)

// Extension functions
fun Time.add(t: Time?): Time {
    t?.let {
        // This code runs if t != null
        var min = t.min + this.min
        var hour = t.hour + this.hour
        if (min > 59) {
            ++hour
            min %= 60;
        }
        return Time(hour, min)
    }
    // If t == null return time this
    return this
}

fun Time.toText(): String =
    (if (this.hour < 10) "0" + this.hour else this.hour.toString()) + ":" +
            (if (this.min < 10) "0" + this.min else this.min.toString())

fun main() {
    val t1 = Time(23, 5)
    val t2 = Time(5, 59)
    val t3 = t1.add(t2) // 29:4
    println(t3) // Works Ok because Time is a data class which has toString redefined
    println(t3.toText()) // this = t3
}

