#include <iostream>
using namespace std;

int gcd(int a, int b) {
    return b == 0 ? a : gcd(b, a % b);
}

int main() {
    int p, q, s;

    cin >> p >> q >> s;
    int tmp = gcd(p, q);
    tmp = p * q / tmp;
    if (tmp > s)
        cout << "no" << endl;
    else 
        cout << "yes" << endl;
    return 0;
}