#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long LL;
// typedef long long LL;
const int maxn=40;
const int maxs=100+5;
LL C[maxn][maxn], ans[maxn];

void init() {
	C[0][0]=C[1][0]=C[1][1]=1;
	for (int i=2; i<maxn; i++) {
		C[i][0]=C[i][i]=1;
		for (int j=1; j<i; j++) C[i][j]=C[i-1][j]+C[i-1][j-1];
	}
}

int main() {
	freopen("D.in", "r", stdin);
	init();
	for (int s=2; s<=100; s+=2) {
		int b=s;
		if (s%6) b+=6-s%6;
		b/=6;
		for (; b*4<=s; b++) {
			int a=s/2-2*b;
			// mx=max(mx, a+b);
			ans[s]+=C[a+b][a]*C[a+b][a];
		}
	}
	// for (int s=2; s<=100; s+=2) cout << ans[s] << endl;
	int T; cin >> T;
	while (T--) {
		int id, s; scanf("%d%d", &id, &s);
		// printf("%d %llu\n", id, ans[s]);
		cout << id << ' ' << ans[s] << endl;
		// cout << ans[s] << endl;
	}
}
