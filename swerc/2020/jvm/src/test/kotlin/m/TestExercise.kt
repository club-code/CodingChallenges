package m

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/m/1.in", "/m/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/m/2.in", "/m/2.out", ::main)
    }

}