#include <cstdio>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main() {
  int a, b, k; scanf("%d%d%d", &a, &b, &k);
  int ans=0;
  if (k>=4) {
    for (int i=0; i<=1; i++) if (i>=a&&i<=b) ans++;
  }
  else if (k==3) {
    const vector<int> v ={0,1,6643,1422773};
    for (int i: v) if (i>=a&&i<=b) ans++;
  }
  else {
    for (int i=a; i<=b; i++) {
      vector<int> v;
      int n=i;
      while (n) {
        v.push_back(n%k);
        n/=k;
      }
      bool ok=true;
      for (int x=0, y=v.size()-1; x<y; x++, y--)
        if (v[x]!=v[y]) {
          ok=false; break;
        }
      ans+=ok;
    }
  }
  printf("%d\n", ans);
}
