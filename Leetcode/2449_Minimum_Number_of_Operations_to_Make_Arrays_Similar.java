class Solution {
    public long makeSimilar(int[] nums, int[] targets) {
        Arrays.sort(nums);
        List<Integer> numEven = new ArrayList<>();
        List<Integer> numOdd = new ArrayList<>();
        for (int num : nums) {
            if (num % 2 == 0) {
                numEven.add(num);
            } else {
                numOdd.add(num);
            }
        }
        
        Arrays.sort(targets);
        List<Integer> tarEven = new ArrayList<>();
        List<Integer> tarOdd = new ArrayList<>();
        for (int tar : targets) {
            if (tar % 2 == 0) {
                tarEven.add(tar);
            } else {
                tarOdd.add(tar);
            }
        }
        
        long result = 0, cum = 0;
        for (int i = 0; i < numEven.size(); i++) {
            if (tarEven.get(i) > numEven.get(i)) {
                int diff = tarEven.get(i) - numEven.get(i);
                result += diff / 2;
            }
        }
        
        for (int i = 0; i < numOdd.size(); i++) {
            if (tarOdd.get(i) > numOdd.get(i)) {
                int diff = tarOdd.get(i) - numOdd.get(i);
                result += diff / 2;
            }
        }
        return result;
    }
}