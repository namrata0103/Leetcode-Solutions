class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int sum = 0;
        int l = 0;
        int r = 0;
        int[] best = new int[arr.length];
        Arrays.fill(best, Integer.MAX_VALUE);
        int minLen = Integer.MAX_VALUE;
        int answer = Integer.MAX_VALUE;
        while(r < arr.length){
            sum += arr[r];
            while(sum > target){
                sum -= arr[l];
                l++;
            }
            if(sum == target){
                int curr = r - l + 1;
                if(l > 0 && best[l-1] != Integer.MAX_VALUE){
                    answer = Math.min(answer, curr+best[l-1]);
                }
                minLen = Math.min(minLen, r-l+1);
            }
            best[r] = minLen;
            r++;
        }
        if(answer == Integer.MAX_VALUE){
            return -1;
        }
        return answer;
    }
}