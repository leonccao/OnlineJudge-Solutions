class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] set = new int[26];
        for (int i = 0; i < magazine.length(); i ++)
            set[magazine.charAt(i) - 'a'] ++;
        for (int i = 0; i < ransomNote.length(); i ++)
            if (-- set[ransomNote.charAt(i) - 'a'] < 0)
                return false;
        return true;
    }
}