package c

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/c/1.in", "/c/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/c/2.in", "/c/2.out", ::main)
    }

}