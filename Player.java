import java.util.Scanner;

public class Player {

    String name;
    Scanner sc=new Scanner(System.in);

    Player(String name) {
        this.name = name;
    }

    void makeMove(Board b, int i, char c) {
        while(true){
            char temp;

            if (i < 4) {
                temp=b.board[0][i - 1]; 
            }
            else if (i < 7) {
                temp=b.board[1][i - 4];
            }
            else {
                temp=b.board[2][i - 7];
            }


            if(temp!='X' && temp!='O'){
                temp=c;
                if (i < 4) {
                    b.board[0][i - 1]=c;     
                }
                else if (i < 7) { 
                    b.board[1][i - 4]=c;
                }
                else {
                    b.board[2][i - 7]=c;
                }
                break;
            }
            else{
                System.out.println("Cell already occupied.Enter valid number");
                i=sc.nextInt();
            }
        }
        b.display();
    }
}
