class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        helper(nums, 0, ans);
        return ans;
    }
    public static void helper(int[] nums, int ind, List<List<Integer>> ans){
        if(ind == nums.length){
            List<Integer> res = new ArrayList<>();
            for(int ele: nums){
                res.add(ele);
            }
            ans.add(res);
            return;
        }
        for(int i=ind; i<nums.length; i++){
            swap(nums, ind, i);
            helper(nums, ind+1, ans);
            swap(nums, ind, i);
        }
    }
    public static void swap(int[] nums, int i, int j){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}