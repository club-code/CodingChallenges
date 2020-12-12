package c

import library.Vector2
import org.junit.Test
import org.junit.Assert.*

class ExoTest {
    @Test
    fun test() {
        val res = exo(arrayOf(Vector2(2, 3), Vector2(4, 3), Vector2(1, 1), Vector2(0, 0), Vector2(3, 2), Vector2(4, 1)))
        assertEquals(11, res)
    }
}