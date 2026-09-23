class Solution {
    public int minOperations(int[] nums, int x) {
        int sum = 0;
        for(int ele: nums){
            sum += ele;
        }
        int target = sum - x;
        if(target < 0){
            return -1;
        }
        if(target == 0){
            return nums.length;
        }
        int l = 0;
        int r = 0;
        int maxLen = -1;
        int ad = 0;
        while(r < nums.length){
            ad += nums[r];
            while(ad > target){
                ad -= nums[l];
                l++;
            }
            if(ad == target){
                maxLen = Math.max(maxLen, r-l+1);
            }
            r++;
        }
        if(maxLen == -1){
            return maxLen;
        }
        return nums.length - maxLen;
    }
}