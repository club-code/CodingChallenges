package day1

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day1/sample.in", "/day1/sample.ans", ::main)
    }

    @Test
    fun testTry() {
        genericTry("/day1/input.in", ::main)
    }

    @Test
    fun testSample2() {
        genericTest("/day1/sample.in", "/day1/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun testTry2() {
        genericTry("/day1/input.in", ::mainPart2)
    }


    @Test
    fun testSetSample() {
        genericTest("/day1/sample.in", "/day1/sample.ans", ::mainSet1)
    }

    @Test
    fun testSetTry() {
        genericTry("/day1/input.in", ::mainSet1)
    }

    @Test
    fun testSetSample2() {
        genericTest("/day1/sample.in", "/day1/samplePart2.ans", ::mainSet2)
    }

    @Test
    fun testSetTry2() {
        genericTry("/day1/input.in", ::mainSet2)
    }
}