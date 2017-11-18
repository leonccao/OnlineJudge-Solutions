class Solution {
public:
    string convert(string s, int numRows) {
        if (numRows == 1) return s;
        vector<int> column;
        int secRow = numRows * 2 - 2;
        int pointer = -1;
        while (++ pointer < s.size()) {
            int tmp = pointer % secRow;
            if (tmp < numRows)
                column.push_back(tmp + 1);
            else column.push_back(numRows * 2 - 1 - tmp);
        }
        
        string answer = "";
        for (int i = 1; i <= numRows; i ++)
        for (int j = 0; j < s.size(); j ++)
            if (column[j] == i)
                answer += s[j];
        return answer;
    }
};