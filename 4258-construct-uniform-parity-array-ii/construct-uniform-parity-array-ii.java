class Solution {
    public boolean uniformArray(int[] nums1) {
        int minEle = Integer.MAX_VALUE;
        for(int ele: nums1){
            minEle = Math.min(minEle, ele);
        }
        boolean isEven = true;
        for(int ele: nums1){
            if(ele % 2 != 0){
                isEven = false;
            }
        }
        if(minEle % 2 != 0 || isEven == true){
            return true;
        }
        return false;
    }
}