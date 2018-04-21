class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        List<String> res = new LinkedList<String>();
        if (s.length() < 10) return res;
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        StringBuilder sb = new StringBuilder(" ");
        sb.append(s.substring(0, 9));
        for (int i = 9; i < s.length(); i ++) {
            sb.deleteCharAt(0);
            sb.append(s.charAt(i));
            String tmp = sb.toString();
            if (map.containsKey(tmp))
                map.put(tmp, map.get(tmp) + 1);
            else map.put(tmp, 1);
        }
        
        for (String tmp : map.keySet())
            if (map.get(tmp) > 1)
                res.add(tmp);
        return res;
    }
}