class Solution {
    public int[] anagramMappings(int[] A, int[] B) {
        int[] ans = new int[A.length];
        Map<Integer, Queue<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i ++) {
            int num = B[i];
            if (!map.containsKey(num)) {
                map.put(num, new LinkedList<Integer>());
            }
            map.get(num).offer(i);
        }
        for (int i = 0; i < A.length; i ++) {
            int num = A[i];
            ans[i] = map.get(num).poll();
        }
        return ans;
    }
}