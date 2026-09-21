class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(candidates, target, ans, 0, res);
        return ans;
    }
    public static void helper(int[] arr, int k, List<List<Integer>> ans, int ind, List<Integer> res){
        if(k < 0) return;
        if(ind == arr.length){
            if(k == 0){
                ans.add(new ArrayList<>(res));
            }
            return;
        }
        res.add(arr[ind]);
        helper(arr, k-arr[ind], ans, ind, res);
        res.remove(res.size()-1);
        helper(arr, k, ans, ind+1, res);
    }
}