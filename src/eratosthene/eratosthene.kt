package eratosthene

fun sieve(n: Int): Array<Boolean> {
    val prime = Array(n+1) { true }
    prime[0] = false
    prime[1] = false
    for (i in 2 .. n) {
        if (prime[i]) {
            if (i * 1L * i <= n)
                for (j in i * i .. n step i) {
                    prime[j] = false
                }
        }
    }
    return prime
}

fun main() {
    val n = readLine()!!.toInt()
    val res = sieve(n)
    for (i in 0 .. n) {
        if(res[i]) print("$i ")
    }

}