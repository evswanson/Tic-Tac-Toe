# Project2820
TicTacToe

Instructions: To use the Tic-tac-toe game that I created you will need to go to my file named "GUI". The file is located in the src folder->main->kotlin->edu.uiowa->GUI. In the GUI you will have to scroll down to the "fun main" and hit the green arrow next to it. A little screen should appear and give you 2 types of game modes, and an option to leave the game. Click either of the game modes and it will start. I recomend using Intelli J to run the program, because that is what I used to code. Have fun!

Features/Accomplishments: For the startup screen I created 3 buttons that the player can choose. The 2 games and a button that will end the program. One of the games to choose from is the classic game and the other is the ultimate version of Tic-tac-toe, which I called "Super Tic-tac-toe".  For the games I was able to make the buttons show the letter and color of the player whose turn it is when they hover over a button. I was very proud of this because I wanted to make sure that the person whose turn it was would know who they were and where they will be going. For the Super Tic-tac-toe game, I feel very accomplished that I was able to figure out how to color in a board once a player won it.

Obstacles: An obstacle that I faced while creating my game of Super Tic-tac-toe was that I didn't know how to distinguish the boards from each other. I tried creating a Group that would hold all of them while they were being generated in the SuperGame file. This would only result in errors whenever I tried to look at the elements in the Group. I decided that instead of a Group I would create a Mutable list that will add the same board being generated for the Game and add it to the list. This way I could change the color of the boards, and disable the board entirely once won. I was able to associate the list of grids with the list of boards and they would share the same element. Once I figured out how to do this the rest of the coding became easier.
