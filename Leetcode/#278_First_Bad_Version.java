/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version); */

public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        int l = 0, r = n;
        while (l < r - 1) {
            int mid = l + (r - l) / 2;
            if (isBadVersion(mid))
                r = mid;
            else l = mid;
        }
        return l + 1;
    }
}