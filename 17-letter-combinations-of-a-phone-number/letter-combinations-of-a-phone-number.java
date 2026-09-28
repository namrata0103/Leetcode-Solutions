class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> ans = new ArrayList<>();
        String[] keypad = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        helper(digits, 0, keypad, ans, "");
        return ans;
    }
    public static void helper(String digits, int ind, String[] keypad, List<String> ans, String res){
        if(ind == digits.length()){
            ans.add(res);
            return;
        }
        int digit = digits.charAt(ind) - '0';
        String letter = keypad[digit];
        for(int i=0; i<letter.length(); i++){
            char ch = letter.charAt(i);
            helper(digits, ind+1, keypad, ans, res+ch);
        }
    }
}