import java.math.*;
import java.util.*;

public class MergeKSortedArrays {

    class Array {
        int[] array;
        int index;
        Array(int[] array, int index) {
            this.array = array;
            this.index = index;
        }
    }

    public int[] merge(int[][] arrays) {
        PriorityQueue<Array> pq = new PriorityQueue<>(new Comparator<Array>() {
            public int compare(Array a, Array b) {
                return a.array[a.index] - b.array[b.index];
            }
        });
        for (int[] array : arrays) {
            if (array.length == 0) continue;
            pq.add(new Array(array, 0));
        }
        List<Integer> list = new ArrayList<>();
        while (!pq.isEmpty()) {
            Array cur = pq.poll();
            list.add(cur.array[cur.index]);
            if (++ cur.index < cur.array.length)
                pq.add(cur);
        }
        int[] ans = new int[list.size()];
        for (int i = 0; i < ans.length; i ++)
            ans[i] = list.get(i);
        return ans;
    }

    public static void main(String[] args) {
        int[][] arrays = {{ 1, 2, 41, 52, 84 }, { 1, 3, 41, 52, 67 }, { 1, 4, 41, 52, 67, 85 }}; 
        MergeKSortedArrays sol = new MergeKSortedArrays();
        int[] ans = sol.merge(arrays);
        for (int num : ans)
            System.out.print(num + " ");
        System.out.println();
    }
}