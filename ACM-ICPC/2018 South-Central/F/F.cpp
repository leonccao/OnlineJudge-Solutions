#include <string>
#include <iostream>
#include <vector>
#include <map>
using namespace std;

int T, n;
vector<string> s;
vector<int> cnt;

int main() {
    cin >> T;
    while (T--) {
        cin >> n;
        s.clear();
        cnt.clear();
        for (int i = 0; i < n; i++) {
            string tmps;
            int tmpn;
            bool flag = false;
            cin >> tmps >> tmpn;
            for (int i = 0; i < s.size(); i++)
                if (tmps == s[i]) {
                    flag = true;
                    cnt[i] += tmpn;
                }
            if (!flag) {
                s.push_back(tmps);
                cnt.push_back(tmpn);
            }
        }
        for (int i = 0; i < s.size(); i++)
            for (int j = i + 1; j < s.size(); j++)
                if ((cnt[i] < cnt[j]) || (cnt[i] == cnt[j] && s[i] > s[j])) {
                    int tmp = cnt[i];
                    cnt[i] = cnt[j];
                    cnt[j] = tmp;
                    string ss = s[i];
                    s[i] = s[j];
                    s[j] = ss;
                }
        cout << s.size() << endl;
        for (int i = 0; i < s.size(); i++)
            cout << s[i] << ' ' << cnt[i] << endl;
    }
return 0;
}
