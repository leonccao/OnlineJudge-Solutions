class Solution {
    private void swap(int a, int b, char[] ch) {
        char tmp = ch[a];
        ch[a] = ch[b];
        ch[b] = tmp;
    }
    
    private boolean helper(int index, char[] A, char[] B, int limit) {
        if (index == A.length) return true;
        if (limit == 0) {
            for (int i = A.length - 1; i >= index; i --)
                if (A[i] != B[i]) return false;
            return true;
        }
        if (A[index] == B[index])
            return helper(index + 1, A, B, limit);
        for (int i = index + 1; i < A.length; i ++) {
            if (A[i] != B[index]) continue;
            swap(i, index, A);
            if (helper(index + 1, A, B, limit - 1))
                return true;
            swap(i, index, A);
        }
        return false;
    }
    
    public int kSimilarity(String A, String B) {
        if (A.equals(B)) return 0;
        int worst = A.length();
        
        for (int limit = 1; limit < worst; limit ++)
            if (helper(0, A.toCharArray(), B.toCharArray(), limit))
                return limit;
        return -1;
    }
}