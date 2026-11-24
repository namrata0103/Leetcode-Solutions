class Solution {
    public int maxLength(int[] nums) {
        int n = nums.length;
        int ans = 0;
        for(int i=0; i<n; i++){
            int prod = 1;
            int lcm = 1;
            int gcd = 0;
            for(int j=i; j<n; j++){
                prod = prod * nums[j];
                gcd = gcD(gcd, nums[j]);
                lcm = lcM(lcm, nums[j]);

                if(prod == (lcm * gcd)){
                    ans = Math.max(ans, j-i+1);
                }
            }
        }
        return ans;
    }
    public static int gcD(int a, int b){
        while(b != 0){
            int rem = a % b;
            a = b;
            b = rem;
        }
        return a;
    }
    public static int lcM(int a, int b){
        return (a / gcD(a, b)) * b;
    }
}