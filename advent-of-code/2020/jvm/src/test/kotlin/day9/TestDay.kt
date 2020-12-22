package day9

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day9/sample.in", "/day9/sample.ans", ::mainSample)
    }

    @Test
    fun tryPart1() {
        genericTry("/day9/input.in", ::main)
    }

    @Test
    fun testPart2() {
        genericTest("/day9/sample.in", "/day9/samplePart2.ans", ::mainSamplePart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day9/input.in", ::mainPart2)
    }
}