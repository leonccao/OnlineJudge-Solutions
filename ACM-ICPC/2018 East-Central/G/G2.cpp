#include <iostream>
#include <string>
#include <vector>
#include <algorithm>
#include <map>
using namespace std;

vector<string> pattern = {"I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM", "M"};
vector<int> number = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 20, 30, 40, 50, 60, 70, 80, 90, 100, 200, 300, 400, 500, 600, 700, 800, 900, 1000};

string convert(int t) {
	string ret = "";
	for (int i = pattern.size()-1; i >= 0; i--) {
		if (t >= number[i]) {
			t -= number[i];
			ret += pattern[i];
		}
		if (t == 0)
			break;
	}
	return ret;
}

int P, t, n, ten;
vector<string> ret;
map<string, int> mapv;
int first_v = -1;
int first_vr = -1;

bool cmp(string a, string b) {
	return a > b;
}

int maxn = 10000;

int main() {

	for (int i = 1; i <= maxn; i++) {
		ret.push_back(convert(i));
	}
	sort(ret.begin(), ret.end(), cmp);
	for (int i = 1; i <= maxn; i++) {
		cout << i << ' ' << ret[i-1] << endl;
		mapv[ret[i - 1]] = i;
		if (ret[i - 1][0] == 'M' && first_v == -1) {
			first_v = i;
		}
	}
	cout << first_v << endl;
	first_v--;
	cout << ret[first_v - 1] << ' ' << ret[first_v] << ' ' << ret[first_v + 1] << endl;


	return 0;
}
