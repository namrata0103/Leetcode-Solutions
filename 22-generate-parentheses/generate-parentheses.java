class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        helper(n, 0, 0, "", ans);
        return ans;
    }
    public static void helper(int n, int open, int close, String s, List<String> ans){
        if(s.length() == 2*n){
            ans.add(s);
            return;
        }
        if(open < n){
            helper(n, open+1, close, s+'(', ans);
        }
        if(close < open){
            helper(n, open, close+1, s+')', ans);
        }
    }
}