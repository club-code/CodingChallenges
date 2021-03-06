package f

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/f/1.in", "/f/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/f/2.in", "/f/2.out", ::main)
    }

}