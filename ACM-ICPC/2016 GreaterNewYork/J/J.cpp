#include <bits/stdc++.h>

using namespace std;

double bx, cx, cy, l;
double aa, bb, cc; ////// ellipse
const double pi=acos(-1);
const double EPS=1e-6;

double F(int x) {
	// cout << x << ' ' << a << ' ' << b << endl;
	return sqrt((1-x*x/aa/aa)*bb*bb);
}

double simpson(double a, double b) {
	double c=a+(b-a)/2;
	return (F(a)+4*F(c)+F(b))*(b-a)/6.;
}

double asr(double a, double b, double eps, double A) {
	double c=a+(b-a)/2;
	double L=simpson(a, c), R=simpson(c, b);
	if (fabs(L+R-A)<=15*eps) return L+R+(L+R-A)/15.;
	return asr(a, c, eps/2, L)+asr(c, b, eps/2, R);
}

double asr(double a, double b, double eps) {
	return asr(a, b, eps, simpson(a, b));
}

double work(double len, double A, double B) {
	double alpha=pi-A/2, beta=pi-B/2;
	aa=len/2, cc=l/2;
	bb=sqrt(cc*cc-aa*aa);
	double x2=-4*bb*bb/(2*aa*cos(beta)-4*cc);
	double x1=-4*bb*bb/(2*aa*cos(alpha)-4*cc);
	x1=-aa-x1*cos(A/2); x2=aa+x2*cos(B/2);
	cout << x1 << ' ' << x2 <<  ' ' << aa << ' ' << bb << endl;
	return asr(x1, x2, EPS);
}

int main() {
	freopen("J.in", "r", stdin);
	int T; cin >> T;
	while (T--) {
		int id;
		scanf("%d%lf%lf%lf%lf", &id, &bx, &cx, &cy, &l);
		double ab=bx;
		double ac=sqrt(cx*cx+cy*cy);
		double bc=sqrt((cx-bx)*(cx-bx)+cy*cy);
		double A=acos((ab*ab+ac*ac-bc*bc)/2./ab/ac);
		double B=acos((ab*ab+bc*bc-ac*ac)/2./ab/bc);
		double C=pi-A-B;
		double ans=0;
		ans=work(ab, A, B)+work(ac, C, A)+work(bc, B, C);
		printf("%d %.6lf\n", id, ans);
	}
	return 0;
}
// -5.7528 6.87162 2 6.18466

