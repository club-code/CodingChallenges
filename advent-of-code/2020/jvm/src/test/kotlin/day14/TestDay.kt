package day14

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day14/sample.in", "/day14/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day14/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day14/samplePart2.in", "/day14/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day14/input.in", ::mainPart2)
    }
}