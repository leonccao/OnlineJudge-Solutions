// #include <iostream>
// #include <cstdio>
#include <bits/stdc++.h>
using namespace std;

const int maxn=2e3+5;

struct Circle {
    int x, y, r;
} c[maxn];
vector<pair<double, pair<int,int> > > e;
int fa[maxn];

inline int findfa(int x) {return x==fa[x]?x:fa[x]=findfa(fa[x]);}

int main() {
    // freopen("E.in", "r", stdin);
    int n; scanf("%d", &n);
    for (int i=0; i<n; i++) fa[i]=i;
    int cnt=n-1;
    for (int i=0; i<n; i++) {
        scanf("%d%d%d", &c[i].x, &c[i].y, &c[i].r);
        for (int j=0; j<i; j++) {
            if ((c[i].x-c[j].x)*(c[i].x-c[j].x)+(c[i].y-c[j].y)*(c[i].y-c[j].y)==(c[i].r+c[j].r)*(c[i].r+c[j].r)) {
                int a=findfa(i), b=findfa(j);
                if (a!=b) cnt--;
                fa[a]=b;
            }
            else {
                double d=sqrt((c[i].x-c[j].x)*(c[i].x-c[j].x)+(c[i].y-c[j].y)*(c[i].y-c[j].y));
                // cout << d << endl;
                e.push_back({d-c[i].r-c[j].r, {i, j}});
            }
        }
    }
    sort(e.begin(), e.end());
    double ans=0;
    for (pair<double, pair<int,int> >& p: e) {
        if (!cnt) break;
        double cst=p.first;
        int a=findfa(p.second.first), b=findfa(p.second.second);
        if (a!=b) {
            ans+=cst;
            cnt--;
            fa[a]=b;
        }
    }
    printf("%.8lf\n", ans);
}
