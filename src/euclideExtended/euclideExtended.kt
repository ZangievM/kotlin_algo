package euclideExtended

fun euclideExtended(a: Int, b: Int): Array<Int> {
    // array with answer. koeff[0] is "X", koeff[1] if "Y", koeff[2] is gcd of numbers "a" and "b"
    val koeff = arrayOf(0, 0, 0)
    fun gcd(a: Int, b: Int): Int {
        if (a == 0) {
            koeff[0] = 0
            koeff[1] = 1
            return b
        }
        val d = gcd(b % a, a)
        val tmp = koeff[0]
        koeff[0] = koeff[1] - (b / a) * koeff[0]
        koeff[1] = tmp
        return d
    }
    koeff[2] = gcd(a, b)
    return koeff
}

fun main() {
    val str = readLine()!!.split(" ").map { it.toInt() }
    val res = euclideExtended(str[0], str[1])
    println("${res[0]} ${res[1]} ${res[2]}")
}