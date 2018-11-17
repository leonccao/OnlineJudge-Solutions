#include <bits/stdc++.h>

using namespace std;

typedef long long LL;
const int maxn=200+5;
LL dp[maxn][2][4];

inline void ad(int i1, int j1, int k1, int i2, int j2, bool two) {
	dp[i1][j1][k1]+=(two?2:1)*dp[i2][j2][0];
	// if (i1==2&&j1==0&&k1==2) cout << two << ' ' << i2 << ' ' << j2 << ' ' << 0 << endl;
}
inline void add(int i1, int j1, int k1, int i2, int j2, int k2, bool two) {
	dp[i1][j1][k1]+=(two?2:1)*dp[i2][j2][k2];
	// if (i1==2&&j1==0&&k1==2) cout << two << ' ' << i2 << ' ' << j2 << ' ' << k2 << endl;
}
inline void ada(int i1, int j1, int i2, int j2, bool two) {
	for (int k=0; k<4; k++) add(i1, j1, k, i2, j2, k, two);
}

/*
0 0 0 1
0 0 1 0
0 0 2 0
0 0 3 0
0 1 0 0
0 1 1 0
0 1 2 0
0 1 3 0
1 0 0 3
1 0 1 5
1 0 2 1
1 0 3 0
1 1 0 1
1 1 1 1
1 1 2 0
1 1 3 0
2 0 0 18
2 0 1 47
2 0 2 13
2 0 3 4
2 1 0 5
2 1 1 9
2 1 2 2
2 1 3 1

*/
void init() {
	dp[0][0][0]=1;
	for (int i=1; ; i++) {
		ada(i, 0, i-1, 1, true);
		ad(i, 0, 3, i-1, 1, true);
		
		ada(i, 1, i-1, 1, false);
		ad(i, 1, 2, i-1, 1, false);
		
		ada(i, 1, i-1, 0, false);
		ad(i, 1, 1, i-1, 0, false);
		
		ada(i, 0, i-1, 0, false);
		ad(i, 0, 2, i-1, 0, false);
		
		if (i>1) {
			ada(i, 1, i-2, 0, false);
			ad(i, 1, 3, i-2, 0, false);
			
			ada(i, 0, i-2, 0, false);
			ad(i, 0, 2, i-2, 0, true);
		}
		
		ada(i, 0, i, 1, true);
		ad(i, 0, 1, i, 1, true);
		for (int k=0; k<4; k++) dp[i][0][k]-=dp[i-1][0][k];
		dp[i][0][1]-=(2*dp[i-1][0][0]);
		
		if (dp[i][0][0]>UINT_MAX) {
			// cout << i << endl;
			break; 
		}
	}
}

int main() {
	freopen("D.in", "r", stdin);
	int T; cin >> T;
	init();
	// for (int i=0; i<=2; i++) for (int j=0; j<2; j++)
		// for (int k=0; k<4; k++) printf("%d %d %d %lld\n", i, j, k, dp[i][j][k]);
	while (T--) {
		int k, n; scanf("%d%d", &k, &n);
		printf("%d ", k);
		if (n) {
			for (int i=0; i<4; i++) printf("%lld%c", dp[n][0][i], i==3?'\n':' ');
		}
		else {
			for (int i=0; i<4; i++) printf("%lld%c", 0, i==3?'\n':' ');
		}
	}
}
