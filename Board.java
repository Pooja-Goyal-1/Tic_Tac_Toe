public class Board {
    char board[][] = new char[3][3];

    Board() {
        char count = '1';
        for (int i = 0; i < 3; i++) {
            for(int j = 0; j < 3 ;j++){
                board[i][j] = count;
                count++;
            }
        }
    }

    void display() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("|" + " " + board[i][0] + " " + "|" + " " + board[i][1] + " " + "|" + " " + board[i][2]
                    + " " + "|");
            System.out.println("-------------");
        }
    }

    boolean horizontalCheck(char c){
        int i;
        for(i=0;i<3;i++)
        {
            if(board[i][0]==c && board[i][1]==c && board[i][2]==c){
                return true;
            }
        }
        return false;
    }

    boolean verticalCheck(char c){
        int i;
        for(i=0;i<3;i++)
        {
            if(board[0][i]==c && board[1][i]==c && board[2][i]==c){
                return true;
            }
        }
        return false;
    }

    boolean diagonalCheck(char c){
        int i;
        for(i=0;i<3;i++)
        {
            if(board[0][0]==c && board[1][1]==c && board[2][2]==c){
                return true;
            }
            if(board[0][2]==c && board[1][1]==c && board[2][0]==c){
                return true;

            }
        }
        return false;
    }

    boolean winStateCheck(char c){
        return horizontalCheck(c) || verticalCheck(c)|| diagonalCheck(c) ;
    }

    boolean allCellsOccupied(){
        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(board[i][j] != 'X' && board[i][j]!= 'O'){
                    return false;
                }
            }
        }
        return true;
    }
}
