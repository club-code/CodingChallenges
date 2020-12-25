package h

const val M = 1L shl 40
const val x0 = 0x600DCAFEL

fun f(x: Long) = (x + (x shr 20) + 12345L) % M

fun <T> cycleFloyd(f: (T) -> T, a0: T): Cycle {
    var tortoise = f(a0)
    var hare = f(f(a0))
    while (tortoise != hare) {
        tortoise = f(tortoise)
        hare = f(f(hare))
    }

    var mu = 0L
    tortoise = a0
    while (tortoise != hare) {
        tortoise = f(tortoise)
        hare = f(hare)
        mu++
    }

    var lambda = 1L
    hare = f(tortoise)
    while (tortoise != hare) {
        hare = f(hare)
        lambda++
    }

    return Cycle(lambda, mu)
}

data class Cycle(val lambda: Long, val mu: Long)
