import java.util.Scanner;

public class Tic_Tac_Toe {
    public static void main(String args[])
    {
        //input board
        char[][] board=new char[3][3];
        //initially board is empty
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[row].length;col++)
            {
                board[row][col]=' ';
            }
        }

        //input player (initialise to X)
        char player = 'X';
        //initialy board empty , so game will not be over
        boolean gameOver=false;

        Scanner sc=new Scanner(System.in);

        //game starts
        while(!gameOver)
        {
            //print empty board
            System.out.println();
            System.out.println("-------INITIAL BOARD IS-------");
            System.out.println();
            printBoard(board);
            //take input from player
            System.out.println("\t--- TURN: PLAYER "+player+" ---");
            System.out.println();
            System.out.print("\t Player "+player+" enters : ");
            int row = sc.nextInt();
            int col = sc.nextInt();
            System.out.println();

            //checks whether inputted cell is occupied or not
            if(board[row][col]==' ')
            {
                //place the symbol
                board[row][col]=player;
                gameOver=haveWon(board,player);   //if player wins, give results
                if(gameOver)
                {
                    System.out.println();
                    System.out.println("------ Player "+player+"has won! --------");
                    System.out.println();
                }
                                  //swaps the player
                else if(isBoardFull(board))
                {
                     System.out.println();
                     System.out.println("Board full, Game over!");
                     System.out.println();
                     break;
                }
                else
                {
                   player=(player=='X')? 'O':'X';
                }
            }
            else
            {
                System.out.println();
                System.out.println("Invalid move..Try again!!");
                System.out.println();
            }
        }
        System.out.println("-------FINAL BOARD IS-------");
        System.out.println();
        printBoard(board);
    }

    public static void  printBoard(char[][] board)
    {
        System.out.println("-----------------------------------------");
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board.length;col++)
            {
                System.out.print("\t"+board[row][col]+" | ");
            }
            System.out.println();
        }
        System.out.println("-----------------------------------------");
    }

    public static boolean haveWon(char[][] board,char player)
    {
        //for rows straight line
        
        for(int row=0;row<board.length;row++)
        {
            if(board[row][0]==player && board[row][1]==player && board[row][2]==player)
            {
            return true;
            }
        }
        //for cols straight line
        for(int col=0;col<board[0].length;col++)
        {
            if(board[0][col]==player && board[1][col]==player && board[2][col]==player)
            {
                return true;
            }
        }
        if(board[0][0]==player && board[1][1]==player && board[2][2]==player)
        {
            return true;
        }
            if(board[0][2]==player && board[1][1]==player && board[2][0]==player)
            {
                return true;
            }
        return false;
    }

    public static boolean isBoardFull(char[][] board)
    {
        for(int row=0;row<board.length;row++)
        {
            for(int col=0;col<board[row].length;col++)
            {
                if(board[row][col]==' ')
                {
                    return false;
                }
            }
        }
        return true;
    }
}
