class Solution {
    public int minAddToMakeValid(String s) {
        int cnt = 0;
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                st.push(s.charAt(i));
            }
            else{
                if(!st.isEmpty() && st.peek() == '('){
                    st.pop();
                }
                else{
                    st.push(s.charAt(i));
                }
            }
        }
        while(!st.isEmpty()){
            st.pop();
            cnt++;
        }
        return cnt;
    }
}