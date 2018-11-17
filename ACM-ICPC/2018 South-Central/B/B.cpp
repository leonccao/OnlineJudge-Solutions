#include <bits/stdc++.h>

using namespace std;

// vector<double> fre={440, 466.16, 493.88, 523.25, 554.37, 587.33, 622.25, 659.26, 698.46, 739.99, 783.99, 830.61};

const int maxn=10;
string k[maxn]={"G major", "C major", "Eb major", "F# minor", "G minor"};
vector<int> v[maxn]={
    {10,0,2,3,5,7,9},
    {3,5,7,8,10,0,2},
    {6,8,10,11,1,3,5},
    {9,11,0,2,4,5,7},
    {10,0,1,3,5,6,8}
};
vector<string> s[maxn]={\
    {"G", "A", "B", "C", "D", "E", "F#"},\
    {"C", "D", "E", "F", "G", "A", "B"},\
    {"Eb", "F", "G", "Ab", "Bb", "C", "D"},\
    {"F#", "G#", "A", "B", "C#", "D", "E"},\
    {"G", "A", "Bb", "C", "D", "Eb", "F"}\
};

const double eps=1e-8;
int calc(double d) {
    int pos=floor(log(d/440)/log(2)*12.+0.5);
    // pos-=pos/12*12;
    while (pos<0) pos+=12;
    pos%=12;
    return pos;
}

int main() {
    freopen("B.in", "r", stdin);
    int n; scanf("%d", &n);
    vector<int> f;
    for (int i=0; i<n; i++) {
        double d; scanf("%lf", &d);
        f.push_back(calc(d));
    }
    int key;
    vector<int> ans, tmp;
    bool fst=false;
    for (int i=0; i<5; i++) {
        tmp.clear();
        bool ok=true;
        for (int& fr: f) {
            bool find=false;
            for (int j=0; j<7; j++) if (v[i][j]==fr) {
                tmp.push_back(j);
                find=true; break;
            }
            if (!find) {
                ok=false; break;
            }
        }
        if (ok) {
            if (fst) {
                fst=false; break;
            }
            key=i;
            fst=true;
            ans=tmp;
        }
    }
    if (!fst) cout << "cannot determine key" << endl;
    else {
        cout << k[key] << endl;
        for (int& i: ans) cout << s[key][i] << endl;
    }
}
