package problem101

import org.clubcode.library.polynomial.Polynomial
import org.clubcode.library.test.GenericTest
import org.junit.Assert.assertEquals
import org.junit.Test

class TestProblem : GenericTest() {
    @Test
    fun testSample() {
        assertEquals(74, main(Polynomial(0.0,0.0,0.0,1.0)))
    }

    @Test
    fun tryInput() {
        println(main(Polynomial(1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0, -1.0, 1.0)))
    }
}
