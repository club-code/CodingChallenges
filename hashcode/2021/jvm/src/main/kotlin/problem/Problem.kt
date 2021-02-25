package problem

import java.io.File

fun main(args: Array<String>) {
    val name = if(args.isNotEmpty()) args[0] else ""
    val lines: List<String> = generateSequence(::readLine).toList()
    val (list, streetsData, carsData) = parser(lines)

    val (duration, numIntersections, numStreets, numCars, bonusPoints) = list

    System.err.println(streetsData)
    System.err.println(carsData)

    val soluce = mixedTiming(numIntersections, streetsData, carsData)
//    println(soluce)
    val output = File("tmp/output$name.txt")
    output.writeText(soluce)
}

fun parser(input:List<String>): Triple<List<Int>, MutableMap<String, StreetData>, MutableMap<Int, List<String>>>{
    val firstLine = input[0]
    val listInt = firstLine.split(" ").map { it.toInt() }

    val streetsData = mutableMapOf<String, StreetData>()
    val carsData = mutableMapOf<Int, List<String>>()

    for (i in 1..listInt[2]) {
        val line = input[i]
        val (start, end, name, length) = line.split(" ")
        streetsData[name] = StreetData(start.toInt(), end.toInt(), length.toInt())
    }

    for (i in listInt[2] + 1..listInt[2] + listInt[3]) {
        val line = input[i]
        val data = line.split(" ")
        val streetsNames = data.subList(1, data.count())
        carsData[i - listInt[3] - 1] = streetsNames
    }
    return Triple(listInt, streetsData, carsData)
}

