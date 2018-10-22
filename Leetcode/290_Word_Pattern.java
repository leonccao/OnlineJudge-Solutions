class Solution {
    public boolean wordPattern(String pattern, String str) {
        Map<Character, String> map = new HashMap<Character, String>();
        String[] strs = str.split(" ");
        if (pattern.length() != strs.length)
            return false;
        for (int i = 0; i < pattern.length(); i ++) {
            char ch = pattern.charAt(i);
            System.out.println(ch + " " + strs[i]);
            if (map.containsKey(ch)) {
                if (!map.get(ch).equals(strs[i]))
                    return false;
            } else if (map.containsValue(strs[i]))
                return false;
            else map.put(ch, strs[i]);
        }
        return true;
    }
}