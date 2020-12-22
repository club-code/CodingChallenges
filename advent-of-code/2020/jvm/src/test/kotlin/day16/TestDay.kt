package day16

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day16/sample.in", "/day16/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day16/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTry("/day16/samplePart2.in", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day16/input.in", ::mainPart2)
    }
}