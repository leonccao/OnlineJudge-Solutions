#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long LL;
const LL MOD=1e9;

struct Matrix {
	LL g[2][2];
};

Matrix multi(Matrix a, Matrix b) {
	Matrix ret;
	memset(ret.g, 0, sizeof(ret.g));
	for (int i=0; i<2; i++)
	for (int j=0; j<2; j++)
	for (int k=0; k<2; k++) {
		ret.g[i][j]+=a.g[i][k]*b.g[k][j];
		ret.g[i][j]%=MOD;
	}
	return ret;
}

LL np(LL y) {
	Matrix ans, x;
	memset(ans.g, 0, sizeof(ans.g));
	ans.g[0][0]=ans.g[1][1]=1;
	x.g[0][0]=x.g[0][1]=x.g[1][0]=1;
	x.g[1][1]=0;	
	while (y) {
		if (y&1) ans=multi(ans, x);
		x=multi(x,x);
		y>>=1;
	}
	return ans.g[0][0];
}
int main() {
	int T; scanf("%d", &T);
	while (T--) {
		int id;
		LL y; scanf("%d %llu", &id, &y);
		y--;
		printf("%d %llu\n", id, np(y));
	}
}
