package a

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun test1() {
        genericTest("/a/1.in", "/a/1.out", ::main)
    }

    @Test
    fun test2() {
        genericTest("/a/2.in", "/a/2.out", ::main)
    }

}