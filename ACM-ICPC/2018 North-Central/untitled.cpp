#include <cstdio>
#include <iostream>
#include <algorithm>
#include <cmath>
#include <vector>
#include <cstring>
#include <queue>
#include <string>
#include <set>

using namespace std;

const int maxn=2e5;
string s[maxn];
int id[maxn], r[maxn][15];
// r[i] prefix length after i
int n, q;
void rmq() {
    for (int k=0; (1<<k)<=n; k++) {
        for (int i=0; i+(1<<k)<n; i++) {
            r[i][k+1]=min(r[i][k], r[i+(1<<k)][k]);
        }
    }
}
int query(int i, int j) {
    int k=0;
    while ((1<<k)<(j-i+1)) k++; k--;
    return min(r[i][k], r[j-(1<<k)+1][k]);
}

bool cmp(int i, int j) {return id[i]<id[j];}
int main() {
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
  int ans=0;
  for (int i=0; i<q; i++) {
      int k, l;
      cin >> k >> l;
      vector<int> g, f;
      for (int i=0; i<k; i++) {
          int tmp; cin >> tmp; g.push_back(tmp);
      }
      sort(g.begin(), g.end(), cmp);
      multiset<int> s;
      for (int i=0; i+1<g.size(); i++) f.push_back(query(id[g[i]], id[g[i+1]]));
      if (g.size()<=l) ans=1;
      else {
          for (int j=0; j<l-1; j++) s.insert(f[j]);
          auto it=s.begin();
          if (f[l]<*it) ans++;
          for (int i=1; i+l-2<f.size(); i++) {
              s.erase(f[i-1]);
              s.insert(f[i+l-2]);
              int minn=*(s.begin());
              bool ok=true;
              if (f[i-1]>=minn) ok=false;
              if (i+l<f.size()&&f[i+l]>=minn) ok=false;
              ans+=ok;
          }
      }
      cout << ans << endl;
  }
}
