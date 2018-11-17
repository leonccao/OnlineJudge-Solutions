#include <cstdio>
#include <iostream>
#include <unordered_set>
#include <string>
#include <algorithm>
using namespace std;

string a, b;

void ins(string& s, char c) {
	auto pos=upper_bound(s.begin(), s.end(), c);
	s.insert(pos, c);
}

void del(string& s, char c) {
	int pos=s.find_first_of(c);
	s.erase(s.begin()+pos);
}

int main() {
	freopen("untitled.in", "r", stdin);
	std::ios::sync_with_stdio(false);
    // std::cin.tie(0);
	int n; cin >> n;
	while (n--) {
		cin >> a >> b;
		int len=a.size();
		int l=len, pos=-1;
		for (; l; l--) {
			bool find=false;
			unordered_set<string> S;
			string tmp;
			for (int i=0, j=0; i+l-1<len; i++) {
				if (i) del(tmp, b[i-1]);
				while (j-i<l) {
					ins(tmp, b[j++]);
				}
				S.insert(tmp);
			} 
			tmp.clear();
			for (int i=0, j=0; i+l-1<len; i++) {
				if (i) del(tmp, a[i-1]);
				while (j-i<l) {
					ins(tmp, a[j++]);
				}
				if (S.count(tmp)) {
					pos=i;
					find=true; break;
				}
			}
			if (find) break;
		}
		if (!l) cout << "NONE" << endl;
		else cout << a.substr(pos, l) << endl;
	}
}