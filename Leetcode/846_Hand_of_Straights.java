class Solution {
    public boolean isNStraightHand(int[] hand, int W) {
        if (hand.length % W != 0) return false;
        
        Arrays.sort(hand);
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : hand) 
            if (map.containsKey(num))
                map.put(num, map.get(num) + 1);
            else map.put(num, 1);
        
        int cur = 0;
        for (int time = 0; time < hand.length / W; time ++) {
            while (cur < hand.length && map.get(hand[cur]) == 0) cur ++;
            if (cur == hand.length) break;
            for (int i = hand[cur]; i < hand[cur] + W; i ++) {
                if (!map.containsKey(i) || map.get(i) < 1) 
                    return false;
                map.put(i, map.get(i) - 1);
            }
        }
        return true;
    }
}