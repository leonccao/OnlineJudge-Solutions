#include <iostream>
#include <unordered_set>
using namespace std;

int n, card[3005][5][5];
unordered_set<int> s[3005];

int main() {
    cin >> n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 5; j++)
            for (int k = 0; k < 5; k++) {
                cin >> card[i][j][k];
                s[i].insert(card[i][j][k]);
            }
    }

    bool tie = false;
    for (int i = 0; i < n && !tie; i ++)
        for (int j = i+1; j < n && !tie; j++) {
            for (int p = 0; p < 5 && !tie; p++)
                for (int q = 0; q < 5 && !tie; q++)
                    if (s[j].find(card[i][p][q]) != s[j].end()) {
                        tie = true;
                        cout << i+1 << ' ' << j+1 << endl;
                        break;
                    }
        }
    if (!tie)
        cout << "no ties" << endl;

    return 0;
}