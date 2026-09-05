class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffix[i] = Math.min(nums[i], suffix[i + 1]);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i=0; i<n; i++){
            maxi = Math.max(maxi, nums[i]);
            
            if(maxi - suffix[i] <= k){
                return i;
            }
        }
        return -1;
    }
}