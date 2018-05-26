class Solution {
    class Num {
        int val;
        int index;
        Num(int val, int index) {
            this.val = val;
            this.index = index;
        }
    }
    
    int[] sum;
    int n;
    
    public void insert(int x) {
        while (x <= n) {
            sum[x] ++;
            x += x & (-x);
        }
    }
    
    public int search(int x) {
        int tmp = 0;
        while (x > 0) {
            tmp += sum[x];
            x -= x & (-x);
        }
        return tmp;
    }
    
    public List<Integer> countSmaller(int[] nums) {
        n = nums.length;
        sum = new int[n + 1];
        
        Num[] num = new Num[n];
        for (int i = 0; i < n; i ++)
            num[i] = new Num(nums[i], i + 1);
        Arrays.sort(num, new Comparator<Num>() {
           public int compare(Num a, Num b) {
               return a.val - b.val;
           } 
        });
        
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < n; i ++)
            ans.add(0);
        for (int i = 0; i < n; i ++) {
            ans.set(num[i].index - 1, i - search(num[i].index));
            insert(num[i].index);
        }
        return ans;
    }
}