import java.math.*;

public class MergeThreeSortedArrays {

    public int[] merge(int[] a, int[] b, int[] c) {
        int[] ans = new int[a.length + b.length + c.length];
        int i = 0, j = 0, k = 0, cnt = 0;

        while (i < a.length && j < b.length && k < c.length) {
            ans[cnt ++] = Math.min(a[i], Math.min(b[j], c[k]));
            if (ans[cnt - 1] == a[i]) i ++;
            else if (ans[cnt - 1] == b[j]) j ++;
            else k ++;
        }

        while (i < a.length && j < b.length) {
            if (a[i] < b[j])
                ans[cnt ++] = a[i ++];
            else ans[cnt ++] = b[j ++];
        }

        while (i < a.length && k < c.length) {
            if (a[i] < c[k])
                ans[cnt ++] = a[i ++];
            else ans[cnt ++] = c[k ++];
        }

        while (j < b.length && k < c.length) {
            if (b[j] < c[k])
                ans[cnt ++] = b[j ++];
            else ans[cnt ++] = c[k ++];
        }

        while (i < a.length) ans[cnt ++] = a[i ++];
        while (j < b.length) ans[cnt ++] = b[j ++];
        while (k < c.length) ans[cnt ++] = c[k ++];
        return ans;
    }

    public static void main(String[] args) {
        int[] a = { 1, 2, 41, 52, 84 }; 
        int[] b = { 1, 3, 41, 52, 67 }; 
        int[] c = { 1, 4, 41, 52, 67, 85 }; 
        MergeThreeSortedArrays sol = new MergeThreeSortedArrays();
        int[] ans = sol.merge(a, b, c);
        for (int num : ans)
            System.out.print(num + " ");
        System.out.println();
    }
}