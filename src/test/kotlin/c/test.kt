package c

import org.junit.Test
import org.junit.Assert.*
import library.Vector

class ExoTest {
    @Test
    fun test() {
        val res = exo(arrayOf(Vector(2, 3), Vector(4, 3), Vector(1, 1), Vector(0, 0), Vector(3, 2), Vector(4, 1)))
        assertEquals(11, res)
    }
}