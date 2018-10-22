class Solution {
public:
    string multiply(string num1, string num2) {
        if (num1 == "0" || num2 == "0")
            return "0";
        
        vector<int> numa, numb, numc;
        for (int i = num1.length() - 1; i >= 0; i --)
            numa.push_back(num1[i] - '0');
        for (int i = num2.length() - 1; i >= 0; i --)
            numb.push_back(num2[i] - '0');
        for (int i = 0; i < num1.length() + num2.length(); i ++)
            numc.push_back(0);
        
        for (int i = 0; i < numa.size(); i ++)
            for (int j = 0; j < numb.size(); j ++) {
                numc[i + j] += numa[i] * numb[j] % 10;
                numc[i + j + 1] += numa[i] * numb[j] / 10;
            }
        for (int i = 0; i < numc.size() - 1; i ++) {
            numc[i + 1] += numc[i] / 10;
            numc[i] = numc[i] % 10;
        }
        if (!numc[numc.size() - 1])
            numc.pop_back();
        
        string result = "";
        for (int i = numc.size() - 1; i >= 0; i --)
            result += numc[i] + '0';
        return result;
    }
};