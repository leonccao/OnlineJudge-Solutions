class Solution {
    public int rearrangeCharacters(String s, String target) {
        int[] ca = new int[26];
        int[] cb = new int[26];
        
        for (char ch : s.toCharArray()) {
            ca[ch - 'a']++;
        }
        for (char ch : target.toCharArray()) {
            cb[ch - 'a']++;
        }
        int count = Integer.MAX_VALUE;
        for (char ch : target.toCharArray()) {
            int index = ch - 'a';
            int temp = ca[index] / cb[index];
            count = Math.min(count, temp);           
        }
        return count;
    }
}