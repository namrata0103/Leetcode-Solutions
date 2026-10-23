class Solution {
    public int sortPermutation(int[] nums) {
        boolean sorted = true;
        for(int i=0; i<nums.length-1; i++){
            if(nums[i] > nums[i+1]){
                sorted = false;
                break;
            }
        }
        if(sorted) return 0;
        int maxi = -1;
        for(int i=0; i<nums.length; i++){
            if(nums[i] != i){
                if(maxi == -1){
                    maxi = nums[i];
                }
                else{
                    maxi = maxi & nums[i];
                }
            }
        }
        return maxi;
    }
}