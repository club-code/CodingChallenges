package problem

import org.clubcode.library.test.BUFFER_SIZE
import org.clubcode.library.test.GenericTest
import org.junit.Test
import java.io.ByteArrayOutputStream
import kotlin.reflect.KFunction


class TestProblem : GenericTest() {
    @Test
    fun testTryA() {
        genericFile("/problem/a.txt", ::main, arrayOf("a"))
    }

    @Test
    fun testTryB() {
        genericFile("/problem/b.txt", ::main, arrayOf("b"))
    }

    @Test
    fun testTryC() {
        genericFile("/problem/c.txt", ::main, arrayOf("c"))
    }

    @Test
    fun testTryD() {
        genericFile("/problem/d.txt", ::main, arrayOf("d"))
    }

    @Test
    fun testTryE() {
        genericFile("/problem/e.txt", ::main, arrayOf("e"))
    }

    @Test
    fun testTryF() {
        genericFile("/problem/f.txt", ::main, arrayOf("f"))
    }

    private fun setOld() = System.setOut(oldOutput)
    private fun genericFile(input: String, method: KFunction<Unit>, args: Array<String>) {
        val inp = GenericTest::class.java.getResourceAsStream(input)
        val o = ByteArrayOutputStream(BUFFER_SIZE*10)
        System.setIn(inp)

        method.call(args)

        setOld()
        o.close()
    }

}