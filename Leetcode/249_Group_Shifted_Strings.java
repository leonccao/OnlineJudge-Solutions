// string sort
class Solution {
    private class Str {
        String s;
        int len;
        String pattern = "";
        public Str(String s) {
            this.s = s;
            len = s.length();
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < len - 1; i ++) {
                int tmp = (s.charAt(i + 1) - s.charAt(i) + 26) % 26;
                sb.append(tmp);
                sb.append(',');
            }
            pattern = sb.toString();
        }
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        if (strings == null || strings.length == 0)
            return Collections.emptyList();
        
        Str[] words = new Str[strings.length];
        for (int i = 0; i < strings.length; i ++) {
            words[i] = new Str(strings[i]);
        }
        
        Arrays.sort(words, (a, b) -> {
            if (a.len != b.len)
                return a.len - b.len;
            return a.pattern.compareTo(b.pattern);
        });
        
        List<List<String>> ans = new ArrayList<>();
        ans.add(new ArrayList<>());
        ans.get(ans.size() - 1).add(words[0].s);
        for (int i = 1; i < words.length; i ++) {
            Str cur = words[i];
            Str last = words[i - 1];
            if (cur.len != last.len || !cur.pattern.equals(last.pattern))
                ans.add(new ArrayList<>());
            ans.get(ans.size() - 1).add(cur.s);
        }
        
        return ans;
    }
}

// HashMap
class Solution {
    private String pattern(String s) {
        if (s == null || s.equals("")) return "";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length() - 1; i ++) {
            int tmp = (s.charAt(i + 1) - s.charAt(i) + 26) % 26;
            sb.append(tmp);
            sb.append(',');
        }
        return sb.toString();
    }
    
    public List<List<String>> groupStrings(String[] strings) {
        Map<String, List<String>> map = new HashMap<>();
        
        for (String s : strings) {
            String p = pattern(s);
            if (!map.containsKey(p))
                map.put(p, new ArrayList<>());
            map.get(p).add(s);
        }
        
        List<List<String>> ans = new ArrayList<>();
        for (String s : map.keySet()) {
            ans.add(map.get(s));
        }
        return ans;
    }
}