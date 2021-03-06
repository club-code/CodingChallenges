package c

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {
    @Test
    fun test() {
        genericTest("/c/sample01.in", "/c/sample01.ans", ::main)
    }

    @Test
    fun test01() {
        genericTest("/c/test01.in", "/c/test01.ans", ::main)
    }

    @Test
    fun test02() {
        genericTest("/c/test02.in", "/c/test02.ans", ::main)
    }

    @Test
    fun test03() {
        genericTest("/c/test03.in", "/c/test03.ans", ::main)
    }

    @Test
    fun test04() {
        genericTest("/c/test04.in", "/c/test04.ans", ::main)
    }

    @Test
    fun test05() {
        genericTest("/c/test05.in", "/c/test05.ans", ::main)
    }

    @Test
    fun test06() {
        genericTest("/c/test06.in", "/c/test06.ans", ::main)
    }

    @Test
    fun test07() {
        genericTest("/c/test07.in", "/c/test07.ans", ::main)
    }

    @Test
    fun test08() {
        genericTest("/c/test08.in", "/c/test08.ans", ::main)
    }

    @Test
    fun test09() {
        genericTest("/c/test09.in", "/c/test09.ans", ::main)
    }
}