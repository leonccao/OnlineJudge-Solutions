#include <iostream>
using namespace std;

long long n, x, y;

long long abs(long long a, long long b) {
    if (a > b)
        return a - b;
    else
        return b - a;
}

int xflip, yflip;

int main() {
    cin >> n;
    for (int i = 0; i < n; i ++) {
        cin >> x >> y;
        xflip = 0;
        yflip = 0;
        while (abs(x, y) > 1) {
            if (x > y) {
                long long t = 1;
                while (t - 1 < x) {
                    t *= 2;
                }
                x = t - 1 - x;
                xflip = 1 - xflip;
            } else {
                long long t = 1;
                while (t - 1 < y) {
                    t *= 2;
                }
                y = t - 1 - y;
                yflip = 1 - yflip;
            }
        }
        if (!xflip && !yflip)
            cout << 0 << endl;
        if (xflip && !yflip)
            cout << 3 << endl;
        if (xflip && yflip)
            cout << 2 << endl;
        if (!xflip && yflip)
            cout << 1 << endl;
    }

    return 0;
}
