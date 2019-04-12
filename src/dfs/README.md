### Depth-first search

Depth-first search (DFS) is an algorithm for traversing or searching tree or graph data structures. The algorithm starts at the root node (selecting some arbitrary node as the root node in the case of a graph) and explores as far as possible along each branch before backtracking.

![alt-text](https://github.com/ZangievM/kotlin_algo/blob/master/src/dfs/images/dfs.gif)

There are two implementations of DFS: 
 - Simple
 - Complex - sets colors for vertexes and calculate in/out time
 
 Simple DFS-Solution:
 
 ``` Kotlin
     val graph: Array<Array<Int>> //graph
     val used = Array(graph.size) { false }
     fun dfs(vertex: Int = 0) {
         used[vertex] = true
         for (i in 0 until graph.size) {
             if (!used[i]) {
                 dfs(i)
             }
         }
     }
 ```
 
 
 DFS with colors and in/out times:
 
 ``` Kotlin
     val graph: Array<Array<Int>> //graph
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
 ```
 
 Works in ![alt-text](https://github.com/ZangievM/kotlin_algo/blob/master/src/dfs/images/n+m.png)
 
 Solutions contains some useful extension-methods in [Extensions.kt](https://github.com/ZangievM/kotlin_algo/blob/master/src/dfs/Extensions.kt) file
 
 [link on Wikipedia](https://en.wikipedia.org/wiki/Depth-first_search)
 
 [link on E-maxx](https://e-maxx.ru/algo/dfs)