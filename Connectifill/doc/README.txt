Connectifill
Authors: Srikar Gudipati and Rushil Jayant
Revision: 5/24/21


Introduction: 
Connectifill, a game that involves strategy, technique, and skill, and can be mastered by the smartest minds. This is a game where players face off against an intelligent computer, to get the most four-in-a-row pieces on the board.


This program is a fun pastime that helps one relax and learn about how different computer models behave. A computer is a machine that performs many logical computations, whereas a human uses strategy to win. This game is a place where AI enthusiasts can see which models work best, and guess the computer’s reasoning behind them.


Our inspiration came from the simple board game, Connect 4, where one stacks up pieces until they get 4 in a row. As children, we played this game in order to deepen our minds’ understanding of logic and strategy, and to have a fun pastime with our friends. 


Our game, Connectifill, takes inspiration from the Connect 4 game, with many differences. Primarily, the human player will face off against many different computer “models”, who play the game with their own unique strategy. The goal of our game is for the computer or the human player to get as many connect-4s as possible. 


The interface of the game is similar to Connect-4, but the board is significantly bigger at 24x12 dimensions, and you can play until the board is completely full. There are many different modes to the game, but primarily, humans will face off against a bot of their choice.


Instructions:


1. The player will select a bot from the list of bots to play with (see features list)
2. Then the player will then see a 24x12 grid, where they can start playing by clicking on any column that is not completely filled
3. Once a valid column is selected, a checkered red piece will appear
4. Now a computer will use the desired model to strategize and figure out what move it should be making.
5. Steps 3 and 4 will repeat until the entire board will be filled
   1. Scores will be based on how many connect 4s there are on the board
   2. The intention of the player is to maximize the number of connect 4s they have and minimize the number of connect 4s their opponent has (if there are the same number of points it is best to end with a tie)


Features List:
Must-have Features:
* Game Board
   * Has 24x12 grid that looks like the Connect-4 Grid
   * The User and the Computer Bot are able to put in their own pieces without glitches
* Score Board
   * Below the game board
   * Keeps tally of the number of connect-4s on the game board (every combination of 4 seen)
   * One side of the scoreboard will be for the computer and the other side will be for the player
* Random Computer Player Model
   * A model that puts pieces randomly around the board
   * Will act as an “easy” mode for players
* Computer Bot Options Menu
   * Users will have the chance to pick between different models, which may be very simple (like Random), or moderate to play with
   * No bots will have a chance of always beating the opponent in the game every time
* Board Class
   * A class that represents what a board is and does so future models function properly


Want-to-have Features:
* Info Menu
   * Button on a corner of the board that will tell the instructions of the game
   * Once clicked a pop will emerge with the README in plain text format
* Aggressive Model
   * Model that always tries to get as much connect-4s possible
   * Getting the most connect-4 is its priority, but if the opponent has 3 pieces in a row it will start blocking it 
*  Defensive Model
   * Model that always tries to block all connect-4s the human player tries to do
   * Eventually it will get a connect-4 of its own, but not its priority
   * If the human player places one piece, this model will try to block it ASAP
* MiniMax Model
   * Looks at all possible moves and picks one that is best
   * Sort of like a combination of the aggressive and defensive model
   * Will forcease how the board will look like once the piece has been put
* Combined Model
   * Combines the Benefits of both Aggressive and Defensive Models


Stretch Features:
* Generative Models
   * A model that learns from previous plays and trains on it to become better
   * Similar to the Google’s Unbeatable Chess Game Bot
   * This can use the Random player or another model to train and get better
* Multiplayer Game between Humans Online
   * You can play with any other person with the app installed online
   * Uses APIs and Data Transfer Technology to transmit data live
* Login System
   * You can login from any computer and play within your account from anywhere in the world where the app is installed




Class List:
* Graphics
   * Board
   * Game
* Models
   * Model (Superclass)
      * RandomModel
      * AggressiveModel
      * DefensiveModel
      * MiniMaxModel
      * CombinedModel


Credits:
<<<<<<< Updated upstream
* Rushil Jayant: Worked on README, and Game class for GUI, finished models and menu
* Srikar Gudipati: Worked on README, and Game class for placement of tokens and random generation, worked on models and menu
=======
<<<<<<< HEAD
* Rushil Jayant
   * Worked on README
   * Created Models
   * Reformatted Java Classes
   * Created the Intro section of the README
   * Finished the Board Class
* Srikar Gudipati
   * Created the idea for Connectifill
   * Worked on README
   * Completed Javadocs
   * Edited UML Diagram Regularly
   * Prepared files for export in each build
   * Created the Board Design and GUI Functionality
   * Restructured Files
   * Finished the Game Class
=======
* Rushil Jayant: Worked on README, and Game class for GUI, finished models and menu
* Srikar Gudipati: Worked on README, and Game class for placement of tokens and random generation, worked on models and menu
>>>>>>> 1df04a5c224535b0bf0a0147c262173764a00210
>>>>>>> Stashed changes
* Mr. Shelby: Helping us formulate our ideas
* Processing: Will serve as our GUI library to design items
* Original Connect-4 Game
* GUI Ideas: https://youtu.be/CbKJqeOxQQ4
* Shaashwath Sivakumar (Former APCS Student): For helping us solve our MiniMax Model