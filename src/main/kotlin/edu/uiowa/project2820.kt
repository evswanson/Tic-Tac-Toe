package edu.uiowa

// this is where you will begin the first version of your project
// but you will also need to connect this project with your github.uiowa.edu
// repository, as explained in the discussion section 9th November
interface IPlayers{
    val number: Int
    val color: String
    val shape: String
}
class Player1: IPlayers {
    override val number:Int
        get() = 1
    override val color: String
        get() = "red"
    override val shape: String
        get() = "X"

    fun Move(r:String, g:Grid){
        var i:Int
        var j = 1
        var c = 0
        for(e in g.r) {
            i=0
            if (r in e) {
                while (i < e.size) {
                    if (j == r.toInt()) {
                        e[i] = shape
                        c++
                    }
                    i++
                    j++
                    //println(j) was used to test what value j was
                }
            }
            //if the number is not in the array add 3 to j for the next row/array
            else j+=3
        }
        //Made a var c that if left at 0 will tell the user that the move they put in is invalid
        if(c==0){
            println("Move is invalid. Please pick a spot without a letter.")
        }
        println()
        for(e in g.r){
            println(e.toList())
        }
        //Goes to class Done(g) to see if the player won
        if(Done(g).check() == true) println("The winner is Player 1!")
    }
}

class Player2: IPlayers{
    override val number:Int
        get() = 2
    override val color: String
        get() = "blue"
    override val shape: String
        get() = "O"

    fun Move(r:String, g:Grid){
        var i:Int
        var j = 1
        var c = 0
        for(e in g.r) {
            i=0
            if (r in e) {
                while (i < e.size) {
                    if (j == r.toInt()) {
                        e[i] = shape
                        c++
                    }
                    i++
                    j++
                    //println(j) was used to test what value j was
                }
            }
            //if the number is not in the array add 3 to j for the next row/array
            else j+=3
        }
        //Made a var c that if left at 0 will tell the user that the move they put in is invalid
        if(c==0){
            println()
            println("Move is invalid. Please pick a spot without a letter.")
        }
        println()
        for(e in g.r){
            println(e.toList())
        }
        //Goes to the class Done(g) to see if the player won
        if(Done(g).check() == true) println("The winner is Player 2!")
    }
}
//Checks to see if there is a winner
class Done(g:Grid){
    var g = g
    var s = listOf("X","O")
    val m = mutableMapOf(Pair<Int,String>(0,""))
    //Creates a map with all of the spots in the grid and pairs it the String in the spot
    fun check():Boolean{
        var j = 1
        for(e in g.r){
            for(i in e){
                m.put(j,i)
                j++
            }
        }
        //removes the first key in the map
        m.remove(0)
        //println(m.toMap()) Used for testing
        //Goes through the map and compares it to the letter X and O and checks if there is a winner
        for(e in s) {
            for (i in m) {
                //All the possible ways to win of a 3X3 board
                when (i.key) {
                    1 -> if ((e == m.get(1)&&e==m.get(2)&&e==m.get(3))||(e==m.get(1)&&e==m.get(5)&&e==m.get(9))||
                            (e==m.get(1)&&e==m.get(4)&&e==m.get(7)))return true
                    2 -> if(e==m.get(2)&&e==m.get(5)&&e==m.get(8)) return true
                    3 -> if(e==m.get(3)&&e==m.get(6)&&e==m.get(9)) return true
                    4 -> if(e==m.get(4)&&e==m.get(5)&&e==m.get(6)) return true
                    7 -> if ((e == m.get(7)&&e==m.get(5)&&e==m.get(3))||(e==m.get(7)&&e==m.get(4)&&e==m.get(1))||
                            (e==m.get(7)&&e==m.get(8)&&e==m.get(9)))return true
                }
            }
        }
        return false
    }
}
//Creates an array of arrays that act like the board
class Grid{
    var r1 = arrayOf("1", "2","3")
    var r2 = arrayOf("4", "5", "6")
    var r3 = arrayOf("7", "8", "9")
    var r: Array<Array<String>> = arrayOf(r1,r2,r3)
}

fun main(args: Array<String>) {
    // you can do some testing here, though unit testing needs to be
    // in the src/test/java directory
    val x = Player1()
    val o = Player2()
    val g = Grid()

    println(g.r1.toList())
    println(g.r2.toList())
    println(g.r3.toList())
    x.Move("5",g)
    o.Move("2",g)
    x.Move("9",g)
    o.Move("9",g)
    o.Move("3",g)
    x.Move("1",g)
}