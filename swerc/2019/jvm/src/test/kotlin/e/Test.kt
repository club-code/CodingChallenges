package e

import org.clubcode.library.test.GenericTest
import org.junit.Test

class Test: GenericTest() {

    @Test
    fun testToggle() {
        println(booleanArrayOf(true, true, false, false, true, false, false, false, true).toggle(3).joinToString(" ") { if(it) "1" else "0" })
    }

    @Test
    fun testMy01(){
        genericTest("/e/my01.in", "/e/my01.ans", ::main)
    }

    @Test
    fun testMy02(){
        genericTest("/e/my02.in", "/e/my02.ans", ::main)
    }

    @Test
    fun testSample(){
        genericTest("/e/sample01.in", "/e/sample01.ans", ::main)
    }

    @Test
    fun testSample02(){
        genericTest("/e/sample02.in", "/e/sample02.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/e/secret01.in", "/e/secret01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/e/secret02.in", "/e/secret02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/e/secret03.in", "/e/secret03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/e/secret04.in", "/e/secret04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/e/secret05.in", "/e/secret05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/e/secret06.in", "/e/secret06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/e/secret07.in", "/e/secret07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/e/secret08.in", "/e/secret08.ans", ::main)
    }

    @Test
    fun test09(){
        genericTest("/e/secret09.in", "/e/secret09.ans", ::main)
    }

    @Test
    fun test10(){
        genericTest("/e/secret10.in", "/e/secret10.ans", ::main)
    }
}