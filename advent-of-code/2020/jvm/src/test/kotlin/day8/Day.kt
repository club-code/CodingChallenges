package day8

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Day : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day8/sample.in", "/day8/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day8/input.in", ::main)
    }

    @Test
    fun testPart2() {
        genericTest("/day8/sample.in", "/day8/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day8/input.in", ::mainPart2)
    }
}