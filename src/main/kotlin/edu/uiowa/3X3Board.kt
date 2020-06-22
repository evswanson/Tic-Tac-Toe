package edu.uiowa

import javafx.event.ActionEvent
import javafx.event.EventHandler
import javafx.geometry.Insets
import javafx.scene.control.Button
import javafx.scene.input.MouseEvent
import javafx.scene.layout.HBox
import javafx.scene.layout.VBox
import javafx.scene.text.Font


class Board: VBox {
    constructor(): super() {
        //Creates all the buttons that the player(s) can click
        var c = 1//Creates the id name for the buttons
        for(i in 1..3){
            val buttons = HBox()
            buttons.setPadding(Insets(0.0, 15.0, 0.0, 15.0))
            //buttons.setSpacing(10.0)
            for(j in 1..3){
                val b = Button()
                b.onAction = buttonController
                b.onMouseEntered = letterHover
                b.onMouseExited = exitLetterHover
                b.focusTraversableProperty().set(false)//Makes it so the buttons don't have a border. Makes it look nicer
                b.id = c.toString()
                b.setMinSize(70.0,70.0)
                buttons.children.add(b)
                c++
            }
            this.children.add(buttons)
        }
    }
}
//Will erase the letter in the box once the mouse leaves it
object exitLetterHover: EventHandler<MouseEvent>{
    override fun handle(event: MouseEvent?) {
        var t = event?.source as Button
        t.text = ""

    }
}
//Will show the x or the o over the button, depending on whose turn it is
object letterHover: EventHandler<MouseEvent>{
    override fun handle(event: MouseEvent?) {
        var t = event?.source as Button
        t.font = Font.font(30.0)
        when(player){
            1 -> {
                t?.text = x.shape
                t?.textFill = javafx.scene.paint.Paint.valueOf(x.color)
            }
            2 -> {
                t.text = o.shape
                t?.textFill = javafx.scene.paint.Paint.valueOf(o.color)
            }
        }

    }
}
//Will show what happens when a button for a position is clicked
object buttonController: EventHandler<ActionEvent> {
    override fun handle(event: ActionEvent){
        var t = event.source as Button
        t.font = Font.font(30.0)
        if(player == 1){
            t.text = x.shape
            t.textFill = javafx.scene.paint.Paint.valueOf(x.color)
            x.Move(t.id, grid)
            player = 2
        }
        else{
            t.text = o.shape
            t.textFill = javafx.scene.paint.Paint.valueOf(o.color)
            o.Move(t.id, grid)
            player = 1
        }
        count++
        t.isDisable = true
        if(Done(grid).check() == true || count == 9){
            t.parent.parent.isDisable = true
            GameOver()
        }
        //When you move the mouse away from the button after you click it, it will not set the button text to blank
        t.onMouseExited = null
    }
}