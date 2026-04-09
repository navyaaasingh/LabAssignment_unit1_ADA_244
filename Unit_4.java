public class Unit_4 {

    static final int N = 4;

    static void printBoard(int[][] board) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                System.out.print(board[i][j] + " ");
            }
            System.out.println();
        }
    }

    static boolean isValid(int[][] board, int row, int col) {

        // check left row
        for (int i = 0; i < col; i++) {
            if (board[row][i] == 1)
                return false;
        }

        // upper diagonal
        int i = row, j = col;
        while (i >= 0 && j >= 0) {
            if (board[i][j] == 1)
                return false;
            i--;
            j--;
        }

        // lower diagonal
        i = row;
        j = col;
        while (i < N && j >= 0) {
            if (board[i][j] == 1)
                return false;
            i++;
            j--;
        }

        return true;
    }

    static boolean solveNQueen(int[][] board, int col) {
        if (col >= N)
            return true;

        for (int i = 0; i < N; i++) {
            if (isValid(board, i, col)) {
                board[i][col] = 1;

                if (solveNQueen(board, col + 1))
                    return true;

                board[i][col] = 0; // backtrack
            }
        }
        return false;
    }

    static boolean checkSolution() {
        int[][] board = new int[N][N];

        if (!solveNQueen(board, 0)) {
            System.out.println("Solution does not exist");
            return false;
        }

        printBoard(board);
        return true;
    }

    public static void main(String[] args) {
        checkSolution();
    }
}

