package day7

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day7/sample.in", "/day7/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day7/input.in", ::main)
    }

    @Test
    fun tetPart2() {
        genericTest("/day7/samplePart2.in", "/day7/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tetPart2First() {
        genericTest("/day7/sample.in", "/day7/samplePart2First.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day7/input.in", ::mainPart2)
    }
}