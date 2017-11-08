class Solution {
public:
    int romanToInt(string s) {
        string thou, hund, ten, one;
        thou = hund = ten = one = "";
        for (int i = 0; i < s.size(); i ++)
            switch (s[i]) {
                case 'M':
                    if (i && s[i - 1] == 'C')
                        hund = hund + "M";
                    else thou = thou + "M"; break;
                case 'C':
                    if (i && s[i - 1] == 'X')
                        ten = ten + "C";
                    else hund = hund + "C"; break;
                case 'D': hund = hund + "D"; break;
                case 'X':
                    if (i && s[i - 1] == 'I')
                        one = one + "X";
                    else ten = ten + "X"; break;
                case 'L': ten = ten + "L"; break;
                case 'I': one = one + "I"; break;
                case 'V': one = one + "V"; break;
            }
        
        int thoun, hundn, tenn, onen;
        thoun = hundn = tenn = onen = 0;
        
        if (thou == "M") thoun = 1;
        if (thou == "MM") thoun = 2;
        if (thou == "MMM") thoun = 3;
        
        if (hund == "C") hundn = 1;
        if (hund == "CC") hundn = 2;
        if (hund == "CCC") hundn = 3;
        if (hund == "CD") hundn = 4;
        if (hund == "D") hundn = 5;
        if (hund == "DC") hundn = 6;
        if (hund == "DCC") hundn = 7;
        if (hund == "DCCC") hundn = 8;
        if (hund == "CM") hundn = 9;
        
        if (ten == "X") tenn = 1;
        if (ten == "XX") tenn = 2;
        if (ten == "XXX") tenn = 3;
        if (ten == "XL") tenn = 4;
        if (ten == "L") tenn = 5;
        if (ten == "LX") tenn = 6;
        if (ten == "LXX") tenn = 7;
        if (ten == "LXXX") tenn = 8;
        if (ten == "XC") tenn = 9;
        
        if (one == "I") onen = 1;
        if (one == "II") onen = 2;
        if (one == "III") onen = 3;
        if (one == "IV")  onen = 4;
        if (one == "V") onen = 5;
        if (one == "VI") onen = 6;
        if (one == "VII") onen = 7;
        if (one == "VIII") onen = 8;
        if (one == "IX") onen = 9;
        
        return thoun * 1000 + hundn * 100 + tenn * 10 + onen;
    }
};