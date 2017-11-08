class Solution {
public:
    int lengthOfLastWord(string s) {
        while (!s.empty() && s[0] == ' ')
            s.erase(0, 1);
        while (!s.empty() && s[s.length() - 1] == ' ')
            s.erase(s.length() - 1, 1);
        int pos = s.rfind(' ', s.length() - 1);
        if (pos > -1)
            return s.length() - pos - 1;
        else return s.length();
    }
};