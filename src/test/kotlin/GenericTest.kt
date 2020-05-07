import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test

import java.io.ByteArrayOutputStream
import java.io.InputStream
import java.io.PrintStream
import kotlin.reflect.KFunction

open class GenericTest {

    lateinit var oldInput: InputStream
    lateinit var oldOutput: PrintStream

    @Before
    fun setUp(){
        oldInput = System.`in`
        oldOutput = System.out
    }

    @After
    fun tearDown(){
        System.setOut(oldOutput)
    }

    fun genericTest(input: String, output: String, method: KFunction<Unit>){
        val inp = Test::class.java.getResourceAsStream(input)
        val answer = Test::class.java.getResource(output)

        val o = ByteArrayOutputStream(1024)

        System.setIn(inp)
        System.setOut(PrintStream(o))

        method.call()

        setOldInput()
        setOldOutput()

        Assert.assertEquals(answer.readText(), o.toString())
    }

    fun setOldInput() = System.setIn(oldInput)
    private fun setOldOutput() = System.setOut(oldOutput)
}