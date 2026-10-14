class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        List<Integer> ans = new ArrayList<>();
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for(int i=0; i<graph.length; i++){
            revAdj.add(new ArrayList<>());
        }
        int[] indegree = new int[graph.length];
        for(int i=0; i<graph.length; i++){
            for(int it: graph[i]){
                revAdj.get(it).add(i);
                indegree[i]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        for(int i=0; i<indegree.length; i++){
            if(indegree[i] == 0){
                q.add(i);
            }
        }
        while(!q.isEmpty()){
            int node = q.remove();
            ans.add(node);
            for(int it: revAdj.get(node)){
                indegree[it]--;
                if(indegree[it] == 0){
                    q.add(it);
                }
            }
        }
        Collections.sort(ans);
        return ans;
    }
}