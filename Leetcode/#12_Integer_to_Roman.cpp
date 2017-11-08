class Solution {
public:
    string intToRoman(int num) {
        int thou, hund, ten, one;
        thou = num / 1000;
        hund = num % 1000 / 100;
        ten = num % 100 / 10;
        one = num % 10;
        
        string result = "";
        
        // thousand
        for (int i = 0; i < thou; i ++)
            result = result + "M";
        
        // hundred
        if (hund < 4)
            for (int i = 0; i < hund; i ++)
                result = result + "C";
        else if (hund == 4)
            result = result + "CD";
        else if (hund < 9) {
            result = result + "D";
            for (int i = 5; i < hund; i ++)
                result = result + "C";
        } else result = result + "CM";
        
        // ten
        if (ten < 4)
            for (int i = 0; i < ten; i ++)
                result = result + "X";
        else if (ten == 4)
            result = result + "XL";
        else if (ten < 9) {
            result = result + "L";
            for (int i = 5; i < ten; i ++)
                result = result + "X";
        } else result = result + "XC";
        
        // one
        if (one < 4)
            for (int i = 0; i < one; i ++)
                result = result + "I";
        else if (one == 4)
            result = result + "IV";
        else if (one < 9) {
            result = result + "V";
            for (int i = 5; i < one; i ++)
                result = result + "I";
        } else result = result + "IX";
        
        return result;
    }
};