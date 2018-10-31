class Solution {
    public int repeatedStringMatch(String A, String B) {
        if (B == null || B.length() == 0) return 0;
        if (A == null || A.length() == 0) return -1;
        StringBuilder sb = new StringBuilder();
        int ans = 0;
        while (sb.length() < B.length()) {
            sb.append(A); ans ++;
        }
        if (sb.lastIndexOf(B) > -1) return ans;
        if (sb.append(A).lastIndexOf(B) > -1) return ++ ans;
        return  -1;
    }
}