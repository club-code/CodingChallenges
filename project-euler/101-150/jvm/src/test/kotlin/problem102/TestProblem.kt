package problem102

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestProblem : GenericTest() {
    @Test
    fun testSample() {
        genericTest("/problem102/sample.in", "/problem102/sample.ans", ::main)
    }

    @Test
    fun tryAll() {
        genericTry("/problem102/input.in", ::main)
    }
}
