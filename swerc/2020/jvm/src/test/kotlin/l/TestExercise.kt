package l

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/l/1.in", "/l/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/l/2.in", "/l/2.out", ::main)
    }

}