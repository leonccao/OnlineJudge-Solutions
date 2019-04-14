class Solution {
    public boolean judgeCircle(String moves) {
        int ver = 0, hor = 0;
        for (char ch : moves.toCharArray()) {
            switch (ch) {
                case 'U': ver ++; break;
                case 'D': ver --; break;
                case 'L': hor --; break;
                case 'R': hor ++; break;
            }
        }
        if (ver == 0 && hor == 0) {
            return true;
        } else {
            return false;
        }
    }
}