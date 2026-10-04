class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int psum = 0;
        map.put(0, -1);
        int max = 0;
        for(int i=0; i<nums.length; i++){
            if(nums[i] == 0){
                psum += -1;
            }
            else{
                psum += 1;
            }
            if(map.containsKey(psum)){
                max = Math.max(max, i-map.get(psum));
            }
            else{
                map.put(psum, i);
            }
        }
        return max;
    }
}