class Solution {
    public int integerReplacement(int n) {
        int steps = 0;
        long tmp = n;
        while (tmp > 1) {
            if (tmp % 2 == 0) tmp /= 2;
            else if ((tmp & 2) != 0 && tmp != 3) tmp += 1;
            else tmp -= 1;
            steps ++;
        }
        return steps;
    }
}