package day8

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

fun main() {
    val inputs = generateSequence(::readLine).map{
        val value = it.split(" ")
        Operation(value[0], value[1].toInt())
    }.toList()
    println(inputs.execute().last)
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).map{
        val value = it.split(" ")
        Operation(value[0], value[1].toInt())
    }.toList()
    println(inputs.part2())
}

fun List<Operation>.part2(): Int {
    val changes = this.execute().changes(this)
    for (index in changes) {
        val e = (this.take(index) + this[index].invertOp() + this.drop(index + 1)).execute()
        if (e.isFinished())
            return e.last
    }
    throw IllegalStateException("should not be possible")
}

fun List<Operation>.execute(): Return {
    val executed = Array(this.size){false}
    var acc = 0
    var pc = 0

    while (pc < this.size && !executed[pc]) {
        executed[pc] = true
        val op = this[pc]
        when (op.op) {
            "acc" -> {
                acc += op.value
                pc++
            }
            "jmp" -> {
                pc += op.value
            }
            "nop" -> {
                pc++
            }
        }
    }
    return Return(executed, acc)
}

data class Operation(val op: String, val value: Int) {
    fun invertOp() = Operation(when (op) {
        "acc" -> "acc"
        "jmp" -> "nop"
        "nop" -> "jmp"
        else -> throw IllegalArgumentException("should not happen, bad file")
    }, value)
}

class Return(val executed: Array<Boolean>, val last: Int) {
    fun isFinished() = executed.last()

    fun changes(l: List<Operation>): Set<Int> {
        return l.mapIndexedNotNull { index, operation ->
            if(executed[index] && operation.op in setOf("jmp", "nop"))
                index
            else
                null
        }.toSet()
    }
}
