package day3

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Day : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day3/sample.in", "/day3/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day3/input.in", ::main)
    }

    @Test
    fun testSamplePart2() {
        genericTest("/day3/sample.in", "/day3/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day3/input.in", ::mainPart2)
    }

}