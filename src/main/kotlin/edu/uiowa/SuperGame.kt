package edu.uiowa

import javafx.geometry.Insets
import javafx.scene.Group
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.stage.Stage
val mega = listOf(Grid(),Grid(), Grid(),Grid(),Grid(),Grid(),Grid(),Grid(),Grid())//Will hold all the grids for the super TicTacToe
var BigGrid = Grid()//Grid that will determine the overall winner of Super TicTacToe
var listBoard = mutableListOf<Node>()//Puts all the SuperBoards created into a lis
class SuperGame:Stage{
    constructor():super(){
        count = 0//Keeps count of the number of boxes in the BigGrid. Once it ==9 the game is a draw
        game_stage = this
        BigGrid = Grid()
        player = 1
        grid = Grid()
        var vbox = VBox()
        this.title = "Super TicTacToe"
        for(i in 1..3) {
            var hbox = HBox()
            hbox.setPadding(Insets(10.0,0.0,10.0,0.0))
            for (j in 1..3) {
                hbox.children.add(SuperBoard())
                listBoard.add(hbox.children[j-1])
            }

            vbox.children.add(hbox)
        }

        this.run{
            scene = Scene(vbox)
            show()
        }
        //println(listBoard)Used for testing to check if the board in hbox matched up with it
    }
}