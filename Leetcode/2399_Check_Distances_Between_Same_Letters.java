class Solution {
    public boolean checkDistances(String s, int[] distance) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            int cur = s.charAt(i) - 'a';
            if (map.containsKey(cur)) {
                int dist = i - map.get(cur);
                if (dist - 1 != distance[cur]) {
                    return false;
                }
            } else {
                map.put(cur, i);
            }
        }
        return true;
    }
}