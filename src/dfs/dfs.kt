package dfs

lateinit var graph: Array<Array<Int>>

fun dfsSimple(v: Int = 0) {
    val used = Array(graph.size) { false }
    fun dfs(vertex: Int = 0) {
        used[vertex] = true

        for (i in 0 until graph.size) {
            if (!used[i]) {
                dfs(i)
            }
        }
    }
    dfs(v)
    // Call this if you want to see visited vertexes
//    used.print()
}

fun dfsTimeColor(v: Int = 0) {
    val colors = Array(graph.size) { 0 } // colors of vertexes (0, 1 or 2)
    val timeIn = Array(graph.size) { 0 }
    val timeOut = Array(graph.size) { 0 }
    var dfsTimer = 0

    fun dfs(vertex: Int = 0) {
        timeIn[vertex] = dfsTimer++
        colors[vertex] = 1
        for (i in 0 until graph.size) {
            if (colors[i] == 0) {
                dfs(i)
            }
        }
        colors[vertex] = 2
        timeOut[vertex] = dfsTimer++
    }
    dfs(v)

    //Call this if you want to see colors of vertexes and in/out - times
//    colors.print()
//    timeIn.print()
//    timeOut.print()
}

fun main() {
    val n = readLine()!!.toInt()
    graph = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        readLine()!!.split(" ").withIndex().forEach {
            graph[i][it.index] = it.value.toInt()
        }
    }
    dfsSimple()
    dfsTimeColor()
}