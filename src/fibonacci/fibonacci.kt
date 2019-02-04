package fibonacci

import java.lang.Exception

// initial value of our matrix: (0,1
//                               1,1)
val zMatrix = Array(2) {
    if (it == 0) arrayOf(0, 1); else arrayOf(1, 1)
}
// value of zMatrix^0
val zMatrixTr = Array(2) {
    if (it == 0) arrayOf(1,0); else arrayOf(0,1)
}
// simple solution that works in O(n)
fun fibonacci(n: Int): Int {
    var f0 = 0
    var f1 = 1
    for (i in 1..n) {
        val tmp = f1
        f1 += f0
        f0 = tmp
    }
    return f0
}

// solution that works in O(log(n))
fun fibonacciFast(n: Int): Int {
    val fib = Array(1) { arrayOf(0, 1) }
    val matrix = matrixBinPow(zMatrix, n)
    return mult(fib, matrix)[0][0]
}

// function for multiplying matrices
fun mult(arr1: Array<Array<Int>>, arr2: Array<Array<Int>>): Array<Array<Int>> {
    //first matrix sizes
    val width1 = arr1[0].size
    val height1 = arr1.size
    //second matrix sizes
    val width2 = arr2[0].size
    val height2 = arr2.size

    val result = Array(height1) { Array(width2) { 0 } }
    if (width1 != height2) throw Exception("This matriсes can not be multiplied")
    else {
        for (i in 0 until height1) {

            for (j in 0 until width2) {
                var res = 0
                for (k in 0 until height2) {
                    res += arr1[i][k] * arr2[k][j]
                }
                result[i][j] = res
            }
        }
        return result
    }
}

//function for binary power matrix A to n-degree
fun matrixBinPow(a: Array<Array<Int>>, n: Int): Array<Array<Int>> {
    if (n == 0) return zMatrixTr
    if (n % 2 != 0) {
        return mult(matrixBinPow(a, n - 1), a)
    } else {
        val b = matrixBinPow(a, n / 2)
        return mult(b, b)
    }
}

fun main() {
    val n = readLine()!!.toInt()
    println(fibonacci(n))
    println(fibonacciFast(n))
}