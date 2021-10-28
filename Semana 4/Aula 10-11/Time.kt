
data class Time(val hour: Int, val min: Int, val sec: Int)

fun secsToTime(secs: Int) = Time(secs / 3600,secs % 3600 / 60,secs % 60)

//fun timeToSecs(t: Time) : Int = t.hour * 3600 + t.min * 60 + t.sec
// Return type is inferred
fun timeToSecs(t: Time) = t.hour * 3600 + t.min * 60 + t.sec

fun toText(t: Time) = "${t.hour}:${t.min}:${t.sec}"

fun Time.toTxt() = "${this.hour}:${this.min}:${this.sec}"
