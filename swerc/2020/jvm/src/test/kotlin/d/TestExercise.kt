package d

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/d/1.in", "/d/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/d/2.in", "/d/2.out", ::main)
    }

}