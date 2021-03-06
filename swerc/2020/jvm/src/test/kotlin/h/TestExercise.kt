package h

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/h/1.in", "/h/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/h/2.in", "/h/2.out", ::main)
    }

}