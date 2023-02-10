package datastructure;

public class SudokuSolver {
    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][]board = {{'5','3','.','.','7','.','.','.','.'},
                {'6','.','.','1','9','5','.','.','.'},
                {'.','9','8','.','.','.','.','6','.'},
                {'8','.','.','.','6','.','.','.','3'},
                {'4','.','.','8','.','3','.','.','1'},
                {'7','.','.','.','2','.','.','.','6'},
                {'.','6','.','.','.','.','2','8','.'},
                {'.','.','.','4','1','9','.','.','5'},
                {'.','.','.','.','8','.','.','7','9'}};
        char[][] expectedOutput = {{'5','3','4','6','7','8','9','1','2'},{'6','7','2','1','9','5','3','4','8'},{'1','9','8','3','4','2','5','6','7'},{'8','5','9','7','6','1','4','2','3'},{'4','2','6','8','5','3','7','9','1'},{'7','1','3','9','2','4','8','5','6'},{'9','6','1','5','3','7','2','8','4'},{'2','8','7','4','1','9','6','3','5'},{'3','4','5','2','8','6','1','7','9'}};
        char[][]output = sudokuSolver.solveSudoku(board);
        for(int i = 0; i<output.length;i++){

            for(int j = 0; j< output[0].length;j++){
                System.out.print(output[i][j]);
                System.out.print(",");
            }
            System.out.println(",");
        }
    }
    public char[][] solveSudoku(char[][] board) {
        helper(board, 0, 0);
        return board;
    }
    public boolean helper(char[][] board, int row, int col){
        if(row == board.length) return true;
        int nrow = 0; int ncol = 0;
        if(col != board.length-1){
            nrow = row;
            ncol = col+1;
        }else{
            nrow = row+1;
            ncol = 0;
        }
        if(board[row][col] != '.'){
            if(helper(board,nrow, ncol)){
                return true;
            }
        }else{
            for(int i = 1; i <=9; i++){
                if(isSafe(board,row, col,i)){
                    board[row][col] = (char)(i+'0');
                    if(helper(board,nrow,ncol)){
                        return true;
                    }else{
                        board[row][col] = '.';
                    }
                }
            }
        }
        return false;
    }
    public boolean isSafe(char[][]board , int row, int col, int number){
        for(int i = 0; i< board.length; i++){
            if(board[i][col] == (char)(number+'0')) return false;
            if(board[row][i] == (char)(number+'0')) return false;
            if(board[(row/3)*3 + i/3][(col/3)*3 + i%3] ==(char)(number+'0')) return false;
        }
        return true;
    }
}
