#include<iostream>
#include<string>
#include<vector>
#include<algorithm>

using namespace std;

int calcQ(string s) {
    int cnt = 0;
    for (int i = 0; i < s.length(); i ++)
        if (s[i] == '?')
            cnt ++;
    return cnt;
}

bool cmp(const string& a, const string& b) {
    return calcQ(a) < calcQ(b);
}

void dfs(int cur, int pos, vector<string>& nums, int& ans) {
    if (cur == 2) {
        int a = stoi(nums[0]);
        int b = stoi(nums[1]);
        string c = to_string(a ^ b);
        if (c.length() != nums[2].length()) return;
        for (int i = 0; i < c.length(); i ++)
            if (c[i] != nums[2][i] && nums[2][i] != '?')
                return;
        ans ++;
        return;
    }
    if (pos == nums[cur].length()) {
        cur ++; pos = 0;
    }
    if (nums[cur][pos] != '?') 
        dfs(cur, pos + 1, nums, ans);
    else {
        int base = (pos > 0 || nums[cur].length() == 1) ? 0 : 1;
        for (int i = base; i < 10; i ++) {
            nums[cur][pos] = '0' + i;
            dfs(cur, pos + 1, nums, ans);
        }
        nums[cur][pos] = '?';
    }
}

int main() {
    string s;
    getline(cin, s);
    vector<string> nums;
    nums.push_back(s.substr(0, s.find("xor") - 1));
    nums.push_back(s.substr(s.find("xor") + 4, s.find("=") - s.find("xor") - 5));
    nums.push_back(s.substr(s.find("=") + 2));
    sort(nums.begin(), nums.end(), cmp);

    int ans = 0;
    dfs(0, 0, nums, ans);
    cout << ans << endl;

    return 0;
}
