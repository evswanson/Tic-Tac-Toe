package edu.uiowa

import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font
import javafx.event.EventHandler

class SuperBoard: VBox {
    constructor(): super() {
        //Creates all the buttons that the players can click
        var c = 1//Used to create the id's for the buttons
        for(i in 1..3){
            val buttons = HBox()
            buttons.setPadding(Insets(0.0, 15.0, 0.0, 15.0))
            for(j in 1..3){
                val b = Button()
                b.onAction = buttonSuper
                b.onMouseEntered = letterHover//Button event is located in the 3X3Board file
                b.onMouseExited = exitLetterHover//Button event is located in the 3X3Board file
                b.focusTraversableProperty().set(false)//Makes it so the buttons don't have a border
                b.id = c.toString()
                b.setMinSize(70.0,70.0)
                buttons.children.add(b)
                c++
            }
            this.children.add(buttons)
            this.style = "-fx-background-color:#FFFFFF"
        }
    }
}

object buttonSuper: EventHandler<javafx.event.ActionEvent> {
    override fun handle(event: javafx.event.ActionEvent) {
        val size = mega.size
        var t = event.source as Button
        //For the first move of the game and if the box they make the other player go to is disabled
        // then the box they click in will put the move in the corresponding grid
        if(mega.contains(grid) == false){
            for(i in 0.rangeTo(size-1)){
                if(t.parent.parent == listBoard[i]){
                    grid = mega.get(i)
                }
            }
        }
        t.font = Font.font(30.0)
        if (player == 1) {
            t.text = x.shape
            t.textFill = javafx.scene.paint.Paint.valueOf(x.color)
            x.Move(t.id, grid)
            //Will make the color in the box red because X won
            if(Done(grid).check() == true){
                t.parent.parent.style = "-fx-background-color:#FF0000"
                //places the winner of the board into the grid that will determine the winner overall
                x.Move((listBoard.indexOf(t.parent.parent)+1).toString(), BigGrid)
                count++
                t.parent.parent.isDisable = true//Once someone wins the square it is impossible to use that board
            }
            grid = mega.get(t.id.toInt() - 1)//Switches the grid to the correct one
            player = 2
        } else {
            t.text = o.shape
            t.textFill = javafx.scene.paint.Paint.valueOf(o.color)
            o.Move(t.id, grid)
            //Will make color in the box blue because O won
            if(Done(grid).check() == true){
                t.parent.parent.style = "-fx-background-color:#3346FF"
                //places the winner of the board into the grid that will determine the winner overall
                o.Move((listBoard.indexOf(t.parent.parent)+1).toString(), BigGrid)
                count++
                t.parent.parent.isDisable = true//Once someone wins the square it is impossible to use that board
            }
            grid = mega.get(t.id.toInt() - 1)
            player = 1
        }
        //Cannot move in the same spot as the button just clicked
        t.isDisable = true
        //When you move the mouse away from the button it will not set the button text to blank
        t.onMouseExited = null
        //Will Disable all the boards except for the one that will become playable
        for(i in 0.rangeTo(size-1)){
            if(i!=t.id.toInt()-1){
                listBoard[i].isDisable = true
            }
            //When the grid the person clicks is already chosen it will allow the next player to pick any box that hasn't been won
            else if(i==t.id.toInt()-1&&Done(mega.get(i)).check()==true){
                listBoard[i].isDisable = true
                for(j in 0.rangeTo(size-1)){
                    if(Done(mega.get(j)).check()==false){
                        listBoard[j].isDisable = false
                    }
                }
                grid = Grid()
                break
            }
            else{
                listBoard[i].isDisable = false
            }
        }
        //When someone wins the game
        if(Done(BigGrid).check()==true){
            SuperEndScreen()
            for(i in 0.rangeTo(size-1)){
                listBoard[i].isDisable = true
            }
        }
    }
}
