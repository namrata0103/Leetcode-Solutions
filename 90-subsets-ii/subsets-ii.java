class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        helper(nums, ans, res, 0);
        return ans;
    }
    public static void helper(int[] nums, List<List<Integer>> ans, List<Integer> res, int ind){
        ans.add(new ArrayList<>(res));
        for(int i=ind; i<nums.length; i++){
            if(i > ind && nums[i] == nums[i-1]){
                continue;
            }
            res.add(nums[i]);
            helper(nums, ans, res, i+1);
            res.remove(res.size()-1);
        }
    }
}