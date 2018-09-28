/*
### Bugs
1. `needle.length()`
*/
class Solution {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0 || needle.equals("")) return 0;
        
        int[] pre = new int[needle.length()];
        pre[0] = -1;
        
        int j = -1;
        for (int i = 1; i < needle.length(); i ++) {
            while (j > -1 && needle.charAt(i) != needle.charAt(j + 1)) j = pre[j];
            if (needle.charAt(i) == needle.charAt(j + 1)) j ++;
            pre[i] = j;
        }
        
        j = -1;
        for (int i = 0; i < haystack.length(); i ++) {
            while (j > -1 && haystack.charAt(i) != needle.charAt(j + 1)) j = pre[j];
            if (haystack.charAt(i) == needle.charAt(j + 1)) j ++;
            if (j == needle.length() - 1)
                return i - j;
        }
        return -1;
    }
}