package day2

import org.clubcode.library.test.GenericTest
import org.junit.Test


class Day : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day2/sample.in", "/day2/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day2/input.in", ::main)
    }


    @Test
    fun testSamplePart2() {
        genericTest("/day2/sample.in", "/day2/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day2/input.in", ::mainPart2)
    }

}