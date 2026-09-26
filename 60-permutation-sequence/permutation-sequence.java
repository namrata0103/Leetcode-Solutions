class Solution {
    public String getPermutation(int n, int k) {
        List<Integer> num = new ArrayList<>();
        for(int i=1; i<=n; i++){
            num.add(i);
        }
        int fact = 1;
        for(int i=1; i<n; i++){
            fact = fact * i;
        }
        k = k - 1;
        String ans = "";
        while(num.size() > 0){
            int ind = k / fact;
            ans = ans + num.get(ind);
            num.remove(ind);
            k = k % fact;
            if(num.size() > 0){
                fact = fact / num.size();
            }
        }
        return ans;
    }
}