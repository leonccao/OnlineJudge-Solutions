class Solution {
    
    class Num {
        int val;
        int cnt;
        Num(int val, int cnt) {
            this.val = val;
            this.cnt = cnt;
        }
    }
    
    public long countExcellentPairs(int[] nums, int k) {
        Arrays.sort(nums);
        int len = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] != nums[i]) {
                nums[len++] = nums[i];
            }
        }
        
        
        Num[] numObjs = new Num[len];
        for (int i = 0; i <len; i++) {
            int num = nums[i];
            
            int cntTmp = 0;
            while (num > 0) {
                cntTmp += num % 2;
                num /= 2;
            }
            
            numObjs[i] = new Num(nums[i], cntTmp);
        }
        
        Arrays.sort(numObjs, (a, b) -> a.cnt - b.cnt);
        
        long result = 0;
        int index = 0;
        for (int i = len - 1; i >= 0; i--) {
            while (index <= i && numObjs[index].cnt + numObjs[i].cnt < k) {
                index++;
            }
            if (index > i) {
                break;
            }
            result += (i - index) * 2 + 1;
        }
        return result;
    }
}