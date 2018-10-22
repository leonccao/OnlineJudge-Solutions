class Solution {
    public String getHint(String secret, String guess) {
        int A = 0, B = 0;
        int[] cnt = new int[10];
        
        for (int i = 0; i < secret.length(); i ++) {
            if (secret.charAt(i) == guess.charAt(i))
                continue;
            int tmp = guess.charAt(i) - '0';
            cnt[tmp] ++;
        }
        for (int i = 0; i < secret.length(); i ++) {
            if (secret.charAt(i) == guess.charAt(i))
                A ++;
            else {
                int tmp = secret.charAt(i) - '0';
                if (cnt[tmp] == 0) continue;
                cnt[tmp] --;
                B ++;
            }
        }
        return  A + "A" + B + "B";
    }
}