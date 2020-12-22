package day22

import org.clubcode.library.collection.split
import java.util.*

fun main() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }
        .map {
            val p = Player()
            p.addAll(it.drop(1).map {l -> l.toInt() })
            p
        }
    val p1 = inputs[0]
    val p2 = inputs[1]
    while (!p1.isEmpty() && !p2.isEmpty()) {
        p1.round(p2)
    }
    println(if (p1.isEmpty()) p2.score() else p1.score())
}

fun mainPart2() {
    val inputs = generateSequence(::readLine).split { it.isEmpty() }
        .map {
            val p = Player()
            p.addAll(it.drop(1).map {l -> l.toInt() })
            p
        }
    val p1 = inputs[0]
    val p2 = inputs[1]
    val winner = p1.recursiveRound(p2, mutableSetOf(), mutableSetOf())
    println(if (winner == Winner.P1) p1.score() else p2.score())
}

class Player {
    val cards = LinkedList<Int>()

    fun isEmpty() = cards.isEmpty()

    fun remove() = cards.remove()

    fun add(x: Int) = cards.add(x)

    fun addAll(l: Collection<Int>) = cards.addAll(l)

    fun round(o: Player) {
        val card = remove()
        val otherCard = o.remove()

        if (card > otherCard) {
            add(card)
            add(otherCard)
        } else {
            o.add(otherCard)
            o.add(card)
        }
    }

    fun size() = cards.size

    fun recursiveRound(o: Player, historicP1: MutableSet<List<Int>>, historicP2: MutableSet<List<Int>>): Winner {
        if (cards.toList() in historicP1 || o.cards.toList() in historicP2) {
            return Winner.P1
        }
        if (isEmpty())
            return Winner.P2
        if(o.isEmpty())
            return Winner.P1

//        System.err.println(this)
//        System.err.println(o)
//        System.err.println("###########")

        historicP1.add(cards.toList())
        historicP2.add(o.cards.toList())

        val card = remove()
        val otherCard = o.remove()

        if (card <= size() && otherCard <= o.size()) {
            val n = Player()
            n.cards.addAll(cards.take(card))

            val no = Player()
            no.cards.addAll(o.cards.take(otherCard))

            val subGame = n.recursiveRound(no, mutableSetOf(), mutableSetOf())

            if (subGame == Winner.P1) {
                this.add(card)
                this.add(otherCard)
            } else {
                o.add(otherCard)
                o.add(card)
            }
        } else {
            if (card > otherCard) {
                this.add(card)
                this.add(otherCard)
            } else {
                o.add(otherCard)
                o.add(card)
            }
        }
        return recursiveRound(o, historicP1, historicP2)
    }

    fun score() = cards.reversed().mapIndexed { index, i -> (index+1)*i.toLong() }.reduce { acc, l -> acc+l }

    override fun toString(): String {
        return "Player(${cards.joinToString(",")})"
    }
}

enum class Winner {
    P1, P2
}
