class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int sum = 1;
        int i = 1;
        while(i < n){
            if(ratings[i] == ratings[i-1]){
                sum++;
                i++;
                continue;
            }
            int peak = 1;
            while(i < n && ratings[i] > ratings[i-1]){
                peak++;
                sum += peak;
                i++;
            }
            int down = 0;
            while(i < n && ratings[i] < ratings[i-1]){
                down++;
                sum += down;
                i++;
            }
            if(down >= peak){
                sum += down - peak + 1;
            }
        }
        return sum;
    }
}