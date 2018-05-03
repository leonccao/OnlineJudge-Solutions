class Solution {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> ans = new LinkedList<Integer>();
        if (nums.length == 0) return ans;
        
        int candi1, candi2, count1, count2;
        candi1 = candi2 = nums[0];
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candi1)
                count1 ++;
            else if (num == candi2)
                count2 ++;
            else if (count1 == 0) {
                candi1 = num;
                count1 = 1;
            } else if (count2 == 0) {
                candi2 = num;
                count2 = 1;
            } else {
                count1 --;
                count2 --;
            }
        }
        
        count1 = count2 = 0;
        for (int num : nums) {
            if (num == candi1) count1 ++;
            else if (num == candi2) count2 ++;
        }
        if (count1 > nums.length / 3)
            ans.add(candi1);
        if (count2 > nums.length / 3)
            ans.add(candi2);
        return ans;
    }
}