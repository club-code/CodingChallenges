package d

import org.clubcode.library.test.GenericTest
import org.junit.Test

class TestExercise : GenericTest() {
    @Test
    fun testSample() {
        genericTest("/d/sample01.in", "/d/sample01.ans", ::main)
    }

    @Test
    fun testSample2() {
        genericTest("/d/sample02.in", "/d/sample02.ans", ::main)
    }

    @Test
    fun test01() {
        genericTest("/d/test01.in", "/d/test01.ans", ::main)
    }

    @Test
    fun test02() {
        genericTest("/d/test02.in", "/d/test02.ans", ::main)
    }

    @Test
    fun test03() {
        genericTest("/d/test03.in", "/d/test03.ans", ::main)
    }

    @Test
    fun test04() {
        genericTest("/d/test04.in", "/d/test04.ans", ::main)
    }

    @Test
    fun test05() {
        genericTest("/d/test05.in", "/d/test05.ans", ::main)
    }

    @Test
    fun test06() {
        genericTest("/d/test06.in", "/d/test06.ans", ::main)
    }
}