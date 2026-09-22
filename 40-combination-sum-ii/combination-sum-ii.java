class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(candidates, target, ans, res, 0);
        return ans;
    }
    public static void helper(int[] arr, int k, List<List<Integer>> ans, List<Integer> res, int ind){
        if(k == 0){
            ans.add(new ArrayList<>(res));
            return;
        }
        for (int i = ind; i < arr.length; i++) {
            if (i > ind && arr[i] == arr[i - 1]) {
                continue;
            }
            if (arr[i] > k) {
                break;
            }
            res.add(arr[i]);
            helper(arr, k - arr[i], ans, res, i+1);
            res.remove(res.size() - 1);
        }
    }
}