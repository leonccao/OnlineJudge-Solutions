class Solution {    
    public int lastRemaining(int n) {
        int head = 1, left = n, shift = 1, time = 1;
        while (left > 1) {
            if (time % 2 == 1 || 
                (time % 2 == 0 && left % 2 == 1))
                    head += shift;
            left  >>= 1;
            shift <<= 1;
            time ++;
        }
        return head;
    }
}