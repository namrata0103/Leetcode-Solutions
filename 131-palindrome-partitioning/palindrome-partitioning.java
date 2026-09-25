class Solution {
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> res = new ArrayList<>();
        helper(s, ans, res, 0);
        return ans;
    }
    public static void helper(String s, List<List<String>> ans, List<String> res, int ind){
        if(ind == s.length()){
            ans.add(new ArrayList<>(res));
            return;
        }
        for(int i=ind; i<s.length(); i++){
            if(isPalindrome(s, ind, i)){
                res.add(s.substring(ind, i+1));
                helper(s, ans, res, i+1);
                res.remove(res.size()-1);
            }
        }
    }
    public static boolean isPalindrome(String s, int start, int end){
        while(start <= end){
            if(s.charAt(start) != s.charAt(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}