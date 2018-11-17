#include <iostream>
#include <cstring>
#define MOD 1001113
using namespace std;

int P, k, n, v;
long long dp[105][105];

double simpson(double a, double b) {
	double c=a+(b-a)/2;
	return (F(a)+4*F(c)+F(b))*(b-a)/6.;
}

double asr(double a, double b, double eps, double A) {
	double c=a+(b-a)/2;
	double L=simpson(a, c), R=simpson(c, b);
	if (fabs(L+R-A)<=15*eps)
}
int main() {
	

	return 0;
}
