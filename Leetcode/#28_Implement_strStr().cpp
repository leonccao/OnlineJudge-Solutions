class Solution {
public:
    int strStr(string haystack, string needle) {
        if (needle.empty()) return 0;
        if (haystack.empty()) return -1;
         
        vector<int> pre(needle.size(), -1);
        
        int p = -1;
        for (int i = 1; i < needle.size(); i ++) {
            while (p > -1 && needle[i] != needle[p + 1]) 
                p = pre[p];
            if (needle[i] == needle[p + 1]) p ++;
            pre[i] = p;
        }
        
        p = -1;
        for (int i = 0; i < haystack.size(); i ++) {
            while (p > -1 && haystack[i] != needle[p + 1]) {
                p = pre[p];
            }
            if (haystack[i] == needle[p + 1]) p ++;
            if (p + 1 == needle.size())
                return i + 1 - needle.size();
        }
        return -1;
    }
};