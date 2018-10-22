class NumArray {
    int[] sum, nums;

    private void insert(int index, int val) {
        while (index < sum.length) {
            sum[index] += val;
            index += index & (-index);
        }
    }
    
    private int search(int index) {
        int ans = 0;
        while (index > 0) {
            ans += sum[index];
            index -= index & (-index);
        }
        return ans;
    }
    
    public NumArray(int[] nums) {
        this.nums = nums;
        sum = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i ++)
            insert(i + 1, nums[i]);
    }
    
    public void update(int i, int val) {
        int diff = val - nums[i];
        nums[i] = val;
        insert(i + 1, diff);
    }
    
    public int sumRange(int i, int j) {
        return search(j + 1) - search(i);
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */