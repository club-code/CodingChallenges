package d

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testSample(){
        genericTest("/d/sample01.in", "/d/sample01.ans", ::main)
    }

    @Test
    fun testSample02(){
        genericTest("/d/sample02.in", "/d/sample02.ans", ::main)
    }

    @Test
    fun testSample03(){
        genericTest("/d/sample03.in", "/d/sample03.ans", ::main)
    }

    @Test
    fun testSample04(){
        genericTest("/d/sample04.in", "/d/sample04.ans", ::main)
    }

    @Test
    fun testSample05(){
        genericTest("/d/sample05.in", "/d/sample05.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/d/test01.in", "/d/test01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/d/test02.in", "/d/test02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/d/test03.in", "/d/test03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/d/test04.in", "/d/test04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/d/test05.in", "/d/test05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/d/test06.in", "/d/test06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/d/test07.in", "/d/test07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/d/test08.in", "/d/test08.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/d/test09.in", "/d/test09.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/d/test10.in", "/d/test10.ans", ::main)
    }
}