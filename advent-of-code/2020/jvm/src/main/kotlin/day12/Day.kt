package day12

import org.clubcode.library.math.*


fun main() {
    val inputs = generateSequence(::readLine).map { Instruction(it[0], it.drop(1).toInt()) }
    val ship = Ship()

    for (instruction in inputs) {
        ship.takeInstruction(instruction)
    }
    println(ship.position.getManhattanDistance(IntVector2(0, 0)))
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map { Instruction(it[0], it.drop(1).toInt()) }
    val ship = Ship()
    for (instruction in inputs) {
        ship.takeInstructionPart2(instruction)
    }
    println(ship.position.getManhattanDistance(IntVector2(0, 0)))
}

data class Instruction(val action: Char, val value: Int)

data class Ship(
    var direction: IntVector2 = IntVector2(1, 0), var position: IntVector2 = IntVector2(0, 0),
    var waypoint: IntVector2 = IntVector2(10, 1)
) {
    fun takeInstruction(instruction: Instruction) {
        when (instruction.action) {
            'N' -> position += IntVector2(0, instruction.value)
            'S' -> position += IntVector2(0, -instruction.value)
            'E' -> position += IntVector2(instruction.value, 0)
            'W' -> position += IntVector2(-instruction.value, 0)
            'L' -> direction = direction.rotateDegree(instruction.value)
            'R' -> direction = direction.rotateDegree(-instruction.value)
            'F' -> position += instruction.value * direction
        }
    }

    fun takeInstructionPart2(instruction: Instruction) {
        when (instruction.action) {
            'N' -> waypoint += IntVector2(0, instruction.value)
            'S' -> waypoint += IntVector2(0, -instruction.value)
            'E' -> waypoint += IntVector2(instruction.value, 0)
            'W' -> waypoint += IntVector2(-instruction.value, 0)
            'L' -> waypoint = (waypoint-position).rotateDegree(instruction.value)+position
            'R' -> waypoint = (waypoint-position).rotateDegree(-instruction.value)+position
            'F' -> {
                val diff = waypoint-position
                position += instruction.value * diff
                waypoint = position+diff
            }
        }
    }
}


