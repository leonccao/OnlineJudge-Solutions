class Solution {
    public void DFS(String s, int pos, int step, StringBuilder sb, List<String> result) {
        if (pos == s.length()) {
            if (step == 4)
                result.add(sb.toString().substring(1, sb.length()));
            return;
        }
        int posLeft = s.length() - pos;
        int stepLeft = 4 - step;
        if (posLeft < stepLeft) return;
        if (posLeft > stepLeft * 4) return;
        
        sb.append('.');
        for (int i = 1; i < 4; i ++) {
            if (pos + i > s.length()) break;
            if (s.charAt(pos) == '0' && i > 1) break;
            if (Integer.parseInt(s.substring(pos, pos + i)) > 255) break;
            sb.append(s.charAt(pos + i - 1));
            DFS(s, pos + i, step + 1, sb, result);
        }
        sb.delete(sb.lastIndexOf("."), sb.length());
    }
    
    public List<String> restoreIpAddresses(String s) {
        LinkedList<String> result = new LinkedList<String>();
        StringBuilder sb = new StringBuilder();
        DFS(s, 0, 0, sb, result);
        return result;
    }
}