package day24

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day24/sample.in", "/day24/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day24/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day24/sample.in", "/day24/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day24/input.in", ::mainPart2)
    }
}