class Solution {
    public int numSubseq(int[] nums, int target) {
        int mod = 1000000007;
        Arrays.sort(nums);
        int[] power = new int[nums.length];
        power[0] = 1;
        for(int i=1; i<power.length; i++){
            power[i] = (power[i-1] * 2) % mod;
        }
        int l = 0;
        int r = nums.length - 1;
        int cnt = 0;
        while(l <= r){
            if(nums[l] + nums[r] <= target){
                cnt = (cnt + power[r-l]) % mod;
                l++;
            }
            else{
                r--;
            }
        }
        return cnt;
    }
}