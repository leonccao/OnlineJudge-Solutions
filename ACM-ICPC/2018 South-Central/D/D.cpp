#include <bits/stdc++.h>
using namespace std;

const int maxn=100+5;
const int maxg=2e5+5;
const int INF=1e9+10;
typedef long long LL;
struct Edge {
    int to, cst;
};
vector<Edge> e[maxn];
vector<int> sp[maxn];
bool vis[maxn];

void SPFA(int start, vector<int>& t) {
    for (int& i: t) i=INF;
    memset(vis, 0, sizeof(vis));
    t[start]=0; vis[start]=true;
    queue<int> q; q.push(start);
    while (!q.empty()) {
        int u=q.front(); q.pop();
        vis[u]=false;
        for (Edge& E: e[u]) {
            if (t[E.to]>t[u]+E.cst) {
                t[E.to]=t[u]+E.cst;
                if (!vis[E.to]) {
                    q.push(E.to); vis[E.to]=true;
                }
            }
        }
    }
}

struct Gig{
    int v, st, ed, m;
} gg[maxg];
inline bool cmp(Gig a, Gig b) {
    return a.ed<b.ed;
}
set<pair<int,LL>> val[maxn];

int main() {
    freopen("D.in", "r", stdin);
    int g, k, r;
    scanf("%d%d%d", &g, &k, &r);
    for (int i=0; i<r; i++) {
        int a, b, t;
        scanf("%d%d%d", &a, &b, &t);
        e[a].push_back({b, t});
        e[b].push_back({a, t});
    }
    for (int i=1; i<=k; i++) {
        sp[i].resize(k+1);
        SPFA(i, sp[i]);
        // for (int j=1; j<=k; j++) cout << sp[i][j] << ' '; cout << endl;
    }
    for (int i=0; i<g; i++) {
        scanf("%d%d%d%d", &gg[i].v, &gg[i].st, &gg[i].ed, &gg[i].m);
    }
    sort(gg, gg+g, cmp);
    LL ans=0;
    val[1].insert({0,0});
    for (int kkk=0; kkk<g; kkk++) {
        Gig& gig=gg[kkk];
        LL mx=-1;
        for (int i=1; i<=k; i++) if (sp[gig.v][i]!=INF) {
            if (!val[i].empty()) {
                auto it=val[i].upper_bound({gig.st-sp[gig.v][i], LONG_LONG_MAX});
                if (it!=val[i].begin()) {
                    it--;
                    mx=max(it->second+gig.m, mx);
                }
            }
        }
        if (mx==-1) continue;
        ans=max(ans, mx);
        if (val[gig.v].empty()) val[gig.v].insert({gig.ed, mx});
        else {
            auto it=val[gig.v].end();
            it--;
            if (it->first==gig.ed) {
                if (it->second<mx) {
                    val[gig.v].erase(it);
                    val[gig.v].insert({gig.ed, mx});
                }
            }
            else if (it->second<mx) val[gig.v].insert({gig.ed, mx});
        }
    }
    printf("%lld\n", ans);
}
