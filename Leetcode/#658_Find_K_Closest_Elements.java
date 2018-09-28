class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        // find the fist arr[i] such that dist[i] < dist[i + k]
        int l = 0, r = arr.length - k + 1;
        while (l < r - 1) {
            int mid = (l + r) / 2 - 1;
            if (Math.abs(arr[mid] - x) > Math.abs(arr[mid + k] - x))
                l = mid + 1;
            else r = mid + 1;
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = l; i < l + k; i ++) 
            ans.add(arr[i]);
        return ans;
    }
}