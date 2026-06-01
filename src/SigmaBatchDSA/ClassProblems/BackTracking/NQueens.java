package SigmaBatchDSA.ClassProblems.BackTracking;

class NQueens {
    public static boolean isSafe(char board[][], int row, int col) {
        // Check vertically up
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 'Q') {
                return false;
            }
        }

        // Check diagonal left-up
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        // Check diagonal right-up
        for (int i = row - 1, j = col + 1; i >= 0 && j < board.length; i--, j++) {
            if (board[i][j] == 'Q') {
                return false;
            }
        }

        return true; // Position is safe
    }

    public static void nQueens(char board[][], int row) {
        // Base case: all rows processed
        if (row == board.length) {
            printBoard(board);
            return;
        }

        // Try placing a queen in every column
        for (int j = 0; j < board.length; j++) {
            if (isSafe(board, row, j)) {
                board[row][j] = 'Q'; // Place queen
                nQueens(board, row + 1); // Recur
                board[row][j] = 'X'; // Backtrack
            }
        }
    }

    public static void printBoard(char board[][]) {
        System.out.println("--------- Chess Board ---------");
        for (char[] row : board) {
            for (char cell : row) {
                System.out.print(cell + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int n = 4; // Minimum viable board size
        char board[][] = new char[n][n];

        // Initialize board with 'X'
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = 'X';
            }
        }

        nQueens(board, 0);
    }
}
