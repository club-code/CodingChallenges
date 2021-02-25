package problem

import java.lang.StringBuilder

fun orderTiming(
    numIntersections: Int,
    streetsData: MutableMap<String, StreetData>,
    carsData: MutableMap<Int, List<String>>
): String {
    val output = StringBuilder()
    var numIntersect = 0

    val streetsFirstTime = mutableMapOf<String, Int>()

    for ((index, streets) in carsData) {
        for (i in 0 until streets.count()) {
            val arrived = streets.subList(0, i).map { it.length }.sum()
            streetsFirstTime[streets[i]] = Math.min(arrived, streetsFirstTime.getOrDefault(streets[i], 0))
        }
    }

    for (i in 0 until numIntersections) {
        val streetsIntersect = mutableListOf<String>()

        streetsData.forEach { (name: String, data: StreetData) ->
            if (data.end == i) {
                // streetsData est une hashMap c'est l'argument de la méthode sinon c'est streetsIntersect
                streetsIntersect.add(name)
            }
        }

        val filter = streetsIntersect.filter { streetsFirstTime[it] != null }
        if (streetsIntersect.any { streetsFirstTime[it] != null }) {
            numIntersect++
            output.appendLine(i)
            output.appendLine(filter.size.toString())
        }

        for (streetName in filter.sortedBy { streetsFirstTime[it]!! }) {
            output.appendLine("$streetName 1")
        }

    }

    output.insert(0, "$numIntersect\n")

    return output.toString()
}