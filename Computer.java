public class Computer {

    String name = "Computer" ;
    
    Computer(){
        this.name = "Computer" ;
    }

    int horizontalMatchPossible(Board b , char c){
        for(int i =0;i<3;i++){
            if(b.board[i][0] == c && b.board[i][1] == c && (b.board[i][2]!='X' && b.board[i][2]!='O')){
                return (i+1)*3;
            }
            else if(b.board[i][1] == c && b.board[i][2] == c && (b.board[i][0]!='X' && b.board[i][0]!='O')){
                return 3*i + 1;
            }
            else if(b.board[i][0] == c && b.board[i][2] == c && (b.board[i][1]!='X' && b.board[i][1]!='O')){
                return 3*i + 2;
            }
        }
        return 0;
    }

    int verticalMatchPossible(Board b , char c){
        for(int j =0;j<3;j++){
            if(b.board[0][j] == c && b.board[1][j] == c && (b.board[2][j]!='X' && b.board[2][j]!='O')){
                return 7+j;
            }
            else if(b.board[1][j] == c && b.board[2][j] == c && (b.board[0][j]!='X' && b.board[0][j]!='O')){
                return 1+j;
            }
            else if(b.board[0][j] == c && b.board[2][j] == c && (b.board[1][j]!='X' && b.board[1][j]!='O')){
                return 4+j;
            }
        }
        return 0;
    }

    int primaryDiagonalMatchPossible(Board b , char c){
        if(b.board[0][0] == c && b.board[1][1] == c && (b.board[2][2]!='X' && b.board[2][2]!='O')){
            return 9;
        }
        else if(b.board[0][0] == c && b.board[2][2] == c && (b.board[1][1]!='X' && b.board[1][1]!='O')){
            return 5;
        }
        else if(b.board[1][1] == c && b.board[2][2] == c && (b.board[0][0]!='X' && b.board[0][0]!='O')){
            return 1;
        }
        return 0;
    }

    int secondaryDiagonalMatchPossible(Board b , char c){
        if(b.board[0][2] == c && b.board[1][1] == c && (b.board[2][0]!='X' && b.board[2][0]!='O')){
            return 7;
        }
        else if(b.board[1][1] == c && b.board[2][0] == c && (b.board[0][2]!='X' && b.board[0][2]!='O')){
            return 3;
        }
        else if(b.board[0][2] == c && b.board[2][0] == c && (b.board[1][1]!='X' && b.board[1][1]!='O')){
            return 5;
        }
        return 0;
    }

    // checking if this row can create a winning state in future.
    boolean goodRow(Board b, int row){
        int countEmptyCells = 0;
        int countO = 0;
        for(int c =0;c<3;c++){
            if(b.board[row][c]=='O'){
                countO++;
            }
            else if(b.board[row][c]!='O' && b.board[row][c]!='X'){
                countEmptyCells++;
            }
        }
        if((countO==1 && countEmptyCells==2) || countEmptyCells == 3 ){
            return true;
        }
        return false;
    }

    // checking if this col can create a winning state in future.
    boolean goodCol(Board b, int col){
        int countEmptyCells = 0;
        int countO = 0;
        for(int r =0;r<3;r++){
            if(b.board[r][col]=='O'){
                countO++;
            }
            else if(b.board[r][col]!='O' && b.board[r][col]!='X'){
                countEmptyCells++;
            }
        }
        if( (countO==1 && countEmptyCells==2) || countEmptyCells == 3){
            return true;
        }
        return false;
    }

    // checking if this diagonal can create a winning state in future.
    boolean goodPrimaryDiagonal(Board b, int row, int col){
        int countEmptyCells = 0;
        int countO = 0;
        for(int r =0;r<3;r++){
            for(int c =0;c<3;c++){
                if(r==c){
                    if(b.board[r][c]=='O'){
                        countO++;
                    }
                    else if(b.board[r][c]!='O' && b.board[r][c]!='X'){
                        countEmptyCells++;
                    }
                }
            }
        }
        if((countO==1 && countEmptyCells==2) || countEmptyCells == 3){
            return true;
        }
        return false;
    }

    // checking if this diagonal can create a winning state in future.
    boolean goodSecondaryDiagonal(Board b, int row, int col){
        int countEmptyCells = 0;
        int countO = 0;
        for(int r =0;r<3;r++){
            for(int c =0;c<3;c++){
                if(r+c==2){
                    if(b.board[r][c]=='O'){
                        countO++;
                    }
                    else if(b.board[r][c]!='O' && b.board[r][c]!='X'){
                        countEmptyCells++;
                    }
                }
            }
        }
        if( (countO==1 && countEmptyCells==2) || countEmptyCells == 3){
            return true;
        }
        return false;
    }

    boolean goodMove(Board b, int row, int col){
        return goodCol(b, col) || goodRow(b, row) || goodPrimaryDiagonal(b, row, col) || goodSecondaryDiagonal(b, row, col);
    }

    int findOptimalCell(Board b){

        // check if computer can win in this move
        int cellNumber = horizontalMatchPossible(b, 'O');
        if(cellNumber!=0){
            return cellNumber;
        }
        cellNumber = verticalMatchPossible(b, 'O');
        if(cellNumber!=0){
            return cellNumber;
        }
        cellNumber = primaryDiagonalMatchPossible(b, 'O');
        if(cellNumber!=0){
            return cellNumber;
        }
        cellNumber = secondaryDiagonalMatchPossible(b, 'O');
        if(cellNumber!=0){
            return cellNumber;
        }

        // check if computer can prevent player win in next move;
        cellNumber = horizontalMatchPossible(b, 'X');
        if(cellNumber!=0){
            return cellNumber;
        }
        cellNumber = verticalMatchPossible(b, 'X');
        if(cellNumber!=0){
            return cellNumber;
        }
        cellNumber = primaryDiagonalMatchPossible(b, 'X');
        if(cellNumber!=0){
            return cellNumber;
        }
        cellNumber = secondaryDiagonalMatchPossible(b, 'X');
        if(cellNumber!=0){
            return cellNumber;
        }

        // check if winning state can be created with this cell in future.
        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(b.board[i][j]!='O' && b.board[i][j]!='X' && goodMove(b, i, j)){
                    return 3*i + 1+ j;
                }
            }
        }

        for(int i =0;i<3;i++){
            for(int j = 0;j<3;j++){
                if(b.board[i][j]!='O' && b.board[i][j]!='X'){
                    return 3*i + 1+ j;
                }
            }
        }
        return 0;
    }

    void makeMove(Board b , int i) {
        if (i < 4) {
            b.board[0][i - 1]='O';     
        }
        else if (i < 7) { 
            b.board[1][i - 4]='O';
        }
        else {
            b.board[2][i - 7]='O';
        }
        b.display();
    }
}
