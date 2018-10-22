class Solution {
    public List<List<Integer>> largeGroupPositions(String S) {
        int len = 0;
        char last = S.charAt(0);
        List<List<Integer>> ans = new ArrayList<List<Integer>>();
        
        S = S + "$";
        for (int i = 0; i < S.length(); i ++) {
            char ch = S.charAt(i);
            // System.out.println(i + " " + ch);
            if (ch == last) len ++;
            else {
                if (len >= 3) {
                    List<Integer> tmp = new ArrayList<Integer>();
                    tmp.add(i - len);
                    tmp.add(i - 1);
                    ans.add(tmp);
                }
                last = ch;
                len = 1;
            }
        }
        return ans;
    }
}