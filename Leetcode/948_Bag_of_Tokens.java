class Solution {
    public int bagOfTokensScore(int[] tokens, int P) {
        Arrays.sort(tokens);
        for (int i = 0; i < tokens.length / 2; i ++) {
            int tmp = tokens[i];
            tokens[i] = tokens[tokens.length - i - 1];
            tokens[tokens.length - i - 1] = tmp;
        }
        int sumPow = P, sumCost = 0, sumPnt = 0;
        int j = tokens.length - 1;
        while (j >= 0 && sumCost + tokens[j] <= sumPow) {
            sumCost += tokens[j --];
            sumPnt ++;
        }
        int ans = sumPnt;
        //System.out.println(j);
        for (int i = 0; i < j; i ++) {
            if (sumPnt == 0) break;
            sumPow += tokens[i];
            sumPnt --;
            while (j > i && sumCost + tokens[j] <= sumPow) {
                sumCost += tokens[j --];
                sumPnt ++;
            }
            ans = Math.max(ans, sumPnt);
        }
        return ans;
    }
}