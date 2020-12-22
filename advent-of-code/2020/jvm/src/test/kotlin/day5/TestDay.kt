package day5

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day5/sample.in", "/day5/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day5/input.in", ::main)
    }

    @Test
    fun tryPart2() {
        genericTry("/day5/input.in", ::mainPart2)
    }

}