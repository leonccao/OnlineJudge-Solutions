#include <iostream>
#include <cstring>
#include <queue>
#define MAXN 2505
#define MAXE 2505 * 2505
using namespace std;


int n;
bool g[MAXN][MAXN];

struct Edge {
	int to, next;
}edge[MAXE];
int head[MAXN], tot;
int Low[MAXN], DFN[MAXN], Stack[MAXN], Belong[MAXN];
int Index, top, scc;
bool Instack[MAXN];
int num[MAXN];

bool g2[MAXN][MAXN];

void addedge(int u, int v) {
	edge[tot].to = v;
	edge[tot].next = head[u];
	head[u] = tot++;
}

vector<int> e2[MAXN];

void Tarjan(int u) {
	int v;
	Low[u] = DFN[u] = ++Index;
	Stack[top++] = u;
	Instack[u] = true;
	for (int i = head[u]; i != -1; i = edge[i].next) {
		v = edge[i].to;
		if (!DFN[v]) {
			Tarjan(v);
			if (Low[u] > Low[v]) Low[u] = Low[v];
		} else if (Instack[v] && Low[u] > DFN[v])
			Low[u] = DFN[v];
	}
	if (Low[u] == DFN[u]) {
		scc++;
		do {
			v = Stack[--top]; 
			Instack[v] = false;
			Belong[v] = scc;
			num[scc]++;
		} while (v != u);
	}
}

void solve(int N) {
	memset(DFN, 0, sizeof(DFN));
	memset(Instack, false, sizeof(Instack));
	memset(num, 0, sizeof(num));
	Index = scc = top = 0;
	for (int i = 1; i <= N; i++)
		if (!DFN[i]) Tarjan(i);
}

void init() {
	tot = 0;
	memset(head, -1, sizeof(head));
}

int reach[MAXN];
int enumber;

int bfs(int p) {
	queue<int> q;
	bool vis[MAXN];
	memset(vis, false, sizeof(vis));
	int number = 0;
	
	
	q.push(p);
	vis[p] = true;
	
	while (!q.empty()) {
		int node = q.front();
		q.pop();
		number += num[node];
		for (int i = 0; i < e2[node].size(); i++) {
			if (!vis[e2[node][i]]) {
				vis[e2[node][i]] = true;
				q.push(e2[node][i]);
			}
		}
	}
	
	return number;
}

int main() {
	init();
	cin >> n;
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++) {
			int tmp;
			cin >> tmp;
			if (tmp == 1) {
				enumber++;
				g[i][j] = true;
				addedge(i, j);
			} else {
				g[i][j] = false;
			}
		}
	solve(n);
//	cout << scc << endl;
//	for (int i = 1; i <= scc; i++)
//		cout << num[i] << endl;
//	for (int i = 1; i <= n; i++)
//		cout << Belong[i] << ' ';
	
	for (int i = 1; i <= n; i++)
		for (int j = 1; j <= n; j++)
			if (g[i][j]) {
				g2[Belong[i]][Belong[j]] = true;
			}
	for (int i = 1; i <= scc; i++)
		for (int j = 1; j <= scc; j++)
			if (g2[i][j]) {
				e2[i].push_back(j);
			}
	
	for (int i = 1; i <= scc; i++) {
		reach[i] = bfs(i);
		//cout << reach[i] << ' ' << num[i] << endl;
	}
	
	int ans = 0;
	for (int i = 1; i <= scc; i++) {
		ans += (reach[i] - 1) * num[i];
	}
	cout << ans - enumber << endl;
	return 0;
}
