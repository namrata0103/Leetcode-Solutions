class Solution {
    public int makeConnected(int n, int[][] connections) {
        if(connections.length < n-1) return -1;
        DisjointSet ds = new DisjointSet(n);
        int cnt = 0;
        for(int i=0; i<connections.length; i++){
            int u = connections[i][0];
            int v = connections[i][1];
            if(ds.findUPar(u) == ds.findUPar(v)) cnt++;
            else{
                ds.unionBySize(u, v);
            }
        }
        if(cnt >= ds.components-1) return ds.components - 1;
        return -1;
    }
}
class DisjointSet{
    List<Integer> parent;
    List<Integer> size;
    int components;

    DisjointSet(int n){
        parent = new ArrayList<>();
        size = new ArrayList<>();
        components = n;

        for(int i=0; i<n; i++){
            parent.add(i);
            size.add(1);
        }
    }

    public int findUPar(int node){
        if(node == parent.get(node)){
            return node;
        }
        int ulp = findUPar(parent.get(node));
        parent.set(node, ulp);
        return ulp;
    }
    
    public void unionBySize(int u, int v){
        int ulpU = findUPar(u);
        int ulpV = findUPar(v);

        if(ulpU == ulpV) return;
        if(size.get(ulpU) < size.get(ulpV)){
            parent.set(ulpU, ulpV);
            size.set(ulpV, size.get(ulpV) + size.get(ulpU));
        }
        else{
            parent.set(ulpV, ulpU);
            size.set(ulpU, size.get(ulpU) + size.get(ulpV));
        }
        components--;
    }
}