import java.util.*

fun lineToListInt(line: String): List<Int> {
    val input = Scanner(line)

    val result = mutableListOf<Int>()

    while(input.hasNextInt()){
        result.add(input.nextInt())
    }
    return result
}