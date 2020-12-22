package day20

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day20/sample.in", "/day20/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day20/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day20/sample.in", "/day20/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day20/input.in", ::mainPart2)
    }
}