class Solution {
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(k, n, ans, res, 1);
        return ans;
    }
    public static void helper(int k, int n, List<List<Integer>> ans, List<Integer> res, int i){
        if(k == 0 ){
            if(n == 0){
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        if(i > 9 || n < 0) return;
        res.add(i);
        helper(k-1, n-i, ans, res, i+1);
        res.remove(res.size()-1);
        helper(k, n, ans, res, i+1);
    }
}