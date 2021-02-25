package problem

import java.lang.StringBuilder

fun mightBeStupid(
    numIntersections: Int,
    streetsData: MutableMap<String, StreetData>,
    carsData: MutableMap<Int, List<String>>
): String {
    val output = StringBuilder()
    //output.appendLine(numIntersections.toString())
    var numIntersect = 0

    val streetsWeights = mutableMapOf<String, Int>()

    for ((index, streets) in carsData) {
        for (street in streets) {
            streetsWeights[street] = streetsWeights.getOrDefault(street, 0) + 1
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

        val filter = streetsIntersect.filter { streetsWeights[it] != null && streetsWeights[it] != 0 }
        val minWeight = filter.map { streetsWeights[it]!! }.minOrNull() ?: 1

        if (streetsIntersect.any { streetsWeights[it] != null && streetsWeights[it] != 0 }) {
            numIntersect++
            output.appendLine(i)
            val numStreet : Int = filter.size
            output.appendLine(numStreet.toString())
        }

        for (street in streetsIntersect) {

            if (streetsWeights[street] != null && streetsWeights[street] != 0) {
                val trafficLightTiming: Int = Math.sqrt(streetsWeights[street]!!.toDouble() / minWeight.toDouble()).toInt()
                output.appendLine("$street $trafficLightTiming")
            }

        }
    }

    // AJOUTER $numIntersect AU DEBUT DE output
    output.insert(0, "$numIntersect\n")
    return output.toString()
}