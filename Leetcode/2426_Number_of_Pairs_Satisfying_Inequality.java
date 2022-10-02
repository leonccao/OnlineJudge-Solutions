class Solution {
    
    
    static int n;
    static int[] sum;

    static int lowbit(int x){
        return x & (-x);
    }

    static void add(int x) {
        while (x <= n){
            sum[x]++;
            x += lowbit(x);
        }
    }

    static int query(int x){
        int ans = 0;
        while (x > 0){
            ans += sum[x];
            x -= lowbit(x);
        }
        return ans;
    }
    
    public long numberOfPairs(int[] nums1, int[] nums2, int diff) {
        long result = 0;
        n = 100000;
        sum = new int[100000];
        for (int i = 0; i < nums1.length; i++) {
            int cur = nums1[i] - nums2[i];
            result += query(cur + diff + 30000);
            add(cur + 30000);
        }
        return result;
    }
}