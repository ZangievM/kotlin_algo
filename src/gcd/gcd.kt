package gcd
fun gcd(a: Int, b: Int):Int {
    if(b==0) return a
    return gcd(b,a%b)
}

fun main(){
    val str = readLine()!!.split(" ").map { it.toInt() }
    println(gcd(str[0],str[1]))
}