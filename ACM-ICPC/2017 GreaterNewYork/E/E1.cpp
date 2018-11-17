#include <iostream>
#include <cmath>
#include <cstdio>
using namespace std;

int P, K, m;
double x;
double p1, q1, p2, q2;
double ans, solved, ansp, ansq;

int gcd(int a, int b) {
	return b == 0 ? a : gcd(b, a % b);
}

int main() {
	cin >> P;
	while (P--) {
		scanf("%d%d%lf", &K, &m, &x);
		if (x < 1.0 / m) {
			cout << 1 << '/' << m << endl;
			continue;
		}
		solved = false;
		
		q1 = m;
		q2 = m;
		p1 = floor(m * x);
		p2 = ceil(m * x);
		if (p1 == p2) {
			int tmp = gcd((int)p1, (int)m);
			p1 /= tmp;
			m /= tmp;
			printf("%d/%d\n", (int)p1, (int)m);
			continue;
		}
		ans = 1.0;
		ansp = -1.0;
		ansq = -1.0;
		
		p2 = p1;
		while (p2 / q2 < x) q2--;

		while (1) {
			//cout << 'l' << (int)p1 << '/' << (int) q1 << ' ';
			//cout << 'r' << (int)p2 << '/' << (int) q2 << endl;
			bool update = false;
			double newp1, newp2, newq1, newq2;
			newp1 = p1 - 1;
			newq1 = ceil(newp1 / p1 * q1);
			newp2 = p2 - 1;
			newq2 = floor(newp2 / p2 * q2);
			p1 = newp1; p2 = newp2; q1 = newq1; q2 = newq2;
			if (q1 <= q2 + 1) {
				break;
			}
			double i, j;
			for (i = q1; p1 / (i - 1) < x; i-=1);
			for (j = q2; p2 / (j + 1) > x; j+=1);
			//cout << i << ' ' << j << endl;
			if (i <= j) {
				break;
			}
			q1 = i; q2 = j;
			if (fabs(p1 / q1 - x) < ans) {
				ans = fabs(p1 / q1 - x);
				ansp = p1;	
				ansq = q1;
				update = true;
			}
			if (fabs(p2 / q2 - x) < ans) {
				ans = fabs(p2 / q2 - x);
				ansp = p2;
				ansq = q2;
				update = true;
			}
			//if (!update)
				//break;
		}
		if (!solved) {
			int tmp = gcd((int)ansp, (int)ansq);	
			ansp /= (double) tmp;
			ansq /= (double) tmp;
			printf("%d %d/%d\n", K, (int)ansp, (int)ansq);
		}
	}
		
	return 0;
}
