package day17

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day17/sample.in", "/day17/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day17/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day17/sample.in", "/day17/samplePart2.ans", ::mainPart2)
    }

    @Test
    fun tryPart2() {
        genericTry("/day17/input.in", ::mainPart2)
    }
}