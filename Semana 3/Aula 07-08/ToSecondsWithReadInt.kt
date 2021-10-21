
fun main() {
	val h = readInt("Horas")
	val m = readInt("Minutos")
	val s = readInt("Segundos")
		
	val secs = h*3600 + m*60 + s
	
	println("$h:$m:$s = $secs segundos.")
}
