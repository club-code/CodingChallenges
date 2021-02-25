package problem

import java.lang.StringBuilder

fun stupidSoluce(
    numIntersections: Int,
    streetsData: MutableMap<String, StreetData>
): String {
    val output = StringBuilder()
    output.appendLine(numIntersections.toString())

    for (i in 0 until numIntersections) {
        output.appendLine(i.toString())
        val streetsIntersect = mutableListOf<String>()

        streetsData.forEach { (name: String, data: StreetData) ->
            if (data.end == i) {
                // streetsData est une hashMap c'est l'argument de la méthode sinon c'est streetsIntersect
                streetsIntersect.add(name)
            }
        }

        output.appendLine(streetsIntersect.count())
        for (streetName in streetsIntersect)
        {
            output.appendLine("$streetName 1")
        }

    }

    return output.toString()
}