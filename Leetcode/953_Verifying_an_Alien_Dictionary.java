class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < order.length(); i ++)
            map.put(order.charAt(i), i);
        for (int i = 0; i < words.length - 1; i ++)
            if (compare(words[i], words[i + 1], map) > 0)
                return false;
        return true;
    }
    
    public int compare(String a, String b, Map<Character, Integer> map) {
        if (a.equals(b)) return 0;
        for (int i = 0; i < Math.min(a.length(), b.length()); i ++) {
            char p = a.charAt(i);
            char q = b.charAt(i);
            if (map.get(p) < map.get(q)) return -1;
            if (map.get(p) > map.get(q)) return  1;
        }
        return a.length() - b.length();
    }
}