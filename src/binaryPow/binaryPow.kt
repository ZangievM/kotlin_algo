package binaryPow

fun binPow(a: Int, n: Int): Int {
    if (n == 0) return 1
    if (n % 2 != 0) {
        return binPow(a, n -1) * a
    } else {
        val b = binPow(a, n / 2)
        return b * b
    }
}

fun main() {
    val str = readLine()!!.split(" ").map { it.toInt() }
    println(binPow(str[0],str[1]))
}
