package day15

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Day : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day15/sample.in", "/day15/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day15/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day15/sample.in", "/day15/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day15/input.in", ::mainPart2)
    }
}