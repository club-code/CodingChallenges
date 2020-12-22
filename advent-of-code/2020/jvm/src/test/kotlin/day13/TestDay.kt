package day13

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day13/sample.in", "/day13/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day13/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day13/sample.in", "/day13/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun testSample2Part2() {
        genericTest("/day13/sample2Part2.in", "/day13/sample2Part2.ans", ::mainPart2)
    }


    @Test
    fun tryPart2() {
        genericTry("/day13/input.in", ::mainPart2)
    }
}