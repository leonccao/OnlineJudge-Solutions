class Solution {
public:
    bool isPalindrome(int x) {
        // Check if x is an negative number
        if (x < 0) return false;
        
        string s = "";
        while (x) {
            s.append(1, '0' + x % 10);
            x /= 10;
        }
        
        for (int i = 0; i < s.size(); i ++)
            if (s[i] != s[s.size() - i - 1])
                return false;
        return true;
    }
};