class Solution {
    public boolean rotateString(String A, String B) {
        if (A.equals(B)) return true;
        StringBuilder a = new StringBuilder(A);
        StringBuilder b = new StringBuilder(B);
        StringBuilder tmp, tmp2;
        for (int i = 0; i < a.length() - 1; i ++) {
            tmp = new StringBuilder(a.substring(i + 1, a.length()));
            tmp2 = new StringBuilder(a.substring(0, i + 1));
            tmp = tmp.append(tmp2);
            if (tmp.toString().equals(B)) return true;
        }
        return false;
    }
}