package e

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {
    @Test
    fun testSample() {
        genericTest("/e/sample01.in", "/e/sample01.ans", ::main)
    }

    @Test
    fun test01() {
        genericTest("/e/test01.in", "/e/test01.ans", ::main)
    }

    @Test
    fun test02() {
        genericTest("/e/test02.in", "/e/test02.ans", ::main)
    }

    @Test
    fun test03() {
        genericTest("/e/test03.in", "/e/test03.ans", ::main)
    }

    @Test
    fun test04() {
        genericTest("/e/test04.in", "/e/test04.ans", ::main)
    }

    @Test
    fun test05() {
        genericTest("/e/test05.in", "/e/test05.ans", ::main)
    }

    @Test
    fun test06() {
        genericTest("/e/test06.in", "/e/test06.ans", ::main)
    }

    @Test
    fun test07() {
        genericTest("/e/test07.in", "/e/test07.ans", ::main)
    }

    @Test
    fun test08() {
        genericTest("/e/test08.in", "/e/test08.ans", ::main)
    }

    @Test
    fun test09() {
        genericTest("/e/test09.in", "/e/test09.ans", ::main)
    }

    @Test
    fun test10() {
        genericTest("/e/test10.in", "/e/test10.ans", ::main)
    }
}
