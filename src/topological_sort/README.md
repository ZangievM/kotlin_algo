### Topological sorting

Lets start with the exercise. We have oriented graph with `n` vertices and `m` edges.

The task is to renumber vertices so that every edge leads from vertex with smaller number to vertex with larger.

In other words, we need to find transposition of vertices(*topological order*) corresponding to the order specified by all edges of the graph.

Topological sorting may not exists if the graph contains loop.

Topological sorting may not be the only one if the graph is empty or if we have vertices `a` `b` and `c`
such that from `a` there is edge to `b` and `c` , but there is no edge from `b` to `c` and vice versa.


#### Algorithm

To solve this we'll use the [DFS](https://github.com/ZangievM/kotlin_algo/tree/master/src/dfs).

Lets suppose that our `graph` is acyclic (that is, a solution exists). 
We need to start DFS from random vertex `v` and when algorithm finished work on any vertex(when it goes from the vertex) its insert this vertex to beginning of some `list`.

How we can explain this algorithm? 
Lets remember about **exit time** of vertex in DFS. 
Exit time for every vertex `v` is the moment when ends its work `dfs(v)` call of DFS.
Thus, the desired topological order is sorting in descending order of exit times.
 
 Solution:
 
 ``` Kotlin
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
     }
 ```
 
 Solutions contains some useful extension-methods in [Extensions.kt](https://github.com/ZangievM/kotlin_algo/blob/master/src/topological_sort/Extensions.kt) file
 
 [link on Wikipedia](https://en.wikipedia.org/wiki/Topological_sorting)
 
 [link on E-maxx](https://e-maxx.ru/algo/topological_sort)