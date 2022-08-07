class Solution {
    public int maximumGroups(int[] grades) {
        Arrays.sort(grades);
        int n = grades.length;
        int size = 1;
        int result = 0;
        while (n >= size) {
            n -= size;
            result++;
            size++;
        }
        return result;
    }
}