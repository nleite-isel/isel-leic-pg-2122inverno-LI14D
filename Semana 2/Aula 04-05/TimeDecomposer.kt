
// Elabore um programa que dado um valor inteiro correspondente a um 
// tempo em segundos e o decomponha em três valores inteiros 
// representando, respectivamente, horas, minutos e segundos.

fun main() {
	println("Time Decomposer")
	//val timeSec = 150
	val timeSec: Int = 3727
	
	val hour = timeSec / 3600 // 60*60
	val remainder = timeSec % 3600
	val min = remainder / 60
	val sec = remainder % 60
	
	print("O tempo em segundos, ")
	print(timeSec)
	println(", decomposto fica:")
	print("Horas: ")
	println(hour)
	print("Min: ")
	println(min)
	print("Seg: ")
	println(sec)
	
	// Difference between integer and real division
	println(10 / 3)
	println(10 % 3)
	
	println(10.0 / 3)
}


/*
Output:

Time Decomposer
O tempo em segundos, 3727, decomposto fica:
Horas: 1
Min: 2
Seg: 7
3
1
3.3333333333333335

*/
