package topological_sort
lateinit var graph: Array<Array<Int>>
lateinit var result: MutableList<Int>

fun topological_sort(v: Int = 0) {
    val used = Array(graph.size) { false }
    result = mutableListOf()
    fun dfs(vertex: Int = 0) {
        used[vertex] = true
        for (i in 0 until graph.size) {
            if (graph[vertex][i]==1 && !used[i]) {
                dfs(i)
            }
        }
        result.add(0, vertex)
    }
    dfs(v)
    // Call this if you want to see topological sort of vertexes
//    result.print()
}

fun main() {
    val n = readLine()!!.toInt()
    graph = Array(n) { Array(n) { 0 } }
    for (i in 0 until n) {
        readLine()!!.split(" ").withIndex().forEach {
            graph[i][it.index] = it.value.toInt()
        }
    }
    topological_sort()
}