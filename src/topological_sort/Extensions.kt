package topological_sort

fun Array<out Any>.print(){
    for(i in 0 until size){
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