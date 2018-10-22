class Solution {
    public boolean canCross(int[] stones) {
        if (stones[1] != 1) return false;
        
        Map<Integer, Set> map  = new HashMap<Integer, Set>();
        for (int i = 0; i < stones.length; i ++)
            map.put(stones[i], new HashSet<Integer>());
        map.get(1).add(1);
        
        for (int i = 1; i < stones.length - 1; i ++) {
            if (!map.containsKey(stones[i])) continue;
            Set<Integer> stepList = map.get(stones[i]);
            for (int step : stepList) {
                if (step > 1 && map.containsKey(stones[i] + step - 1))
                    map.get(stones[i] + step - 1).add(step - 1);
                if (map.containsKey(stones[i] + step))
                    map.get(stones[i] + step).add(step);
                if (map.containsKey(stones[i] + step + 1))
                    map.get(stones[i] + step + 1).add(step + 1);
            }
        }
        if (map.get(stones[stones.length - 1]).isEmpty())
            return false;
        return true;
    }
}