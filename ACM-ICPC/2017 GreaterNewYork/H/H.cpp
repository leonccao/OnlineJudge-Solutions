#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

int P, k;

double dist(double x1, double y1, double x2, double y2) {
	return sqrt((x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2));
}

double Ax, Ay, Bx, By, Cx, Cy;

int main() {
	cin >> P;
	while (P--) {
		cin >> k;
		Ax = 0; Ay = 0;
		cin >> Bx; By = 0;
		cin >> Cx >> Cy;
		double S = Cy * Bx;
		
		double AC = dist(Ax, Ay, Cx, Cy);
		double AB = dist(Ax, Ay, Bx, By);
		double BC = dist(Bx, By, Cx, Cy);
		double Ix = (AC + AB - BC) / 2.0;
		double Iy = S / (AB + AC + BC);
		
		double AI = dist(Ax, Ay, Ix, Iy);
		double BI = dist(Bx, By, Ix, Iy);
		double CI = dist(Cx, Cy, Ix, Iy);
		
		double a = sqrt(AI * AI - Iy * Iy);
		double b = sqrt(BI * BI - Iy * Iy);
		double c = sqrt(CI * CI - Iy * Iy);
		
		double EF = Iy * AI / a;
		double AE = AI * AI / (2 * a);
		double AF = AE;
		
		double GH = Iy * CI / c;
		double CG = CI * CI / (2 * c);
		double CH = CG;
		
		double KJ = Iy * BI / b;
		double BJ = BI * BI / (2 * b);
		double BK = BJ;
		
		double FG = AC - AF - CG;
		double HJ = BC - BJ - CH;
		double KE = AB - AE - BK;
		
		printf("%d %.4lf %.4lf %.4lf %.4lf %.4lf %.4lf\n",
			k, EF, FG, GH, HJ, KJ, KE);
	
	}
	return 0;
}
