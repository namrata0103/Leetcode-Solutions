class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int i = 0;
        int max = Integer.MIN_VALUE;
        while(i < n){
            for(int j=0; j<=i; j++){
                max = Math.max(max, nums[j]);
            }
            int min = Integer.MAX_VALUE;
            for(int l=i; l<n; l++){
                if(nums[l] < min){
                    min = nums[l];
                }
            }
            if(max - min <= k){
                return i;
            }
            i++;
        }
        return -1;
    }
}