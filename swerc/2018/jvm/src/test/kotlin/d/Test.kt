package d

import org.clubcode.library.test.GenericTest
import org.junit.Ignore
import org.junit.Test


class Test: GenericTest() {

    @Test
    fun testSample01(){
        genericTest("/d/sample01.in", "/d/sample01.ans", ::main)
    }

    @Test
    fun testSample02(){
        genericTest("/d/sample02.in", "/d/sample02.ans", ::main)
    }

    @Test
    fun testTest03(){
        genericTest("/d/test03.in", "/d/test03.ans", ::main)
    }

    @Test
    fun testTest04(){
        genericTest("/d/test04.in", "/d/test04.ans", ::main)
    }

    @Test
    fun testTest05(){
        genericTest("/d/test05.in", "/d/test05.ans", ::main)
    }

    @Test
    fun testTest06(){
        genericTest("/d/test06.in", "/d/test06.ans", ::main)
    }

    @Test // lent
    fun testTest07(){
        genericTest("/d/test07.in", "/d/test07.ans", ::main)
    }

    @Test
    fun testTest08(){
        genericTest("/d/test08.in", "/d/test08.ans", ::main)
    }

    @Test
    fun testTest09(){
        genericTest("/d/test09.in", "/d/test09.ans", ::main)
    }

    @Test //lent
    fun testTest10(){
        genericTest("/d/test10.in", "/d/test10.ans", ::main)
    }

    @Test
    fun testTest11(){
        genericTest("/d/test11.in", "/d/test11.ans", ::main)
    }

    @Ignore // Trop lent !
    @Test
    fun testTest12(){
        genericTest("/d/test12.in", "/d/test12.ans", ::main)
    }

}