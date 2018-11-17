#include <iostream>
#include <algorithm>
#include <cstring>

using namespace std;

int P, K, n, num[1005], num_c[1005];

int main() {
	cin >> P;
	while (P--) {
		cin >> K;
		cout << K;
		cin >> n;
		memset(num, 0, sizeof num);
		memset(num_c, 0, sizeof num_c);
		for (int i = 0; i < n; i++) {
			cin >> num[i];
			num_c[i] = num[i];
		}
		sort(num_c, num_c + n);
		int p = 0;
		int ans = 0;
		for (int i = 0; i < n; i++) {
			if (num[i] != num_c[p])
				ans++;
			else {
				p++;
			}
		}
		cout << ' ' << ans << endl;
	}

	return 0;
}
