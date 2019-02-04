### Fibonacci numbers
Fibonacci numbers are elements of sequence, such that each number is the sum of the two preceding ones, starting from 0 and 1. That is:

![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/f0_f1.svg))

![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/fn.svg))

There are realized two methods to find Fibonacci n-number.

- Simple. Works in O(n)
- Fast. Works in ![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/log.png))

##### Simple solution
```kotlin
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
```

##### Fast solution
It is not difficult to prove the following matrix equality:

![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/formula_fast.png))

Denoting:

![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/p.png))

We get:

![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/fast_final.png))

So for finding Fibonacci n-number we should power P-matrix to n-degree.

Raising the matrix to the n-th degree we can do in ![alt-text](![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/log.png)) (See [Binary Pow](https://github.com/ZangievM/kotlin_algo/blob/master/src/binaryPow))

It means that we can calculate Fibonacci n-number in ![alt text](https://github.com/ZangievM/kotlin_algo/blob/master/src/fibonacci/images/log.png)

Function for binary power matrix A to n-degree:
```kotlin
fun matrixBinPow(a: Array<Array<Int>>, n: Int): Array<Array<Int>> {
    if (n == 0) return zMatrixTr
    if (n % 2 != 0) {
        return mult(matrixBinPow(a, n - 1), a)
    } else {
        val b = matrixBinPow(a, n / 2)
        return mult(b, b)
    }
}
```
Function for multiplying two matrices:
```kotlin
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
```
Function for fast calculating Fibonacci number:
```kotlin
fun fibonacciFast(n: Int): Int {
    val fib = Array(1) { arrayOf(0, 1) }
    val matrix = matrixBinPow(zMatrix, n)
    return mult(fib, matrix)[0][0]
}
``` 

[link on Wikipedia](https://en.wikipedia.org/wiki/Fibonacci_number)

[link on E-maxx](https://e-maxx.ru/algo/fibonacci_numbers)