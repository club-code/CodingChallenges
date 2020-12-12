package day6

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Day : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day6/sample.in", "/day6/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day6/input.in", ::main)
    }

    @Test
    fun tetPart2() {
        genericTest("/day6/sample.in", "/day6/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day6/input.in", ::mainPart2)
    }
}