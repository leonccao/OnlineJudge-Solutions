class Solution {
public:
    string longestPalindrome(string s) {
        int answer = 1;
        string answer_string("");
        answer_string.assign(s, 0, 1);
        for (int i = 0; i < s.size() - 1; ++ i) {
            int tmp = 1, j;
            for (j = 1; ; j ++) {
                if (i - j < 0) break;
                if (i + j >= s.size()) break;
                if (s[i - j] != s[i + j]) break;
                tmp += 2;
            }
            if (tmp > answer) {
                answer = tmp;
                answer_string.assign(s, i - j + 1, answer);
            }
            
            tmp = 0;
            for (j = 1; ; j ++) {
                if (i - j + 1 < 0) break;
                if (i + j >= s.size()) break;
                if (s[i - j + 1] != s[i + j]) break;
                tmp += 2;
            }
            if (tmp > answer) {
                answer = tmp;
                answer_string.assign(s, i - j + 2, answer);
            }
            
        }
        return answer_string;
    }
};