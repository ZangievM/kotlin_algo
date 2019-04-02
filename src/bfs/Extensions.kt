package bfs

fun MutableList<Int>.enqueue(value: Int) {
    add(size, value)
}

fun MutableList<Int>.dequeue(): Int {
    return removeAt(0)
}

fun MutableList<Int>.front(): Int {
    return get(0)
}

fun Array<Int>.print() {
    for (i in 0 until size) {
        print("${get(i)} ")
    }
    println()
}
fun List<Int>.print() {
    for (i in 0 until size) {
        print("${get(i)} ")
    }
    println()
}