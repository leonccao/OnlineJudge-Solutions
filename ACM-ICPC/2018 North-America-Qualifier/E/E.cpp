#include <iostream>
#include <cstdio>
#include <cmath>
#include <complex>

#define point complex<double>
using namespace std;

const int maxn=100+5;
const double eps=1e-6;
const double pi=acos(-1);
double x[maxn], y[maxn];

bool ls(double x) {
    return x<1+eps;
}

double len(point p1, point p2) {
    return sqrt((p1.real()-p2.real())*(p1.real()-p2.real())+(p1.imag()-p2.imag())*(p1.imag()-p2.imag()));
}

double dis(point p, point p1, point p2) {
    double x1=p1.real()-p.real(), y1=p1.imag()-p.imag();
    double x2=p2.real()-p.real(), y2=p2.imag()-p.imag();
    return fabs(x1*y2-x2*y1)/(len(p1, p2));
}

int main() {
    int n; scanf("%d", &n);
    for (int i=0; i<n; i++) scanf("%lf%lf", x+i, y+i);
    int ans=1;
    for (int i=0; i<n; i++) for (int j=i+1; j<n; j++) {
        int cnt[4]={};
        if (abs(x[i]-x[j])<eps) {
            for (int k=0; k<n; k++) {
                if (ls(abs(x[k]-x[i]-1))) cnt[0]++;
                if (ls(abs(x[k]-x[i]+1))) cnt[1]++;
            } 
        }
        else {
            double K=(y[j]-y[i])/(x[j]-x[i]);
            double B1=y[i]-K*x[i]-K/sqrt(K*K+1);
            double B2=y[i]-K*x[i]+K/sqrt(K*K+1);
            for (int k=0; k<n; k++) {
                double dis1=abs(K*x[k]-y[k]+B1)/sqrt(K*K+1);
                double dis2=abs(K*x[k]-y[k]+B2)/sqrt(K*K+1);
                if (ls(dis1)) cnt[0]++;
                if (ls(dis2)) cnt[1]++;
            }
        }
        
        point c1={x[i], y[i]}, c2={x[j], y[j]};
        double d=len(c1, c2);
        double a=arg(c2-c1), b=acos(2./d);
        double a1=remainder(a-b, 2*pi), a2=remainder(a+b, 2*pi);
        point p1=c1+point{cos(a1), sin(a1)}, p2=c2+point{cos(a2), sin(a2)};
        point mid=(c1+c2)/2.;
        for (int k=0; k<n; k++) {
            point p3={x[k], y[k]};
            if (len(p3, p1)<eps||len(p3, p2)<eps) {
                cnt[2]++, cnt[3]++; continue;
            }
            if (ls(dis(p3, mid, p1))) cnt[2]++;
            if (ls(dis(p3, mid, p2))) cnt[3]++;
        }

        for (int k=0; k<4; k++) ans=max(ans, cnt[k]);
    }
    printf("%d\n", ans);
}