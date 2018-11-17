#include <iostream>
#include <cmath>
using namespace std;

int P, k, m;
double x;
bool finished;

int gcd(int a, int b) {
	return b == 0 ? a : gcd(b, a % b);
}

int main() {
	cin >> P;
	while (P--) {
		cin >> k >> m >> x;
		if (x < 1.0 / m) {
			cout << k << ' ' << 1 << '/' << m << endl;
			continue;
		}
		int bestq = m / 2;
		int bestp = int((double) bestq * (double) x + 0.5);
		double besterr = fabs((double) bestp / (double) bestq - x);
		
		for (int q = bestq + 1; q <= m; q++) {
			int p = int((double) q * x + 0.5);
			double err = fabs((double)p / (double) q - x);
			if (err < besterr) {
				bestp = p;
				bestq = q;
				besterr = err;
			}
		}
		
		int tmp = gcd(bestp, bestq);
		bestp /= tmp;
		bestq /= tmp;
		cout << k << ' ' << bestp << '/' << bestq << endl;
		
	}
	return 0;
}
