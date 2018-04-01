class Solution {
    public int expressiveWords(String S, String[] words) {
        StringBuilder sb = new StringBuilder();
        
        S += " ";
        int count = 0;
        for (int i = 0; i < S.length(); i ++) {
            if (i != 0 && S.charAt(i - 1) == S.charAt(i))
                count ++;
            else if (i == 0) count = 1;
            else {
                sb.append(S.charAt(i - 1));
                if (count > 2)
                    sb.append("{1," + count + "}");
                else sb.append("{" + count + "}");
                count = 1;
            }
        }
        
        String regex = sb.toString();
        int answer = 0;
        for (String word : words)
            if (word.matches(regex))
                answer ++;
        return answer;
    }
}