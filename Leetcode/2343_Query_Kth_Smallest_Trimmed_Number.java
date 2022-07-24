/*
    The numbers have to be compared as Strings
    They are too large as int or long
    
    Also, how to use substring function 
    String trimStr = nums[i].substring(len - trim);
*/
class Solution {
    public int[] smallestTrimmedNumbers(String[] nums, int[][] queries) {
        int len = nums[0].length();
        int[] result = new int[queries.length];
        
        for (int j = 0; j < queries.length; j++) {
            int k = queries[j][0];
            int trim = queries[j][1];
            
            Pair[] trimmed = new Pair[nums.length];
            for (int i = 0; i < nums.length; i++) {
                String trimStr = nums[i].substring(len - trim);
                Pair pair = new Pair();
                pair.string = trimStr;
                pair.index = i;
                trimmed[i] = pair;
            }
            Arrays.sort(trimmed, (Pair a, Pair b) -> a.string.compareTo(b.string));
            result[j] = trimmed[k - 1].index; 
        }
        return result;
    }
    
    class Pair {
        String string;
        int index;
    }
}