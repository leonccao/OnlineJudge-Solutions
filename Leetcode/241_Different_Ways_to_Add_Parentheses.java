class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        // split the string
        List<Integer> operands = new ArrayList<Integer>();
        List<Character> operators = new ArrayList<Character>();
        int numBuffer = 0;
        for (char ch : input.toCharArray())
            if (ch >= '0' && ch <='9')
                numBuffer = numBuffer * 10 + ch - '0';
            else {
                operands.add(numBuffer);
                numBuffer = 0;
                operators.add(ch);
            }
        operands.add(numBuffer);
        
        // use dp to calculate rec[i][j] (all the answers between i and j)
        int len = operands.size();
        ArrayList<Integer>[][] rec = (ArrayList<Integer>[][]) new ArrayList[len][len];
        for (int i = len - 1; i >= 0; i --)
            for (int j = i; j < len; j ++) {
                rec[i][j] = new ArrayList<Integer>();
                if (i == j) {
                    rec[i][j].add(operands.get(i));
                    continue;
                }
                for (int k = i; k < j; k ++)
                    for (int tmpI : rec[i][k])
                        for (int tmpJ : rec[k + 1][j]) 
                            switch (operators.get(k)) {
                                case '+': rec[i][j].add(tmpI + tmpJ); break;
                                case '-': rec[i][j].add(tmpI - tmpJ); break;
                                case '*': rec[i][j].add(tmpI * tmpJ); break;
                            }
            }
        return rec[0][len - 1];
    }
}