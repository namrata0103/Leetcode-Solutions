class Solution {
    public int totalNumbers(int[] digits) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<digits.length; i++){
            map.put(digits[i], map.getOrDefault(digits[i], 0) + 1);
        }
        int ans = 0;
        // hundreds place
        for(int i=1; i<=9; i++){
            if(!map.containsKey(i)){
                continue;
            }
            map.put(i, map.get(i) - 1);

            // tens place
            for(int j=0; j<=9; j++){
                if(!map.containsKey(j) || map.get(j) == 0){
                    continue;
                }
                map.put(j, map.get(j) - 1);

                // unit place
                for(int k=0; k<9; k+=2){
                    if(map.containsKey(k) && map.get(k) > 0){
                        ans++;
                    }
                }
                map.put(j, map.get(j) + 1);
            }
            map.put(i, map.get(i) + 1);
        }
        return ans;
    }
}