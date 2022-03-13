import java.util.Scanner;

class TicTacToe{

    // Human Vs Human Game 
    private static void humanVsHuman(){

        Board board = new Board();

        try (Scanner s = new Scanner(System.in)) {
            char c = 'X',d='O';
            int cellNumber;

            System.out.println("Welcome to the TicTacToe Game : Human Vs Human");
            board.display();

            System.out.println("Enter player1 name");
            Player player1 = new Player(s.next());

            System.out.println("Enter player2 name");
            Player player2=new Player(s.next());

            System.out.println("........The game begins.........");

            while(true){
                
                // Player 1 turn
                if(board.allCellsOccupied()){
                    System.out.println("Draw Occurs");
                    System.out.println("...........Game Over.........");
                    break;
                }
                
                System.out.println(player1.name + "'s turn. You have X.");
                System.out.println("Enter the cell number from 1 to 9 which is not occupied by X or O");
                cellNumber=s.nextInt();
                player1.makeMove(board, cellNumber, c);
                if(board.winStateCheck(c)){
                    System.out.println("Congratulations!!!!! "+ player1.name+" wins");
                    break;
                }

                // Player 2 turn
                if(board.allCellsOccupied()){
                    System.out.println("Draw Occurs");
                    System.out.println("...........Game Over.........");
                    break;
                }

                System.out.println(player2.name+"'s turn. You have O.");
                System.out.println("Enter the cell number from 1 to 9 which is not occupied by X or O");
                cellNumber=s.nextInt();
                player2.makeMove(board, cellNumber, d);

                if(board.winStateCheck(d)){
                    System.out.println("Congratulations!!!!! " + player2.name+" wins");
                    break;

                }
            }
            s.close();
        }
    }

    // Computer Vs Human Game
    private static void computerVsHuman(){

        Board board = new Board();
        try (Scanner s = new Scanner(System.in)) {
            char c = 'X' ,d = 'O';
            int cellNumber;

            System.out.println("Welcome to the TicTacToe Game : Human Vs Computer");
            board.display();

            System.out.println("Enter your name.");
            Player player = new Player(s.next());
            Computer computer = new Computer();
            System.out.println("........The game begins.........");

            while(true){
                
                // Player's turn
                if(board.allCellsOccupied()){
                    System.out.println("Draw Occurs");
                    System.out.println("...........Game Over.........");
                    return;
                }

                System.out.println("Your's turn. You have X.");
                System.out.println("Enter the cell number from 1 to 9 which is not occupied by X or O");
                cellNumber=s.nextInt();
                player.makeMove(board, cellNumber, c);
                if(board.winStateCheck(c)){
                    System.out.println("Congratulations!!!!! "+ player.name+" You wins");
                    break;
                }

                // Computer's Turn
                cellNumber = computer.findOptimalCell(board);
                if(cellNumber == 0){
                    System.out.println("Draw Occurs");
                    System.out.println("...........Game Over.........");
                    return;
                }
                System.out.println("Computer's turn");
                System.out.println("Computer picked cell " + cellNumber);
                computer.makeMove(board, cellNumber);

                if(board.winStateCheck(d)){
                    System.out.println("Oops!!! You lost. Better luck next time.");
                    break;

                }
            }
            s.close();
        }
    }
    public static <string> void main(String args[]){
        
        System.out.println("Welcome to Tic Tac Toe Game.");
        System.out.println("----------------------------");
        System.out.println("How would you like to play?");
        System.out.println("1. 2 Player Game");
        System.out.println("2. Human Vs Computer");
        System.out.println("----------------------------");
        System.out.println("Enter 1 to play 2-player version and 2 to play against computer");

        Scanner scanner = new Scanner(System.in);

        boolean playGame = true;

        while(playGame){
            int gameVersion = scanner.nextInt();
            if(gameVersion==1){
                humanVsHuman();
                playGame = false;
            }
            else if(gameVersion==2){
                computerVsHuman();
                playGame = false;
            }
            else{
                System.out.println("Please enter 1 or 2 only");
            }  
        } 
        scanner.close();
    }
}