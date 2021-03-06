package i

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/i/1.in", "/i/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/i/2.in", "/i/2.out", ::main)
    }

}