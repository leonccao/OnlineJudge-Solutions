class Solution {
    public int hIndex(int[] citations) {
        Arrays.sort(citations);
        int last = -1;
        for (int i = 0; i < citations.length; i ++) {
            if (citations[i] == last) continue;
            if (citations[i] >= citations.length - i)
                return citations.length - i;
        }
        return 0;
    }
}