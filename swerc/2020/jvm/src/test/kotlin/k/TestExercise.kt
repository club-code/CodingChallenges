package k

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/k/1.in", "/k/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/k/2.in", "/k/2.out", ::main)
    }

}