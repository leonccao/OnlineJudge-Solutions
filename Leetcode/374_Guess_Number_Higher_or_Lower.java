/* The guess API is defined in the parent class GuessGame.
   @param num, your guess
   @return -1 if my number is lower, 1 if my number is higher, otherwise return 0
      int guess(int num); */

public class Solution extends GuessGame {
    public int guessNumber(int n) {
        int l = 1, r = n + 1;
        while (l < r - 1) {
            int mid = (r - l) / 2 + l;
            if (guess(mid) == 0) return mid;
            if (guess(mid) == -1) r = mid;
            else l = mid + 1;
        }
        return l;
    }
}