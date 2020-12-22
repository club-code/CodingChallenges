package day11

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day11/sample.in", "/day11/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day11/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day11/sample.in", "/day11/samplePart2.ans", ::mainPart2)
    }


    @Test
    fun tryPart2() {
        genericTry("/day11/input.in", ::mainPart2)
    }
}