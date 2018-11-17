#include <bits/stdc++.h>

using namespace std;

int p, r, l;

const int maxn=1000+10;
vector<int> e[maxn];
bool vis[maxn];
int fa[maxn];
void era(int x, int y) {
    for (auto it=e[x].begin(); it!=e[x].end(); it++) {
        if (*it==y) {
            e[x].erase(it); return;
        }
    }
}
int bfs() {
    memset(vis, 0, sizeof(vis));
    queue<int> q;
    q.push(r); vis[r]=true; fa[r]=-1;
    bool ok=false;
    while (!q.empty()) {
        int u=q.front(); q.pop();
        if (u==r+1) {
            ok=true;
            break;
        }
        for (int v: e[u]) if (!vis[v]) {
            vis[v]=true; fa[v]=u; q.push(v);
        }
    }
    if (!ok) return -1;
    else {
        int x=r+1, len=0;
        while (x!=-1) {
            int y=fa[x];
            len++;
            if (y!=-1) {
                era(x, y); era(y, x);
            }
            x=y;
        }
        return len-1;
    }
}

void work(int& x) {
    if (x==-2) x=r;
    else if (x==-1) x=r+1;
}

int main() {
    scanf("%d%d%d", &p, &r, &l);
    for (int i=0; i<l; i++) {
        int a, b; scanf("%d%d", &a, &b);
        work(a); work(b);
        e[a].push_back(b);
        e[b].push_back(a);
    }
    int ans=0;
    while (p--) {
        int ret=bfs();
        if (ret==-1) {
            printf("%d people left behind\n", p+1); return 0;
        }
        else ans+=ret;
    }
    printf("%d\n", ans);
}
