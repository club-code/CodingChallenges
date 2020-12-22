package day21

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day21/sample.in", "/day21/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day21/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day21/sample.in", "/day21/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day21/input.in", ::mainPart2)
    }
}