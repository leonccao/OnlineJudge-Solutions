import java.util.*;

public class Main {

    final static int MOD = 1000000000 + 7;

    public static class Food {
        int l, r;
        Food(int l, int r) {
            this.l = l;
            this.r = r;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        long limit = sc.nextLong();
        long[] sum = new long[n + 1];
        sum[0] = 0;
        for (int i = 0; i < n; i ++) {
            int tmp = sc.nextInt();
            sum[i + 1] = sum[i] + tmp;
        }
        Food[] foods = new Food[m];
        for (int i = 0; i < m; i ++)
            foods[i] = new Food(sc.nextInt(), sc.nextInt());
        sc.close();

        Arrays.sort(foods, new Comparator<Food>(){
            public int compare(Food a, Food b) {
                return a.l - b.l;
            }
        });
        // calculate power of 2
        int[] POW2 = new int[m + 1];
        POW2[0] = 1;
        for (int i = 1; i < m; i ++)
            POW2[i] = (POW2[i - 1] << 1) % MOD;


        int tail = 0, count = 0, ans = 0;
        PriorityQueue<Food> pq = new PriorityQueue<>(new Comparator<Food>(){
            public int compare(Food a, Food b) {
                return a.r - b.r;
            }
        });
        for (Food food : foods) {
            if (sum[food.r] - sum[food.l - 1] < limit) continue;
            while (!pq.isEmpty() && sum[pq.peek().r] - sum[food.l - 1] < limit)
                pq.poll();
            ans = (ans + POW2[pq.size()]) % MOD;
            pq.add(food);
        }

        System.out.println(ans);
    }
}
