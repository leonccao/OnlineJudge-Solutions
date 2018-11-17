#include <iostream>
#include <vector>
#include <cstring>
#include <queue>
#include <algorithm>

#define MAXN 4005
#define INF 100000000

using namespace std;

struct Edge {
    int from, to, cap, flow, cost;
    bool operator < (const Edge& a) {
        return this->from < a.from || (this->from == a.from && this->to < a.to);
    }
};

struct MCMF {
    int n, m, s, t;
    vector<Edge> edges;
    vector<int> G[MAXN];
    int inq[MAXN];
    int d[MAXN];
    int p[MAXN];
    int a[MAXN];

    void init(int n) {
        this->n = n;
        for (int i = 0; i < n; i++) G[i].clear();
        edges.clear();
    }

    void AddEdge(int from, int to, int cap, int cost) {
        edges.push_back((Edge){from, to, cap, 0, cost});
        edges.push_back((Edge){to, from, 0, 0, -cost});
        m = edges.size();
        G[from].push_back(m-2);
        G[to].push_back(m-1);
    }

    bool BellmanFord(int s, int t, int &ans) {
        for (int i = 0; i < n; i++) d[i] = INF;
        memset(inq, 0, sizeof(inq));
        d[s] = 0;
        inq[s] = 1;
        p[s] = 0;
        a[s] = INF;

        queue<int> Q;
        Q.push(s);
        while (!Q.empty()) {
            int u = Q.front(); Q.pop();
            inq[u] = 0;
            for (int i = 0; i < G[u].size(); i++) {
                Edge &e = edges[G[u][i]];
                if (e.cap > e.flow && d[e.to] > d[u] + e.cost) {
                    d[e.to] = d[u] + e.cost;
                    p[e.to] = G[u][i];
                    a[e.to] = min(a[u], e.cap - e.flow);
                    if (!inq[e.to]) {
                        Q.push(e.to);
                        inq[e.to] = 1;
                    }
                }
            }
        }
        cout << "test" << endl;
        if (d[t] > 0) return false;
        ans += (int) d[t] * (int) a[t];
        int u = t;
        while (u != s) {
            edges[p[u]].flow += a[t];
            edges[p[u]^1].flow -=a[t];
            u = edges[p[u]].from;
        }
        return true;
    }

    int Mincost(int s, int t) {
        int cost = 0;
        while (BellmanFord(s, t, cost));
        return cost;
    }
};

int P, R, L;
MCMF mcmf;

int main() {
    cin >> P >> R >> L;
    for (int i = 0; i < L; i++) {
        int x, y;
        cin >> x >> y;
        x += 2; y += 2;
        mcmf.AddEdge(x, y, 1, 1);
        mcmf.AddEdge(y, x, 1, 1);
    }
    int ret = mcmf.Mincost(0, 1);
    cout << mcmf.d[1] << endl;
    return 0;
}
