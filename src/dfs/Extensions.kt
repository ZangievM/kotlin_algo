package dfs

fun Array<out Any>.print(){
    for(i in 0 until size){
        print("${get(i)} ")
    }
    println()
}