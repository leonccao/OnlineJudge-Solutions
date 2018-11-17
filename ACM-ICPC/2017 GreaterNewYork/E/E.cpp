#include<bits/stdc++.h>

using namespace std;

int euler_phi(int n) {
	int m=(int)sqrt(n+0.5);
	int ans=n;
	for (int i=2; i<=m; i++) if (n%i==0) {
		ans=ans/i*(i-1);
		while (n%i==0) n/=i;
	}
	if (n>1) ans=ans/n*(n-1);
	cout << ans << endl;
	return ans;
}
int main() {
	double x=.141592653589793238;
	int M=255;
	double ans=1e9; int pos;
	for (int i=1; i<=M; i++) {
		int j=ceil(x*i);
		// double mn=min(abs((double)j/i-x), abs((double)(j+1)/i-x));
		double mn=abs((double)j/i-x);
		if (mn<ans) {ans=mn; pos=i;}
		cout << mn << endl;		
	}
	cout << pos << endl;
	cout << 15*.141592653589793238 << endl;
}
