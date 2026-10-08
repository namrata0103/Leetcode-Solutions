class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int n = image.length;
        int m = image[0].length;
        boolean[][] vis = new boolean[n][m];
        int start = image[sr][sc];
        if(vis[sr][sc] == false && image[sr][sc] != color){
            bfs(image, vis, sr, sc, n, m, color, start);
        }
        return image;
    }
    public void bfs(int[][] image, boolean[][] vis, int sr, int sc, int n, int m, int color, int start){
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        vis[sr][sc] = true;
        image[sr][sc] = color;
        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            int[] dr = {-1, 1, 0, 0};
            int[] dc = {0, 0, -1, 1};
            for(int k=0; k<4; k++){
                int nr = row + dr[k];
                int nc = col + dc[k];
                if(nr >= 0 && nr < n && nc >= 0 && nc < m && vis[nr][nc] == false && image[nr][nc] == start){
                    image[nr][nc] = color;
                    q.add(new Pair(nr, nc));
                    vis[nr][nc] = true;
                }
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