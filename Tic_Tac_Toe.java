import java.util.Scanner;

public class Tic_Tac_Toe {

    public static void main(String[] args) {
        char[][] board = new char[3][3];
        initializeBoard(board);

        char player = 'X';
        boolean gameOver = false;
        Scanner sc = new Scanner(System.in);

        System.out.println("\n\t----- WELCOME TO TIC TAC TOE -----\n");
        System.out.println("Players: X and O");
        System.out.println("Enter slot number (1 to 9) to make a move as shown below:\n");
        printSlotBoard();

        while (!gameOver) {
            System.out.println("\nCurrent Board:");
            printBoard(board);

            System.out.print("\nPlayer " + player + ", enter your move (1-9): ");
            int slot = sc.nextInt();

            if (slot < 1 || slot > 9) {
                System.out.println("Invalid slot! Choose between 1 to 9.");
                continue;
            }

            int row = (slot - 1) / 3;
            int col = (slot - 1) % 3;

            if (board[row][col] == ' ') {
                board[row][col] = player;
                if (haveWon(board, player)) {
                    System.out.println("\nFinal Board:");
                    printBoard(board);
                    System.out.println("\n Player " + player + " wins! 🎉\n");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    System.out.println("\nFinal Board:");
                    printBoard(board);
                    System.out.println("\n It's a draw! Board is full.\n");
                    break;
                } else {
                    player = (player == 'X') ? 'O' : 'X'; // Switch turns
                }
            } else {
                System.out.println("Slot already taken. Try again!");
            }
        }

        System.out.println("Thanks for playing!");
    }

    // Initializes the board with empty spaces
    public static void initializeBoard(char[][] board) {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                board[row][col] = ' ';
    }

    // Prints the board with current game state
    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int row = 0; row < board.length; row++) {
            System.out.print("|");
            for (int col = 0; col < board[row].length; col++) {
                System.out.print(" " + board[row][col] + " |");
            }
            System.out.println("\n-------------");
        }
    }

    // Prints the initial board showing slot numbers (1–9)
    public static void printSlotBoard() {
        int slot = 1;
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("|");
            for (int j = 0; j < 3; j++) {
                System.out.printf(" %d |", slot++);
            }
            System.out.println("\n-------------");
        }
    }

    // Checks if the given player has won
    public static boolean haveWon(char[][] board, char player) {
        // Rows and Columns
        for (int i = 0; i < 3; i++) {
            if ((board[i][0] == player && board[i][1] == player && board[i][2] == player) || 
                (board[0][i] == player && board[1][i] == player && board[2][i] == player)) {
                return true;
            }
        }
        // Diagonals
        if ((board[0][0] == player && board[1][1] == player && board[2][2] == player) || 
            (board[0][2] == player && board[1][1] == player && board[2][0] == player)) {
            return true;
        }
        return false;
    }

    // Checks if the board is full
    public static boolean isBoardFull(char[][] board) {
        for (int row = 0; row < board.length; row++)
            for (int col = 0; col < board[row].length; col++)
                if (board[row][col] == ' ')
                    return false;
        return true;
    }
}
