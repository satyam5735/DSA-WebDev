package SigmaBatchDSA.ClassProblems.BackTracking;

class NQueensOneSolution {
    // Method to check if placing a queen at (row, col) is safe
    public static boolean isSafe(char[][] board, int row, int col) {
        int n = board.length;

        // Check vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') return false;
        }

        // Check diagonal left-up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') return false;
        }

        // Check diagonal right-up
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 'Q') return false;
        }

        return true; // Safe position
    }

    // Method to find one valid N-Queens solution
    public static boolean nQueens(char[][] board, int row) {
        int n = board.length;

        // Base case: all rows processed
        if (row == n) return true;

        // Try placing a queen in each column
        for (int j = 0; j < n; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place queen

                // Recur to place queens in the next row
                if (nQueens(board, row + 1)) return true;

                board[row][j] = 'X'; // Backtrack
            }
        }
        return false;
    }

    // Print the chess board
    public static void printBoard(char[][] board) {
        System.out.println("--------- Chess Board ---------");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4; // Board size
        char[][] board = new char[n][n];

        // Initialize board with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        if (nQueens(board, 0)) {
            System.out.println("Solution is possible:");
            printBoard(board);
        } else {
            System.out.println("Solution is not possible.");
        }
    }
}