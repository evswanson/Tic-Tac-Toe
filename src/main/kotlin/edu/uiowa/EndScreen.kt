package edu.uiowa

import javafx.geometry.Insets
import javafx.scene.Scene
import javafx.scene.control.Button
import javafx.scene.control.Label
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.stage.Stage

class GameOver: Stage {
    constructor(): super(){
        current_stage = this
        this.title = "Game Over"
        var vbox = VBox()
        var announce = HBox()
        announce.setPadding(Insets(10.0, 5.0,10.0,10.0))
        var winner = Label()
        //If count = 9 that means that they went through all the moves
        if(count == 9 && Done(grid).check()==false){
            winner = Label("\t\t\tIt's A Draw!")
        }
        else {
            //When player =1 it means that it would be his turn if player 2 didn't just win
            when (player) {
                1 -> winner = Label("Congratulations Player 2 You are The Winner!")
                2 -> winner = Label("Congratulations Player 1 You are The Winner!")
            }
        }
        winner.font = Font.font(20.0)
        announce.children.add(winner)
        vbox.children.add(announce)
        //creating the buttons for the screen
        var buttons = HBox()
        buttons.setPadding(Insets(10.0,5.0,10.0,10.0))
        buttons.spacing = 10.0

        //Button to play the same gamemode again
        var playAgain = Button()
        playAgain.onAction = StartGame()
        playAgain.text = "Play Again"
        buttons.children.add(playAgain)

        //Button to return to the main menu
        var mainMenu = Button()
        mainMenu.onAction = mainMenuButton
        mainMenu.text = "Return to Main Menu"
        buttons.children.add(mainMenu)

        //Button that exits the game
        var endGame = Button()
        endGame.onAction = exitButton
        endGame.text = "Leave Game"
        buttons.children.add(endGame)

        vbox.children.add(buttons)

        this.run{
            scene = Scene(vbox, 420.0, 100.0)
            show()
        }
    }
}
