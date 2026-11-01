class Solution {
    public int minMoves(int[] nums) {
        int mini = Integer.MAX_VALUE;
        int ans = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] < mini){
                mini = nums[i];
            }
        }
        for(int i=0; i<nums.length; i++){
            if(nums[i] > mini){
                ans += nums[i] - mini;
            }
        }
        return ans;
    }
}