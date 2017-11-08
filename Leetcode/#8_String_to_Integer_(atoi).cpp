class Solution {
public:
    int myAtoi(string str) {
        // If it is an empty string 
        if (str.size() == 0)
            return 0;
        
        // The first non-whitespace character
        int pointer = 0;
        while (str[pointer] == ' ' && pointer < str.size())
            pointer ++;
        
        // If the string only contains whitespace
        if (pointer == str.size())
            return 0;
        
        // An optional plus or minus sign
        bool minus = false;
        if (str[pointer] == '+')
            pointer ++;
        else if (str[pointer] == '-') {
            minus = true;
            pointer ++;
        } 
        
        // atoi
        long long result = 0;
        while (pointer < str.size()) {
            // Stop if invalid character appears
            if (str[pointer] < '0' or str[pointer] > '9')
                break;
            result = result * 10 + str[pointer ++] - '0';
            
            // Out of range
            if (!minus && result > INT_MAX)
                return INT_MAX;
            if (minus && result - 1> INT_MAX)
                return INT_MIN;
        }
        
        // If minus sign exists
        if (minus) result = - result;
        
        
        return result;
    }
};