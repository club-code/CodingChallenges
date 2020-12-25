package day25

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day25/sample.in", "/day25/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day25/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day25/sample.in", "/day25/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day25/input.in", ::mainPart2)
    }
}