import java.util.Scanner;

public class NQueens_Backtracking {
    static int N;
    static int[][] board;

    // Check if placing a Queen at board[row][col] is safe
    static boolean isSafe(int row, int col) {
        int i, j;

        // Check column above
        for (i = 0; i < row; i++)
            if (board[i][col] == 1)
                return false;

        // Check upper left diagonal
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper right diagonal
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    // Backtracking function to place queens
    static boolean solveNQueen(int row) {
        // If all queens are placed
        if (row == N)
            return true;

        // If current row already has a queen (from user input), skip it
        for (int col = 0; col < N; col++) {
            if (board[row][col] == 1) {
                // Skip to next row
                if (solveNQueen(row + 1))
                    return true;
                else
                    return false;
            }
        }

        // Try placing a queen in each column
        for (int col = 0; col < N; col++) {
            if (isSafe(row, col)) {
                board[row][col] = 1;

                if (solveNQueen(row + 1))
                    return true;

                board[row][col] = 0; // Backtrack
            }
        }
        return false;
    }

    // Display final N-Queens matrix
    static void printBoard() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of Queens (N): ");
        N = sc.nextInt();
        board = new int[N][N];

        System.out.print("Enter row (1 to " + N + ") for first Queen: ");
        int r = sc.nextInt() - 1;
        System.out.print("Enter column (1 to " + N + ") for first Queen: ");
        int c = sc.nextInt() - 1;

        // Place the first Queen
        board[r][c] = 1;

        // Start solving from first row
        if (solveNQueen(0))
            System.out.println("\nFinal N-Queens Board (1 = Queen, 0 = Empty):");
        else
            System.out.println("\nNo solution exists for this configuration.");

        printBoard();
        sc.close();
    }
}
