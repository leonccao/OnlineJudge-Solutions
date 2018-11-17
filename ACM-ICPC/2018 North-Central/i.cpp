#include <cstdio>
#include <iostream>
#include <cmath>
#include <vector>

using namespace std;

int main() {
  int w, s, c, k;
  scanf("%d%d%d%d", &w, &s, &c, &k);
  if (!k) {
    if (!w&&!s&&!c) puts("YES");
    else puts("NO");
  }
  else {
    if (s<k) puts("YES");
    else if (s==k) {
      if (c+w<=2*k) puts("YES");
      else puts("NO");
    }
    else if (s<=2*k) {
      if (c+w<=k) puts("YES");
      else puts("NO");
    }
    else if (c+w<k) puts("YES");
    else puts("NO");
  }
}
