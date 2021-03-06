package b

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/b/1.in", "/b/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/b/2.in", "/b/2.out", ::main)
    }

}