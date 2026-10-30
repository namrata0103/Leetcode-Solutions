class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        ArrayList<ArrayList<Pair>> adj = new ArrayList<>();
        for(int i=0; i<n; i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0; i<edges.length; i++){
            adj.get(edges[i][0]).add(new Pair(edges[i][1], edges[i][2]));
        }
        PriorityQueue<Tuple> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.first, b.first));
        int[][] dist = new int[n][k+1];
        for(int i=0; i<n; i++){
            Arrays.fill(dist[i], (int)1e9);
        }
        dist[0][1] = 0;
        pq.add(new Tuple(0, 0, labels.charAt(0), 1));
        while(!pq.isEmpty()){
            int dis = pq.peek().first;
            int node = pq.peek().second;
            char ch = pq.peek().third;
            int cons = pq.peek().forth;
            pq.remove();
            if(node == n-1) return dis;
            for(Pair it: adj.get(node)){
                int adjNode = it.first;
                int adjW = it.second;
                char newCh = labels.charAt(adjNode);
                int newCons;
                if(ch == newCh){
                    newCons = cons + 1;
                }
                else{
                    newCons = 1;
                }
                if(newCons > k) continue;
                int newDis = dis + adjW;
                if(newDis < dist[adjNode][newCons]){
                    dist[adjNode][newCons] = newDis;
                    pq.add(new Tuple(newDis, adjNode, newCh, newCons));
                }
            }
        }
        return -1;
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
class Tuple{
    int first;
    int second;
    char third;
    int forth;
    public Tuple(int first, int second, char third, int forth){
        this.first = first;
        this.second = second;
        this.third = third;
        this.forth = forth;
    }
}