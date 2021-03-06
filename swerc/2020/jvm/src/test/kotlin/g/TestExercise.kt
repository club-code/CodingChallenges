package g

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/g/1.in", "/g/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/g/2.in", "/g/2.out", ::main)
    }

}