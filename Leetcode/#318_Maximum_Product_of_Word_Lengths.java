class Solution {
    public int maxProduct(String[] words) {
        int[] bit = new int[words.length];
        
        for (int i = 0; i < words.length; i ++) {
            int offset =  1;
            for (char ch = 'a'; ch <= 'z'; ch ++) {
                if (words[i].indexOf(ch) > -1)
                    bit[i] |= offset;
                offset <<= 1;
            }
        }
        
        int ans = 0;
        for (int i = 0; i < words.length; i ++)
            for (int j = i + 1; j < words.length; j ++)
                if ((bit[i] & bit[j]) == 0)
                    ans = Math.max(ans, words[i].length() * words[j].length());
        return ans;
    }
}