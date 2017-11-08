class Solution {
public:
    string countAndSay(int n) {
        string sta = "";
        string stb = "1";
        for (int i = 1; i < n; i ++) {
            swap(sta, stb);
            stb = "";
            int pos = 0, count = 1;
            while (++ pos < sta.length()) {
                if (sta[pos] != sta[pos - 1]) {
                    stb += count + '0';
                    stb += sta[pos - 1];
                    count = 1;
                } else {
                    count += 1;
                }
            }
            stb += count + '0';
            stb += sta[sta.length() - 1];
        }
        return stb;
    }
};