package day19

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day19/sample.in", "/day19/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day19/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day19/samplePart2.in", "/day19/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day19/input.in", ::mainPart2)
    }
}