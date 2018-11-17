#include <iostream>
#include <vector>
#include <string>
#include <cmath>
using namespace std;

int l, w;
int offset[15], interval[15], speed[15];
int mod[15];
int pos;
string mov;
int car[15][25];
int numcar[15];

bool safeornot(int lanepos, int pos, int t) {
    int tmpcar1[25], tmpcar2[25];
    for (int i = 0; i < numcar[lanepos]; i++) {
        tmpcar1[i] = (car[lanepos][i] + (t - 1) * (mod[lanepos] + speed[lanepos])) % mod[lanepos];
    }
    for (int i = 0; i < numcar[lanepos]; i++) {
        tmpcar2[i] = (car[lanepos][i] + t * (mod[lanepos] + speed[lanepos])) % mod[lanepos];
    }
    for (int i = 0; i < numcar[lanepos]; i++) {
        if (pos > tmpcar1[i] && pos <= tmpcar2[i])
            return false;
    }
    return true;
}

int main() {
    cin >> l >> w;
    bool positive = (l % 2 == 1);
    for (int i = 0; i < l; i++) {
        cin >> offset[l - i] >> interval[l - i] >> speed[l - i];
        if (!positive) {
            speed[l - i] = -speed[l - i];
        }
        positive = !positive;
    }
    cin >> pos >> mov;

    for (int i = 1; i <= l; i++) {
        mod[i] = interval[i] * ( 1 + floor(w * 1.0 / interval[i]));
        car[i][0] = offset[i];
        numcar[i] = 1;
        int p = (offset[i] + interval[i]) % mod[i];
        while (p != offset[i]) {
            car[i][numcar[i]] = p;
            numcar[i]++;
            p = (p + interval[i]) % mod[i];
            //cout << i << endl;
        }
    }
    // for (int i = 1; i <= l; i++) {
    //     cout << i << ": ";
    //     for (int j = 0; j < numcar[i]; j++)
    //         cout << car[i][j] << ' ';
    //     cout << endl;
    // }
    bool reach = false;
    int startpos = pos;
    {
        bool squish = false;
        int lanepos = 0;
        int pos = startpos;
        for (int t = 0; t < mov.size() && !squish; t++) {
            switch (mov[t]) {
                case 'L': {
                    int nextpos = (pos - 1 + w) % w;
                    if (lanepos == 0) {
                        pos = nextpos;
                        continue;
                    }
                    if ((speed[lanepos] < 0 || safeornot(lanepos, pos, t + 1)) && safeornot(lanepos, nextpos, t + 1)) {
                        pos = nextpos;
                        continue;
                    } else {
                        squish = true;
                        break;
                    }
                    break;
                }
                case 'R': {
                    int nextpos = (pos + 1) % w;
                    if (lanepos == 0) {
                        pos = nextpos;
                        continue;
                    }
                    if ((speed[lanepos] > 0 || safeornot(lanepos, pos, t + 1)) && safeornot(lanepos, nextpos, t + 1)) {
                        pos = nextpos;
                        continue;
                    } else {
                        squish = true;
                        break;
                    }
                    break;
                }
                case 'U': {
                    if (safeornot(lanepos + 1, pos, t + 1)) {
                        lanepos++;
                    } else {
                        squish = true;
                        break;
                    }
                    break;
                }
                case 'D': {
                    if (lanepos == 0)
                        continue;
                    if (safeornot(lanepos - 1, pos, t + 1)) {
                        lanepos--;
                    } else {
                        squish = true;
                        break;
                    }
                    break;
                }
            }
            if (squish)
                break;
            if (lanepos == l + 1) {
                reach = true;
                break;
            }
        }
    }
    if (reach)
        cout << "safe" << endl;
    else
        cout << "squish" << endl;
    

    return 0;
}