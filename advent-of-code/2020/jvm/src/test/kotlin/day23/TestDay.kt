package day23

import org.clubcode.library.test.GenericTest
import org.junit.Test


class TestDay : GenericTest() {

    @Test
    fun testSample() {
        genericTest("/day23/sample.in", "/day23/sample.ans", ::main)
    }

    @Test
    fun tryPart1() {
        genericTry("/day23/input.in", ::main)
    }


    @Test
    fun trySamplePart2() {
        genericTest("/day23/sample.in", "/day23/samplePart2.ans", ::mainPart2)
    }

//    @Test
//    fun tryPart2() {
//        genericTry("/day23/input.in", ::mainPart2)
//    }
}