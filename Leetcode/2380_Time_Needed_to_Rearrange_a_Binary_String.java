class Solution {
    public int secondsToRemoveOccurrences(String s) {
        boolean change = true;
        StringBuilder sb = new StringBuilder(s);
        int result = 0;
        while (change) {
            change = false;
            for (int i = 0; i < sb.length() - 1; i++) {
                if (sb.charAt(i) == '0' && sb.charAt(i + 1) == '1') {
                    sb.replace(i, i + 2, "10");
                    i++;
                    change = true;
                }
            }
            if (change) {
                result++;
            }
        }
        return result;
    }
}