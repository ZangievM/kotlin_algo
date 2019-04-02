package bfs


fun bfs(graph: Array<Array<Int>>, from: Int = 0): Array<Int> {
    // queue of vertexes
    val queue = mutableListOf<Int>()
    queue.enqueue(from)
    val used = Array(graph.size) { false }
    used[from] = true
    // array for saving information about from where we come to i-vertex
    val paths = Array(graph.size) { 0 }
    // array of distances from {from} vertex to all others
    val distances = Array(graph.size) { 0 }

    while (queue.isNotEmpty()) {
        val currentVertex = queue.dequeue()
        val current = graph[currentVertex]

        for (i in 0 until current.size) {
            if (current[i] != 0 && !used[i]) {
                used[i] = true
                queue.enqueue(i)
                distances[i] += distances[currentVertex] + current[i]
                paths[i] = currentVertex + 1
            }
        }
    }
    // Call it if you want to restore all paths
//    restorePaths(paths,used,distances,from)
    return distances
}

// function for restoring paths from {from} vertex to all others
fun restorePaths(paths: Array<Int>, used: Array<Boolean>, distances: Array<Int>, from: Int = 0) {
    for (i in 0 until paths.size) {
        if (!used[i] || from == i) continue
        print("Distance from ${from + 1} to ${i + 1} = ${distances[i]} -> ")
        restoreTheWay(paths, i, from).reversed().print()
    }
}

// function for restoring path from {from} vertex to {to} vertex
fun restoreTheWay(paths: Array<Int>, from: Int, to: Int): List<Int> {
    var current = from
    val array = mutableListOf<Int>()

    while (current != to) {
        array.add(current + 1)
        current = paths[current] - 1
    }
    array.add(current + 1)
    return array
}

fun main() {
    val n = readLine()!!.toInt()
    val graph = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        readLine()!!.split(" ").withIndex().forEach {
            val item = it.value.toInt()
            graph[i][it.index] = item
        }
    }
    bfs(graph).print()
}
