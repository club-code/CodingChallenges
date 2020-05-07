package swerc2018.d

import GenericTest
import org.junit.Ignore
import org.junit.Test


class Test: GenericTest() {

    @Test
    fun testSample01(){
        genericTest("/swerc2018/d/sample01.in", "/swerc2018/d/sample01.ans", ::main)
    }

    @Test
    fun testSample02(){
        genericTest("/swerc2018/d/sample02.in", "/swerc2018/d/sample02.ans", ::main)
    }

    @Test
    fun testTest03(){
        genericTest("/swerc2018/d/test03.in", "/swerc2018/d/test03.ans", ::main)
    }

    @Test
    fun testTest04(){
        genericTest("/swerc2018/d/test04.in", "/swerc2018/d/test04.ans", ::main)
    }

    @Test
    fun testTest05(){
        genericTest("/swerc2018/d/test05.in", "/swerc2018/d/test05.ans", ::main)
    }

    @Test
    fun testTest06(){
        genericTest("/swerc2018/d/test06.in", "/swerc2018/d/test06.ans", ::main)
    }

    @Test // lent
    fun testTest07(){
        genericTest("/swerc2018/d/test07.in", "/swerc2018/d/test07.ans", ::main)
    }

    @Test
    fun testTest08(){
        genericTest("/swerc2018/d/test08.in", "/swerc2018/d/test08.ans", ::main)
    }

    @Test
    fun testTest09(){
        genericTest("/swerc2018/d/test09.in", "/swerc2018/d/test09.ans", ::main)
    }

    @Test //lent
    fun testTest10(){
        genericTest("/swerc2018/d/test10.in", "/swerc2018/d/test10.ans", ::main)
    }

    @Test
    fun testTest11(){
        genericTest("/swerc2018/d/test11.in", "/swerc2018/d/test11.ans", ::main)
    }

    @Ignore // Trop lent !
    @Test
    fun testTest12(){
        genericTest("/swerc2018/d/test12.in", "/swerc2018/d/test12.ans", ::main)
    }

}