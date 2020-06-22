package edu.uiowa

import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.paint.Color
import javafx.stage.Stage
import java.awt.Panel

class Game: Stage {
    constructor() : super() {
        game_stage = this
        grid = Grid()
        count = 0//counts how many boxes have been clicked. When count==9 and ther is no winner it is a draw
        player = 1

        this.title = "TicTacToe"
        //Creates a "veritical box"
        val vbox = VBox()

        //Within the vertical Box will create a square
        val hbox1 = HBox()
        hbox1.setPadding(Insets(15.0, 15.0, 15.0, 15.0))
        hbox1.setSpacing(10.0)//Makes it look nicer
        vbox.children.add(hbox1) //Places the box in vbox

        //Create a back button that goes to the start up page
        val back = Button()
        back.onAction = mainMenuButton
        back.text = "Back"
        hbox1.children.add(back)

        vbox.children.add(Board())
        this.run {
            scene = Scene(vbox,240.0,290.0)
            show()
        }
    }
}