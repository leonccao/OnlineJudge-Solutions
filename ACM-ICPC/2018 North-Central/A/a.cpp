#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <cstring>
#include <queue>
#include <string>
#include <set>
#include <unordered_set>

using namespace std;

const int maxn=2e5;
string s[maxn];
int id[maxn], r[maxn][16]; // r[i] prefix length after i

int n, q;
void rmq() {
    for (int k=1; (1<<k)<=n; k++) {
        for (int i=0; i+(1<<k)-1<n; i++) {
            r[i][k]=min(r[i][k-1], r[i+(1<<(k-1))][k-1]);
        }
    }
}
int query(int i, int j) {
    int k=0;
    while ((1<<(k+1))<=(j-i+1)) k++;
    return min(r[i][k], r[j-(1<<k)+1][k]);
}

bool cmp(int i, int j) {return id[i]<id[j];}

int main() {
	std::ios::sync_with_stdio(false);
    std::cin.tie(0);
	// freopen("untitled.in", "r", stdin);
  cin >> n >> q;
  vector<pair<string,int>> v;
  for (int i=0; i<n; i++) {
      cin >> s[i];
      v.push_back({s[i],i});
  }
  sort(v.begin(), v.end());
  for (int i=0; i<v.size(); i++) id[v[i].second]=i;
  for (int i=0; i<v.size()-1; i++) {
      for (int j=0; j<min(v[i].first.size(), v[i+1].first.size()); j++) {
          if (v[i].first[j]==v[i+1].first[j]) r[i][0]++;
          else break;
      }
  }
  rmq();
  while (q--) {
      int k, l, ans=0;
      cin >> k >> l;
      vector<int> g, f;
      for (int j=0; j<k; j++) {
          int tmp; cin >> tmp; g.push_back(tmp-1);
      }
      sort(g.begin(), g.end(), cmp);
      multiset<int> ms;
      for (int i=0; i+1<g.size(); i++) f.push_back(query(id[g[i]], id[g[i+1]]-1));
      // for (int i: f) cout << i << endl;
        if (g.size()<l) ans=0;
        else if (l==1) {
            for (int i=0; i<g.size(); i++) {
                int mx=0;
                if (i) mx=max(f[i-1], mx);
                if (i<f.size()) mx=max(f[i], mx);
                ans+=s[g[i]].size()-mx;
            }
        }
      else {
          for (int i=0, j=-1; i+l-1<=f.size(); i++) {
              if (i) {
              	auto it=ms.find(f[i-1]);
              	ms.erase(it);
              }
          	  while (j-i+1<l-1) ms.insert(f[++j]);
          	  auto it=ms.begin();
              int minn=*it, mx=0;
              // cout << minn << endl;
              if (i) mx=max(f[i-1], mx);
              if (j+1<f.size()) mx=max(f[j+1], mx);
              ans+=max(minn-mx, 0);
          }
      }
      cout << ans << endl;
  }
}
