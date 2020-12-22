package day4

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day4/sample.in", "/day4/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day4/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day4/samplePart2.in", "/day4/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day4/input.in", ::mainPart2)
    }

}