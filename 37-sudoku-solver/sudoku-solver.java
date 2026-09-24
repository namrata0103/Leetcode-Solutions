class Solution {
    public void solveSudoku(char[][] board) {
        helper(board);
    }
    public static boolean helper(char[][] board){
        for(int i=0; i<9; i++){
            for(int j=0; j<9; j++){
                if(board[i][j] == '.'){
                    for(char ch='1'; ch<='9'; ch++){
                        if(isValid(board, i, j, ch)){
                            board[i][j] = ch;
                            if(helper(board) == true){
                                return true;
                            }
                            else{
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isValid(char[][] board, int row, int col, char c){
        for(int i=0; i<9; i++){
            if(board[row][i] == c) return false;
            if(board[i][col] == c) return false;
            if(board[3 * (row/3) + i/3][3 * (col/3) + i%3] == c)return false;
        }
        return true;
    }
}