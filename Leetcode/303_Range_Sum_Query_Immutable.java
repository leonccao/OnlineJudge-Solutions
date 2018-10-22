class NumArray {

    private int[] num;
    
    public NumArray(int[] nums) {
        num = new int[nums.length + 1];
        for (int i = 0; i < nums.length; i ++)
            num[i + 1] = num[i] + nums[i];
    }
    
    public int sumRange(int i, int j) {
        return num[j + 1] - num[i];
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(i,j);
 */