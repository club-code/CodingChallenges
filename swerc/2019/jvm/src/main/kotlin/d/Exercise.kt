package d

import org.clubcode.library.number.pow
import java.util.*

fun main() {
    val inputs = generateSequence(::readLine).toList()
    val first = inputs[0].toOperations().apply().toList()
    val second = inputs[1].toOperations().apply().toList()

    val result = if (first.isEmpty() && second.isEmpty()) {
        true
    } else if(first.isEmpty() || second.isEmpty()) {
        false
    } else {
        first.identical(second)
    }
    println(if (result) "True" else "False")
}

fun List<Operation>.apply(): LinkedList<AminoAcid> {
    val result = LinkedList<AminoAcid>()
    repeat(10.pow(5)+2) {
        result.add(SimpleAminoAcid(it))
    }
    try {
        for (op in this) {
            op.operation(result)
        }
    } catch (e: Fail) {
        return LinkedList()
    }
    return result
}

fun List<AminoAcid>.identical(other: List<AminoAcid>): Boolean {
    return this.withIndex().all { other[it.index] == it.value }
}

val complexIds = mutableMapOf<Pair<Int, Int>, Int>()

sealed class AminoAcid {
    abstract fun id(): Int
}

data class SimpleAminoAcid(val id: Int) : AminoAcid() {
    override fun id(): Int = id

    override fun toString(): String {
        return "$id"
    }
}

class ComplexAminoAcid(val left: AminoAcid, val right: AminoAcid) : AminoAcid() {
    init {
        complexIds.getOrPut(left.id() to right.id()) { complexIds.size }
    }

    override fun id(): Int {
        return complexIds[left.id() to right.id()]!!
    }

    override fun toString(): String {
        return "<$left,$right>"
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is ComplexAminoAcid) return false

        if (id() != other.id()) return false

        return true
    }

    override fun hashCode(): Int {
        var result = left.id().hashCode()
        result = 31 * result + right.id().hashCode()
        return result
    }


}

enum class Operation(val operation: (l: LinkedList<AminoAcid>) -> Unit) {
    C({
        val a = it.remove()
        it.addFirst(a)
        it.addFirst(a)
    }),
    D({
        it.remove()
    }),
    L({
        when (val a = it.remove()) {
            is SimpleAminoAcid -> throw Fail("L")
            is ComplexAminoAcid -> it.addFirst(a.left)
        }
    }),
    P({
        val a = it.remove()
        val b = it.remove()
        it.addFirst(ComplexAminoAcid(a, b))
    }),
    R({
        when (val a = it.remove()) {
            is SimpleAminoAcid -> throw Fail("R")
            is ComplexAminoAcid -> it.addFirst(a.right)
        }
    }),
    S({
        val a = it.remove()
        val b = it.remove()
        it.addFirst(a)
        it.addFirst(b)
    }),
    U({
        when (val a = it.remove()) {
            is SimpleAminoAcid -> throw Fail("U")
            is ComplexAminoAcid -> {
                it.addFirst(a.right)
                it.addFirst(a.left)
            }
        }
    })
}

fun String.toOperations(): List<Operation> {
    return this.map { Operation.valueOf(it.toString()) }
}

class Fail(message: String = "") : Exception(message)