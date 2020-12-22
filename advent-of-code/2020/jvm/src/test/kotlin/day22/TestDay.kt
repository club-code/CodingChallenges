package day22

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day22/sample.in", "/day22/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day22/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day22/sample.in", "/day22/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day22/input.in", ::mainPart2)
    }
}