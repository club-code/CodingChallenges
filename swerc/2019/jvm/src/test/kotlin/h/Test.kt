package h

import org.clubcode.library.test.GenericTest
import org.junit.Assert.assertEquals
import org.junit.Test

class Test: GenericTest() {

     @Test
     fun testCycle() {
         assertEquals(Cycle(182129209L, 350125310L), cycleFloyd(::f, x0))
     }

    @Test
    fun testSample(){
        genericTest("/h/sample01.in", "/h/sample01.ans", ::main)
    }

    @Test
    fun testSample2(){
        genericTest("/h/sample02.in", "/h/sample02.ans", ::main)
    }

    @Test
    fun test00(){
        genericTest("/h/test00.in", "/h/test00.ans", ::main)
    }

    @Test
    fun test01(){
        genericTest("/h/test01.in", "/h/test01.ans", ::main)
    }

    @Test
    fun test02(){
        genericTest("/h/test02.in", "/h/test02.ans", ::main)
    }

    @Test
    fun test03(){
        genericTest("/h/test03.in", "/h/test03.ans", ::main)
    }

    @Test
    fun test04(){
        genericTest("/h/test04.in", "/h/test04.ans", ::main)
    }

    @Test
    fun test05(){
        genericTest("/h/test05.in", "/h/test05.ans", ::main)
    }

    @Test
    fun test06(){
        genericTest("/h/test06.in", "/h/test06.ans", ::main)
    }

    @Test
    fun test07(){
        genericTest("/h/test07.in", "/h/test07.ans", ::main)
    }

    @Test
    fun test08(){
        genericTest("/h/test08.in", "/h/test08.ans", ::main)
    }

}