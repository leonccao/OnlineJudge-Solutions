class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n = nums.length;
        int[] len = new int[n];
        int[] pre = new int[n];
        
        Arrays.sort(nums);
        for (int i = 0; i < n; i ++) {
            len[i] = 1;
            pre[i] = -1;
        }
        
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < n; i ++) {
            for (int j = 0; j < i; j ++) {
                if (nums[i] % nums[j] != 0) continue;
                if (len[j] + 1 > len[i]) {
                    len[i] = len[j] + 1;
                    pre[i] = j;
                }
            }
            map.put(nums[i], i);
        }
        
        int lenMax = 0, posMax = -1;
        for (int i = 0; i < n; i ++)
            if (len[i] > lenMax) {
                lenMax = len[i];
                posMax = i;
            }
        List<Integer> ans = new LinkedList<Integer>();
        while (posMax != -1) {
            ans.add(nums[posMax]);
            posMax = pre[posMax];
        }
        return ans;
    }
}