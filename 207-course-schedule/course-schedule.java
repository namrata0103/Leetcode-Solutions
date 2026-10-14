class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] vis = new int[numCourses];
        int[] pathVis = new int[numCourses];
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for(int i=0; i<numCourses; i++){
            adj.add(new ArrayList<>());
        }
        for (int[] p : prerequisites) {
            adj.get(p[1]).add(p[0]);
        }
        for(int i=0; i<numCourses; i++){
            if(vis[i] == 0){
                if(dfs(i, numCourses, prerequisites, vis, pathVis, adj) == true){
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean dfs(int i, int numCourses, int[][] prerequisites, int[] vis, int[] pathVis, ArrayList<ArrayList<Integer>> adj){
        vis[i] = 1;
        pathVis[i] = 1;
        for(int it: adj.get(i)){
            if(vis[it] == 0){
                if(dfs(it, numCourses, prerequisites, vis, pathVis, adj)){
                    return true;
                }
            }
            else if(pathVis[it] == 1){
                return true;
            }
        }
        pathVis[i] = 0;
        return false;
    }
}