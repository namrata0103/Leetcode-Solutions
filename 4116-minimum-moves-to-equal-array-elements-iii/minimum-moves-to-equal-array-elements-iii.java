class Solution {
    public int minMoves(int[] nums) {
        int ans = 0;
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<nums.length; i++){
            maxi = Math.max(maxi, nums[i]);
        }
        for(int i=0; i<nums.length; i++){
            ans += Math.abs(nums[i] - maxi);
        }
        return ans;
    }
}