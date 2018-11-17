#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long LL;
const int maxn=30+5;
LL dp[maxn];

int main() {
	freopen("G.in", "r", stdin);
	int T; scanf("%d", &T);
	while (T--) {
		int id, k, n, m;
		scanf("%d%d%d%d", &id, &n, &m, &k);
		memset(dp, 0, sizeof(dp));
		dp[0]=1;
		for (int i=1; i<=n; i++) {
			for (int j=1; j<=i; j++) {
				if (j>=m&&(j-m)%k==0) {}
				else {
					// cout << j << endl;
					dp[i]+=dp[i-j];
				}
			}
			// cout << i << ' '<< dp[i] << endl;
		}
		printf("%d %llu\n", id, dp[n]);
	}
}
