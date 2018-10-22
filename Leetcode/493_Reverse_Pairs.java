/*

### Solutions
1. Binary indexed tree
    - Time complexity: O(nlog(n))
    - Space complexity: O(n)
2. Mergesort
    - Time complexity: O(nlog(n))
    - Space complexity: O(n)

### Bugs
1. (Integer - Integer) maybe larger than Integer during qsort
2. -5 * 2 < -5
3. Negative div direction is different
4. Integer * 2 maybe larger than Integer

*/
class Solution {
    class Num {
        int val, rank;
        Num(int val, int rank) {
            this.val = val;
            this.rank = rank;
        }
    }
    
    int[] sum;
    int limit;
    
    private void insert(int x) {
        while (x < limit) {
            sum[x] ++;
            x += lowbit(x);
        }
    }
    
    private int search(int x) {
        int rtn = 0;
        while (x > 0) {
            rtn += sum[x];
            x -= lowbit(x);
        }
        return rtn;
    }
    
    private int lowbit(int x) {
        return x & -x;
    }
    
    public int reversePairs(int[] nums) {
        Num[] numbers = new Num[nums.length];
        for (int i = 0; i < nums.length; i ++)
            numbers[i] = new Num(nums[i], i + 1);
        Arrays.sort(numbers, new Comparator<Num>() {
            public int compare(Num a, Num b) {
                if (a.val < b.val) return -1;
                if (a.val > b.val) return  1;
                return b.rank - a.rank;
            }
        });
        
        sum = new int[nums.length + 1];
        limit = nums.length + 1;
        
        int j = 0, ans = 0;
        for (int i = 0; i < numbers.length; i ++) {
            while (j < numbers.length && (long)numbers[j].val * 2 < numbers[i].val)
                insert(numbers[j ++].rank);
            ans += j - search(numbers[i].rank);
        }
        return ans;
    }
}