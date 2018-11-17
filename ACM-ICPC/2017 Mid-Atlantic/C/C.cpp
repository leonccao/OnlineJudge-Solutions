#include<iostream>
#include<cmath>

using namespace std;

int main() {
    string s;
    cin >> s;
    int n = s.length();

    int cur = 0;
    int maxn = 0, minn = 0, maxp = -1, minp = -1;
    int ans = 0, anss = 0, anse = 0;
    for (int i = 0; i < n; i ++) {
        cur += s[i] == 'B' ? 1 : -1;

        int tmp = cur - minn;
        if (tmp > ans || (tmp == ans && (minp < anss || i < anse))) {
            ans = tmp;
            anss = minp;
            anse = i;
        }
        tmp = abs(cur - maxn);
        if (tmp > ans || (tmp == ans && (maxp < anss || i < anse))) {
            ans = tmp;
            anss = maxp;
            anse = i;
        }
        if (cur > maxn) {
            maxn = cur;
            maxp = i;
        }
        if (cur < minn) {
            minn = cur;
            minp = i;
        }
    }
    cout << anss + 2 << ' ' << anse + 1 << endl;

    return 0;
}
