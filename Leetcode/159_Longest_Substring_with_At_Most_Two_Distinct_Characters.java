class Solution {
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        Map<Character, Integer> map = new HashMap<>();
        int j = 0, ans = 0;
        for (int i = 0; i < s.length(); i ++) {
            char ch = s.charAt(i);
            map.put(ch, map.getOrDefault(ch, 0) + 1);
            while (map.size() > 2) {
                char tail = s.charAt(j);
                map.put(tail, map.get(tail) - 1);
                if (map.get(tail) == 0) map.remove(tail);
                j ++;
            }
            ans = Math.max(ans, i - j + 1);
        }
        return ans;
    }
}