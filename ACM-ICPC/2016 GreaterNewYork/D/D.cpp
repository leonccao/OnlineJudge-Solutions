#include <iostream>

using namespace std;

int P, k;
long long v;

int main() {
	cin >> P;
	while (P--) {
		cin >> k >> v;
		long long t = (long long)1 << 31;
		for (; t != 0; t >>=1) {
			if ((t & v) != 0)
				break;
		}
//		cout << t << endl;
		long long a = 1, b = 1;
		for (t >>= 1; t; t >>=1 ) {
			//cout << 'd' <<  t << endl;
			if ((t & v) > 0)
				a = a + b;
			else
				b = a + b;
		}
		cout << k << ' ' << a << '/' << b << endl;
		
	}
	return 0;
}
