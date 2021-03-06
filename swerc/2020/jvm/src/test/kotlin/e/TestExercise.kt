package e

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/e/1.in", "/e/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/e/2.in", "/e/2.out", ::main)
    }

}