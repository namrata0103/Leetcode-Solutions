class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if(sum > num * 9) return "";
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<num; i++){
            int good = Math.min(9, sum);
            sb.append(good);
            sum -= good;
            if(sum < 0) return "";
        }
        return sb.toString();
    }
}