import java.util.*;

public class Main {

    private static double eps = 1e-5;

    private static class Pill {
        long s;
        double p;
        int x, y;
        public Pill() {}
    }

    private static class Node {
        double x, y;
        public Node(double x, double y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        int p = sc.nextInt();
        int c = sc.nextInt();
        Deque<Pill> pills = new LinkedList<>();
        for (int i = 0; i < p; i ++) {
            Pill pill = new Pill();
            pill.s = sc.nextLong();
            pill.x = sc.nextInt();
            pill.y = sc.nextInt();
            pill.p = (double)pill.y / (double)pill.x;
            if (pills.isEmpty() || pills.peekLast().p > pill.p)
                pills.addLast(pill);
        }

        double ans = n;
        Deque<Node> deque = new LinkedList<>();
        deque.add(new Node(1, 0));
        while (!pills.isEmpty()) {
            Pill pill = pills.pollFirst();
            while (deque.size() >= 2) {
                Node i = deque.pollFirst();
                Node j = deque.peekFirst();
                double tmp = (j.y - i.y) / (j.x - i.x);

                if (tmp < (-pill.s + eps)) {
                    deque.addFirst(i);
                    break;
                }
            }

            double f = deque.peekFirst().x * (double)pill.s + deque.peekFirst().y;
            double tmp = pill.s + ((double)n - f - (double)c) * pill.x / pill.y;
            ans = Math.max(ans, tmp);

            Node k = new Node(pill.p, f - pill.p * pill.s + c);
            while (deque.size() >= 2) {
                Node j = deque.pollLast();
                Node i = deque.peekLast();
                double tmp1 = (j.y - i.y) / (j.x - i.x);
                double tmp2 = (k.y - j.y) / (k.x - j.x);
                if (tmp2 < tmp1 + eps) {
                    deque.addLast(j);
                    break;
                }
            }
            deque.addLast(k);
        }
        System.out.println(ans);
    }
}
