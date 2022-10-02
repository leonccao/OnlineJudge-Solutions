class Solution {
    public boolean equalFrequency(String word) {
        int[] cnt = new int[26];
        for (char ch : word.toCharArray()) {
            cnt[ch - 'a']++;
        }
        
        for (int i = 0; i < 26; i++) {
            if (cnt[i] == 0) {
                continue;
            }
            cnt[i]--;
            
            int maxCnt = -1;
            boolean success = true;
            for (int j = 0; j < 26; j++) {
                if (cnt[j] == 0) {
                    continue;
                }
                if (maxCnt != -1 && maxCnt != cnt[j]) {
                    success = false;
                    break;
                }
                maxCnt = cnt[j];
            }
            if (success) {
                return true;
            }
            
            cnt[i]++;
        }
        return false;
    }
}