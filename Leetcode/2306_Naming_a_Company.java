class Solution {
    public long distinctNames(String[] ideas) {
        List<HashSet<String>> dict = new ArrayList<HashSet<String>>();

        for (int i = 0; i < 26; ++i)
            dict.add(i, new HashSet<String>());
        
        for (String idea : ideas) {
            char ch = idea.charAt(0);
            String sub = idea.substring(1);
            dict.get(ch - 'a').add(sub);
        }
        
        
        long result = 0;
        for (int i = 0; i < 26; i++) {
            Set<String> sa = dict.get(i);
            for (int j = i + 1; j < 26; j++) {
                Set<String> sb = dict.get(j);
                int ca = 0, cb = 0;
                for (String a : sa) {
                    if (!sb.contains(a)) {
                        ca++;
                    }
                }
                for (String b : sb) {
                    if (!sa.contains(b)) {
                        cb++;
                    }
                }
                result += (long)ca * cb * 2;
            }
        }
        return result;
    }
}