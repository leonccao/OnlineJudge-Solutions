class Solution {
    public String largestPalindromic(String num) {
        int[] cnt = new int[10];
        for (char ch : num.toCharArray()) {
            cnt[ch - '0']++;
        }
        int maxEven = -1, maxOdd = -1;
        for (int i = 0; i < 10; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            if (cnt[i] > 1) {
                maxEven = Math.max(maxEven, i);
            }
            maxOdd = Math.max(maxOdd, i);
        }
        
        StringBuilder sb = new StringBuilder();
        if (maxEven > 0) {
            for (int i = 9; i >= 0; i--) {
                if (cnt[i] > 1) {
                    for (int j = 0; j < cnt[i] / 2; j++) {
                        sb.append(i);
                    }
                    cnt[i] -= cnt[i] / 2 * 2;
                }
            }
        }
        StringBuilder sc = new StringBuilder(sb);
        for (int i = 9; i >= 0; i--) {
            if (cnt[i] > 0) {
                sb.append(i);
                break;
            }
        }
        return sb.append(sc.reverse()).toString();
    }
}