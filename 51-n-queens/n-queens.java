class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        char[][] board = new char[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                board[i][j] = '.';
            }
        }
        helper(n, ans, board, 0);
        return ans;
    }
    public static void helper(int n, List<List<String>> ans, char[][] board, int col){
        if(col == n){
            List<String> res = new ArrayList<>();
            for(int i=0; i<n; i++){
                res.add(new String(board[i]));
            }
            ans.add(res);
            return;
        }
        for(int row=0; row<n; row++){
            if(isSafe(n, board, row, col)){
                board[row][col] = 'Q';
                helper(n, ans, board, col+1);
                board[row][col] = '.';
            }
        }
    }
    public static boolean isSafe(int n, char[][] board, int row, int col){
        for(int j=0; j<col; j++){
            if(board[row][j] == 'Q'){
                return false;
            }
        }
        int i = row - 1;
        int j = col - 1;
        while(i >= 0 && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i--;
            j--;
        }
        i = row + 1;
        j = col - 1;
        while(i < n && j >= 0){
            if(board[i][j] == 'Q'){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}