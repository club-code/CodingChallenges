package day10

import org.clubcode.library.test.GenericTest
import org.junit.Assert.assertEquals
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day10/sample.in", "/day10/sample.ans", ::main)
    }

    @Test
    fun testSampleLarger() {
        genericTest("/day10/sampleLarger.in", "/day10/sampleLarger.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day10/input.in", ::main)
    }

    @Test
    fun fibonacciThree() {
        assertEquals(24, fibonacciThree(5).first)
    }

    @Test
    fun testSamplePart2() {
        genericTest("/day10/sample.in", "/day10/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun testSampleLargerPart2() {
        genericTest("/day10/sampleLarger.in", "/day10/sampleLargerPart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day10/input.in", ::mainPart2)
    }
}