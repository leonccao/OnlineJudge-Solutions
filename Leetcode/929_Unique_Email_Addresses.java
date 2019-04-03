class Solution {
    public int numUniqueEmails(String[] emails) {
        Set<String> set = new HashSet<>();
        for (String s : emails) {
            StringBuilder sb = new StringBuilder();
            boolean ignore = false;
            boolean at = false;
            for (char ch : s.toCharArray()) {
                if (ch == '@') {
                    ignore = false;
                    at = true;
                }
                if (ignore) continue;
                
                if (!at) {
                    if (ch == '.') continue;
                    if (ch == '+') {
                        ignore = true;
                        continue;
                    }
                }
                sb.append(ch);
            }
            
            String res = sb.toString();
            set.add(res);
        }
        return set.size();
    }
}