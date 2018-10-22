/*
### Test cases:
1. [1]
2. [1, 1]
3. [1, 2]
4. Sum will be very large

### Solution:
1. Prefix sum + Binary Search
    - Time complexity: O(klogn)
    - Space complexity: O(n)
*/
class Solution {

    int[] sum;
    Random rand;
    
    public Solution(int[] w) {
        sum = new int[w.length + 1];
        sum[0] = 0;
        for (int i = 0; i < w.length; i ++)
            sum[i + 1] = sum[i] + w[i];
        rand = new Random();
    }
    
    private int binarySearch(int target) {
        int l = 0, r = sum.length;
        while (l < r - 1) {
            int mid = l + (r - l) / 2 - 1;
            if (sum[mid] == target) return mid;
            else if (sum[mid] < target) l = mid + 1;
            else r = mid + 1;
        }
        return l - 1;
    }
    
    public int pickIndex() {
        int target = rand.nextInt(sum[sum.length - 1]);
        return binarySearch(target);
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */

class Solution {

    TreeMap<Integer, Integer> map;
    Random rand;
    
    public Solution(int[] w) {
        map = new TreeMap<Integer, Integer>();
        int sum = 0;
        for (int i = 0; i < w.length; i ++) {
            sum += w[i];
            map.put(sum, i);
        }
        rand = new Random();
    }
    
    public int pickIndex() {
        int target = rand.nextInt(map.lastKey());
        return map.higherEntry(target).getValue();
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */