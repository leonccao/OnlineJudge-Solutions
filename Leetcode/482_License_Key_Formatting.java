class Solution {
    public String licenseKeyFormatting(String S, int K) {
        if (S == null || S.length() == 0) return "";
        
        S = S.toUpperCase().replaceAll("-", "");
        StringBuilder sb = new StringBuilder();
        int count = 0;
        for (int i = 0; i < (S.length() - 1) % K + 1; i ++)
            sb.append(S.charAt(count ++));
        for (int i = 0; i < (S.length() - 1) / K; i ++) {
            sb.append('-');
            for (int j = 0; j < K; j ++)
                sb.append(S.charAt(count ++));
        }
        return sb.toString();
    }
}