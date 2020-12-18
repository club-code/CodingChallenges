package day18

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Day : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day18/sample.in", "/day18/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day18/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day18/sample.in", "/day18/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day18/input.in", ::mainPart2)
    }
}