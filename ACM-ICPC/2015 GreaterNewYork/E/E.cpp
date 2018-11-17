#include <bits/stdc++.h>

using namespace std;

typedef unsigned long long LL;

int main() {
	ios::sync_with_stdio(false);
	freopen("E.in", "r", stdin);
	int T; cin >> T;
	while (T--) {
		int id;
		string s;
		cin >> id >> s;
		LL a=0, b=0;
		int pos=s.find_first_of('/');
		for (int i=0; i<pos; i++) a=a*10+s[i]-'0';
		for (int i=pos+1; i<s.size(); i++) b=b*10+s[i]-'0';
		int cnt=0;
		LL ans=0;
		while (a!=1||b!=1) {
			if (a<b)b-=a;
			else {
				a-=b;
				ans|=(1LL<<cnt);
			}
			cnt++;
		}
		ans|=(1LL<<(cnt));
		cout << id << ' ' << ans << endl;
	}
}
