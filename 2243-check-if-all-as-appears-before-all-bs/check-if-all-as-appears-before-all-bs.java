class Solution {
    public boolean checkString(String s) {
        int maxA = -1;
        int minB = Integer.MAX_VALUE;
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == 'a'){
                maxA = i;
            }
            else{
                minB = Math.min(minB, i);
            }
        }
        if(maxA > minB) return false;
        return true;
    }
}