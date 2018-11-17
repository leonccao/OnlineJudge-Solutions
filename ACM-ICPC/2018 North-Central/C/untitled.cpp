#include <cstdio>
#include <iostream>
#include <cmath>
#include <vector>
#include <climits>

using namespace std;
unsigned long long a, b, c;
int la, lb, n;
string s;
unsigned long long x, y;

unsigned long long ten(int a) {
  unsigned long long ret = 1;
  for (int i=0; i<a; i++)
    ret *= 10;
  return ret;
}

unsigned long long gcd(unsigned long long a, unsigned long long b) {
  return b == 0 ? a : gcd(b , a%b);
}

int main() {
  // cout << LONG_LONG_MAX << endl;
  cin >> s >> n;
  la = 0; lb = 0;
  a = 0; b = 0; c = 0;

  bool flag = false;
  for (int i=0; i<s.size(); i++) {
    if (i >= (s.size() - n))
      c = c * 10 + (s[i] - '0');
    else if (s[i] == '.')
      flag = true;
    else if (flag)  {
      lb++;
      b = b * 10 + (s[i] - '0');
    } else {
      la++;
      a = a * 10 + (s[i] - '0');
    }
  }

  y = (ten(n) - 1) * ten(lb);
  x = c + (ten(n) - 1) * (a * ten(lb) + b);
  unsigned long long tmp = gcd(x, y);

  x /= tmp;
  y /= tmp;
  cout << x << '/' << y << endl;

  return 0;

}
