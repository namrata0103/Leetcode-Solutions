class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        HashSet<String> set = new HashSet<>();
        for(int i=0; i<wordList.size(); i++){
            set.add(wordList.get(i));
        }
        if(!set.contains(endWord)){
            return 0;
        }
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(beginWord, 1));
        while(!q.isEmpty()){
            String node = q.peek().first;
            int sts = q.peek().second;
            q.remove();
            if(node.equals(endWord)){
                return sts;
            }
            for(int i=0; i<node.length(); i++){
                StringBuilder sb = new StringBuilder(node);
                for(char ch='a'; ch<='z'; ch++){
                    sb.setCharAt(i, ch);
                    String newWord = sb.toString();
                    if(set.contains(newWord)){
                        q.add(new Pair(newWord, sts+1));
                        set.remove(newWord);
                    }
                }
            }
        }
        return 0;
    }
    class Pair{
        String first;
        int second;
        public Pair(String first, int second){
            this.first = first;
            this.second = second;
        }
    }
}