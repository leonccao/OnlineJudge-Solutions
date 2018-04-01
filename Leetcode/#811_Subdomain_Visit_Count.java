class Solution {
    public List<String> subdomainVisits(String[] cpdomains) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : cpdomains) {
            int cnt = Integer.valueOf(s.substring(0, s.indexOf(' ')));
            int lastIndex = s.length() - 1;
            
            String t = s.substring(s.lastIndexOf(' ') + 1, s.length());
            if (map.containsKey(t))
                map.put(t, map.get(t) + cnt);
            else map.put(t, cnt);
            while (s.lastIndexOf('.', lastIndex) != -1) {
                t = s.substring(s.lastIndexOf('.', lastIndex) + 1, s.length());
                if (map.containsKey(t))
                    map.put(t, map.get(t) + cnt);
                else map.put(t, cnt);
                lastIndex = s.lastIndexOf('.', lastIndex) - 1;
            }
        }
        List<String> result = new ArrayList<String>();
        for (Map.Entry<String, Integer> entry : map.entrySet())
            result.add(entry.getValue() + " " + entry.getKey());
        return result;
    }
}