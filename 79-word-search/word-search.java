class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0; i<board.length; i++){
            for(int j=0; j<board[0].length; j++){
                if(board[i][j] == word.charAt(0)){
                    if(helper(board, word, i, j, 0)){
                        return true;
                    }
                }
            }
        }
        return false;
    }
    public static boolean helper(char[][] board, String word, int row, int col, int ind){
        int n = board.length;
        if(ind == word.length()){
            return true;
        }
        if(row<0 || row >= board.length || col < 0 || col >= board[0].length){
            return false;
        }
        if(board[row][col] != word.charAt(ind)){
            return false;
        }
        char temp = board[row][col];
        board[row][col] = '#';

        if(helper(board, word, row+1, col, ind+1)){
            return true;
        }
        if(helper(board, word, row-1, col, ind+1)){
            return true;
        }
        if(helper(board, word, row, col+1, ind+1)){
            return true;
        }
        if(helper(board, word, row, col-1, ind+1)){
            return true;
        }
        board[row][col] = temp;
        return false;
    }
}