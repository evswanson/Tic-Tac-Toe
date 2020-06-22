package edu.uiowa

import org.junit.Test
import org.junit.Assert.*

class project2820Test{
    @Test
    fun test1(){
        val s = Player1()
        val t = Player2()
        assertEquals(s.color, "red")
        assertEquals(s.shape, "X")
        assertEquals(s.number, 1)
        assertEquals(t.color, "blue")
        assertEquals(t.shape, "O")
        assertEquals(t.number, 2)
    }

    @Test
    fun test2(){
        val x = Player1()
        val g = Grid()
        x.Move("1",g)
        x.Move("2",g)
        assertEquals(Done(g).check(), false)
        x.Move("3",g)
        assertEquals(Done(g).check(), true)

    }
}

