package b

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise: GenericTest() {

    @Test
    fun testSample() {
        genericTest("/b/sample01.in", "/b/sample01.ans", ::main)
    }

    @Test
    fun test01() {
        genericTest("/b/01.in", "/b/01.ans", ::main)
    }

    @Test
    fun test02() {
        genericTest("/b/02.in", "/b/02.ans", ::main)
    }

    @Test
    fun test03() {
        genericTest("/b/03.in", "/b/03.ans", ::main)
    }

    @Test
    fun test04() {
        genericTest("/b/04.in", "/b/04.ans", ::main)
    }

    @Test
    fun test05() {
        genericTest("/b/05.in", "/b/05.ans", ::main)
    }

    @Test
    fun test06() {
        genericTest("/b/06.in", "/b/06.ans", ::main)
    }

    @Test
    fun test07() {
        genericTest("/b/07.in", "/b/07.ans", ::main)
    }

    @Test
    fun test08() {
        genericTest("/b/08.in", "/b/08.ans", ::main)
    }

    @Test
    fun test09() {
        genericTest("/b/09.in", "/b/09.ans", ::main)
    }

    @Test
    fun test10() {
        genericTest("/b/10.in", "/b/10.ans", ::main)
    }

    @Test
    fun test11() {
        genericTest("/b/11.in", "/b/11.ans", ::main)
    }
}