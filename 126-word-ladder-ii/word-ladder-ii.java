class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        Queue<String> q = new LinkedList<>();
        HashMap<String, Integer> map = new HashMap<>();
        HashSet<String> set = new HashSet<>();

        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)){
            return ans;
        }
        q.add(beginWord);
        map.put(beginWord, 1);
        set.remove(beginWord);  
        while(!q.isEmpty()){
            String word = q.peek();
            int steps = map.get(word);
            q.remove();
            if(word.equals(endWord)){
                break;
            }
            for(int i=0; i<word.length(); i++){
                StringBuilder sb = new StringBuilder(word);
                for(char ch='a'; ch<='z'; ch++){
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if(set.contains(newWord)){
                        q.add(newWord);
                        map.put(newWord, steps+1);
                        set.remove(newWord);
                    }
                }
            }
        }
        if(map.containsKey(endWord)){
            List<String> res = new ArrayList<>();
            res.add(endWord);
            dfs(beginWord, endWord, res, ans, map);
        }
        return ans;
    }
    public static void dfs(String beginWord, String word, List<String> res, List<List<String>> ans, HashMap<String, Integer> map){
        if(word.equals(beginWord)){
            List<String> path = new ArrayList<>(res);
            Collections.reverse(path);
            ans.add(path);
            return;
        }
        int steps = map.get(word);
        for(int i=0; i<word.length(); i++){
            StringBuilder sb = new StringBuilder(word);
            for(char ch='a'; ch<='z'; ch++){
                sb.setCharAt(i, ch);
                String newWord = sb.toString();
                if(map.containsKey(newWord) && map.get(newWord) == steps-1){
                   res.add(newWord);
                   dfs(beginWord, newWord, res, ans, map);
                    res.remove(res.size() - 1);
                }
            }
        }
    } 
}