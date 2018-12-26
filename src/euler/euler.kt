package euler

fun phi(n: Int): Int {
    var number = n
    var result = number
    var i = 2
    while (i * i <= number) {
        if (number % i == 0) {
            while (number % i == 0)
                number /= i
            result -= result / i
        }
        ++i
    }
    if (number > 1)
        result -= result / number
    return result
}
fun main(){
    val n = readLine()!!.toInt()
    println(phi(n))
}