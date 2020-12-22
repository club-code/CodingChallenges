package day12

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day12/sample.in", "/day12/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day12/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day12/sample.in", "/day12/samplePart2.ans", ::mainPart2)
    }


    @Test
    fun tryPart2() {
        genericTry("/day12/input.in", ::mainPart2)
    }
}