class Solution {

    int len;
    
    Map<Integer, Integer> map;
    
    public Solution(int N, int[] blacklist) {
        map = new HashMap<Integer, Integer>();
        for (int num : blacklist)
            map.put(num, -1);
        
        Arrays.sort(blacklist);
        int cur = N - 1;
        for (int num : blacklist) {
            while (map.containsKey(cur)) cur --;
            if (num > cur) break;
            map.put(num, cur --);
        }
        
        len = N - blacklist.length;
    }
    
    public int pick() {
        int rtn = (int)(Math.random() * len);
        if (map.containsKey(rtn))
            rtn = map.get(rtn);
        return rtn;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(N, blacklist);
 * int param_1 = obj.pick();
 */