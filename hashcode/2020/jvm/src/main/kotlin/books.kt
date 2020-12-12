package hashcode.hashcode2020

import java.io.BufferedWriter
import java.io.FileWriter


data class Library(val pos: Int, val books: List<Int>, val signup: Int, val ships: Int){
    fun value(scores: List<Int>) = books.reduceIndexed { index, acc, i ->
        acc+scores[index]
    }

    fun value(scores:List<Int>, days:Int): Int{
        val realDays = (days-signup)*ships
        val values = books.mapIndexed { index, i -> scores[i] to i }.sortedBy { it.first }
        var sum = 0
        for(i in 0 until realDays){
            if(i in values.indices)
                sum += values[i].first
            else
                break
        }
        return sum
    }

    fun value(scores:List<Int>, list: List<Boolean>) = books.reduceIndexed { index, acc, i ->
        if(list[index]) acc+scores[index] else acc
    }

    fun sortedBooks(scores: List<Int>)= books.mapIndexed { index, i -> scores[i] to i }.sortedBy { it.first }.map{it.second}
}

fun exo(nbDays:Int, scores:List<Int>, libraries: List<Library>): List<Library>{
    val res = mutableListOf<Library>()
    val added = mutableSetOf<Library>()
    var days = nbDays
    while(days > 0){
        val values = libraries.mapIndexed { index, library -> library.value(scores, days) to index }
        var max = 0
        var maxi = -1
        for(i in values.indices){
            if(libraries[values[i].second] !in added && values[i].first > max){
                max = values[i].first
                maxi = values[i].second
            }
        }
        if(maxi == -1)
            break
        res.add(libraries[maxi])
        added.add(libraries[maxi])
        days-=libraries[maxi].signup
    }
    return res
}

fun main(){
    val content = Library::class.java.classLoader.getResource("f_libraries_of_the_world.txt").readText().split("\n")
    val first = content[0].split(" ").map { it.toInt() }
//    val nbBooks = first[0]
    val nbLibraries = first[1]
    val nbDays = first[2]
    val scores = content[1].split(" ").map{it.toInt()}
    val libraries = mutableListOf<Library>()
    for(i in 0 until nbLibraries){
        val lib = content[2+2*i].split(" ").map{it.toInt()}
        val books = content[2+2*i+1].split(" ").map{it.toInt()}
        libraries.add(Library(i, books, lib[1], lib[2]))
    }
    val str = StringBuilder()
    val res = exo(nbDays, scores, libraries)
    //println(res.size)
    str.append("${res.size}\n")
    for(i in res){
        //println("${i.pos} ${i.books.size}")
        str.append("${i.pos} ${i.books.size}\n")
        val books = i.sortedBooks(scores)
        for(j in books){
            //print("$j ")
            str.append("$j ")
        }
        //println()
        str.append("\n")
    }

    val writer = BufferedWriter(FileWriter("f.txt"))
    writer.write(str.toString())
    writer.close()

}
