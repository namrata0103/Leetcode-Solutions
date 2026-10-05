class Solution {
    public int scoreOfParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(0);
            }
            else{
                int x = st.pop();
                int score;
                if(x == 0){
                    score = 1;
                }
                else{
                    score = 2 * x;
                }
                if(!st.isEmpty()){
                    int parent = st.pop();
                    st.push(parent + score);
                }
                else{
                    st.push(score);
                }
            }
        }
        return st.pop();
    }
}