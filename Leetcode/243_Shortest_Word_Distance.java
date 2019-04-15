class Solution {
    public int shortestDistance(String[] words, String word1, String word2) {
        int ans = words.length;
        int index1 = -1, index2 = -1;
        for (int i = 0; i < words.length; i ++) {
            if (words[i].equals(word1)) index1 = i;
            if (words[i].equals(word2)) index2 = i;
            if (index1 > -1 && index2 > -1) {
                ans = Math.min(ans, Math.abs(index1 - index2));
            }
        }
        return ans;
    }
}