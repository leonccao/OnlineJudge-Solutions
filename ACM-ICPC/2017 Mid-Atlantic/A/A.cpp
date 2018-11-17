#include<iostream>
#include<vector>

using namespace std;

int main() {
    int n;
    cin >> n;

    vector<vector<int> > ans;

    for (int i = 2; i <= (n + 1) / 2; i ++) {
        int j = i - 1;
        if (n % (i + j) == 0 || (n - i) % (i + j) == 0) {
            ans.push_back(vector<int>());
            ans[ans.size() - 1].push_back(i);
            ans[ans.size() - 1].push_back(j);
        }
        j = i;
        if (n % (i + j) == 0 || (n - i) % (i + j) == 0) {
            ans.push_back(vector<int>());
            ans[ans.size() - 1].push_back(i);
            ans[ans.size() - 1].push_back(j);
        }
    }

    cout << n << ":" << endl;
    for (int i = 0; i < ans.size(); i ++)
        cout << ans[i][0] << "," << ans[i][1] << endl;

    return 0;
}
