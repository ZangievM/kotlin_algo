### Breadth-first search

Breadth-first search (BFS) is an algorithm for traversing or searching tree or graph data structures. It starts at the tree root (or some arbitrary node of a graph, sometimes referred to as a 'search key'), and explores all of the neighbor nodes at the present depth prior to moving on to the nodes at the next depth level.

https://github.com/ZangievM/kotlin_algo/blob/master/src/bfs/images/bfs.gif

BFS function:
``` kotlin
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
    return distances
}
```

It returns array of distances from 'search-key'(named 'from' in code) vertex to others

If you want to restore paths from 'search-key' to others it has methods for it:
``` kotlin
fun restorePaths(paths: Array<Int>, used: Array<Boolean>, distances: Array<Int>, from: Int = 0) {
    for (i in 0 until paths.size) {
        if (!used[i] || from == i) continue
        print("Distance from ${from + 1} to ${i + 1} = ${distances[i]} -> ")
        restoreTheWay(paths, i, from).reversed().print()
    }
}

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
```
Works in ![alt-text](https://github.com/ZangievM/kotlin_algo/blob/master/src/bfs/images/n+m.png)

Solutions contains some useful extension-methods like `enqueue`, `dequeue`, `front` for `MutableList<Int>` and `print` method for `Array<Int>` and `List<Int>`

You can see them in [Extensions.kt](https://github.com/ZangievM/kotlin_algo/blob/master/src/bfs/) file

[link on Wikipedia](https://en.wikipedia.org/wiki/Breadth-first_search)

[link on E-maxx](https://e-maxx.ru/algo/bfs)