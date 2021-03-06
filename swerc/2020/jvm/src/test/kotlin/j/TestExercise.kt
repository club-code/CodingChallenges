package j

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/j/1.in", "/j/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/j/2.in", "/j/2.out", ::main)
    }

}