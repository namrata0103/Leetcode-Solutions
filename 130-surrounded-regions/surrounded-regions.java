class Solution {
    public void solve(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        Queue<Pair> q = new LinkedList<>();
        boolean[][] vis = new boolean[n][m];
        char[][] ans = new char[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(ans[i], 'X');
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(i == 0 || j == 0 || i == n-1 || j == m-1){
                    if(board[i][j] == 'O'){
                        q.add(new Pair(i, j));
                        vis[i][j] = true;
                        ans[i][j] = 'O';
                    }
                }
            }
        }
        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            ans[row][col] = 'O';
            for(int k=0; k<4; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false && board[nr][nc] == 'O'){
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
            }
        }
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                board[i][j] = ans[i][j];
            }
        }
    }
}
class Pair{
    int first;
    int second;
    public Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}