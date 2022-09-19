class Solution {
    public int partitionString(String s) {
        int result = 1;
        Set<Character> set = new HashSet<>();
        for (char ch : s.toCharArray()) {
            if (set.contains(ch)) {
                result++;
                set = new HashSet<>();
            }
            set.add(ch);
        }
        return result;
    }
}
