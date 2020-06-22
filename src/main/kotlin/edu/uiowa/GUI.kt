package edu.uiowa

import javafx.application.Application
import javafx.application.Application.launch
import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.Node
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.control.RadioButton
import javafx.scene.control.TextField
import javafx.stage.Stage
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.control.ToggleGroup
import javafx.scene.text.Font
import java.awt.Color
import java.awt.Paint
import javax.xml.soap.Text
import kotlin.math.nextTowards

var current_stage: Stage? = null  // to remember which stage we are on
var start_stage: Stage? = null
var game_stage: Stage? = null //The stage for the games
var player:Int = 0
val x = Player1()
val o = Player2()
var grid = Grid()
var count = 0

//The first screen that will pop up
class MyForm: Application() {
    override fun start(primaryStage: Stage) {
        start_stage = primaryStage
        primaryStage.title = "Startup Screen"
        var vbox = VBox()
        var hbox1 = HBox()
        val start = HBox()
        val big = HBox()
        val end = HBox()

        val title = Label("TikTacToe")
        title.font = Font.font(20.0)
        hbox1.children.add(title)
        hbox1.setPadding(Insets(5.0,5.0,2.0,55.0))
        //Starts the 3X3 game of TicTacToe
        val startButton = Button()
        startButton.onAction = StartGame()
        startButton.text = "Original TicTacToe"
        start.children.add(startButton)
        start.setPadding(Insets( 15.0,15.0,15.0,15.0 ))
        //Button for the giant game of TicTacToe
        val biggy = Button()
        biggy.onAction = biggyButton
        biggy.text = "Super TicTacToe"
        big.children.add(biggy)
        big.setPadding(Insets(0.0,15.0,15.0,15.0))
        //Button that will leave the game
        var leave = Button()
        leave.onAction = exitButton
        leave.text = "Leave Game"
        end.children.add(leave)
        end.setPadding(Insets(0.0,15.0,15.0,15.0))

        vbox.children.add(hbox1)
        vbox.children.add(start)
        vbox.children.add(big)
        vbox.children.add(end)

        primaryStage.run{
            scene = Scene(vbox, 200.0, 200.0)
            show()
        }
    }
}
class StartGame: EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent?) {
        current_stage?.hide()
        start_stage?.hide()
        game_stage?.hide()
        Game()
    }
}

//Returns you to the start up stage
object mainMenuButton: EventHandler<ActionEvent> {
    override fun handle(event: ActionEvent?) {
        current_stage?.hide()
        game_stage?.hide()
        start_stage?.show()

    }
}
//Ends the Game
object exitButton: EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent?) {
        game_stage?.hide()
        current_stage?.hide()
        start_stage?.hide()
    }
}
//Starts the Super TicTacToe game
object biggyButton:EventHandler<ActionEvent>{
    override fun handle(event: ActionEvent?) {
        start_stage?.hide()
        game_stage?.hide()
        current_stage?.hide()
        SuperGame()
    }
}

fun main(args: Array<String>){
    launch(MyForm::class.java)
}