class Solution {
    public List<String> beforeAndAfterPuzzles(String[] phrases) {
        List<String> ans = new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (int i = 0; i < phrases.length; i ++) {
            for (int j = i + 1; j < phrases.length; j ++) {
                if (getLastWord(phrases[i]).equals(getFirstWord(phrases[j]))) {
                    String tmp = phrases[i] + removeFirstWord(phrases[j]);
                    if (!set.contains(tmp)) {
                        ans.add(tmp);
                        set.add(tmp);
                    }
                }
                if (getLastWord(phrases[j]).equals(getFirstWord(phrases[i]))) {
                    String tmp = phrases[j] + removeFirstWord(phrases[i]);
                    if (!set.contains(tmp)) {
                        ans.add(tmp);
                        set.add(tmp);
                    }
                }
            }
        }
        Collections.sort(ans, (String a, String b) -> a.compareTo(b));
        return ans;
    }
    
    private String getFirstWord(String s) {
        int pos = s.indexOf(" ");
        if (pos < 0) return s;
        return s.substring(0, pos);
    }
    
    private String getLastWord(String s) {
        int pos = s.lastIndexOf(" ");
        if (pos < 0) return s;
        return s.substring(pos + 1, s.length());
    }
    
    private String removeFirstWord(String s) {
        int pos = s.indexOf(" ");
        if (pos < 0) return "";
        return " " + s.substring(pos + 1, s.length());
    }
}