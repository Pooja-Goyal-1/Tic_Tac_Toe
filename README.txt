TIC-TAC-TOE GAME

This is the famous Tic Tac Toe game written in JAVA using Object Oriented Programming (OOPs) Concepts.

By: Pooja Goyal
Entry Number: 2020CSB1108

Project Description:

There are two versions of the game.

    1. Two Player Version (Human Vs Human)

        a. The game continues until one player has scored three in a row or column or all squares have been filled with no winner.
        b. The players can play in only those squares that are not already occupied by either player.
        c. The program ends when the game is won by either player or the game is a draw.
        d. The first player is X and second player is O.

    2. Human Vs Computer

        a. The player always moves first and is X. The computer is O.
        b. The game continues until one player has scored three in a row or column or all squares have been filled with no winner.
        c. The players can play in only those squares that are not already occupied by either player.
        d. The program ends when the game is won by either player or the game is a draw.

        How does the Computer Play?

        1. The computer looks one step ahead in time.
        2. For example, 
            a. When it's computer's turn, it checks if it can win by making any move.
            b. If yes, it takes the move which ensures win.
            c. Otherwise, it ensures that if it can prevent the opposite's win in next move.
            d. If the opposite can't win in any case in next move, computer checks if any row, col or diagonal can become a winning state in future and moves accordingly.
            e. If computer is unable to detect a future winning state, it chooses the first non empty cell.


Important points on how to paly the game:

1. When you run the program, you'll see some instructions on your screen. Just follow the instructions.
2. The board is 3*3 as shown below.

-------------
| 1 | 2 | 3 |
-------------
| 4 | 5 | 6 |
-------------
| 7 | 8 | 9 |
-------------

3. The numbers from 1 to 9 written on the board are CellNumbers. Cells are choosen with the help of Cell Numbers.
4. For example, You are X and you chhose the Cell number 5. The board now will be displayed as follows.

-------------
| 1 | 2 | 3 |
-------------
| 4 | X | 6 |
-------------
| 7 | 8 | 9 |
-------------

5. Note that no player can chhose the cell number 5 again.
6. The program ends when there is a win or draw.
