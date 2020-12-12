package b

import org.junit.Test
import org.junit.Assert.*

class ExoTest {

    @Test
    fun test() {
        val res = exo(arrayOf(Vector(2, 3), Vector(4, 3), Vector(1, 1), Vector(3, 1), Vector(0, 0), Vector(3, 2)))
        assertEquals(res, Hiding(Vector(3, 1)))
    }

}