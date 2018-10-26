import java.util.*;

public class FindKthClosestPoints {

    public class Point {
        int x, y, dist;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
            dist = x * x + y * y;
        }
    }

    public List<Point> findKthPQ(List<Point> points, int k) {
        PriorityQueue<Point> pq = new PriorityQueue<>(new Comparator<Point>() {
            public int compare(Point a, Point b) {
                return b.dist - a.dist;
            }
        });
        for (Point point : points) {
            if (pq.size() < k) pq.add(point);
            else if (point.dist < pq.peek().dist) {
                pq.poll();
                pq.add(point);
            }
        }
        List<Point> ans = new ArrayList<>();
        while (!pq.isEmpty()) ans.add(pq.poll());
        return ans;
    }

    public List<Point> findKthQS(List<Point> points, int k) {
        quickSelect(points, 0, points.size() - 1, k - 1);
        List<Point> ans = new ArrayList<>();
        for (int i = 0; i < k; i ++)
            ans.add(points.get(i));
        return ans;
    }

    private void quickSelect(List<Point> points, int l, int r, int k) {
        if (l == r) return;
        Point pivot = points.get(r);
        int i = l, j = r - 1;
        do {
            while (i < r && points.get(i).dist < pivot.dist) i ++;
            while (l < j && points.get(j).dist > pivot.dist) j --;
            if (i < j) swap(points, i ++, j --);
        } while (i < j);
        swap(points, i, r);
        if (i == k) return;
        if (k < i) quickSelect(points, l, i - 1, k);
        else quickSelect(points, i + 1, r, k);
    }

    private void swap(List<Point> points, int a, int b) {
        Point tmp = points.get(a);
        points.set(a, points.get(b));
        points.set(b, tmp);
    }

    public void test() {
        List<Point> points = new ArrayList<>();
        points.add(new Point(1, 3));
        points.add(new Point(2, 5));
        points.add(new Point(4, 3));
        points.add(new Point(1, 7));
        points.add(new Point(2, 6));
        points.add(new Point(3, 3));
        List<Point> ans = findKthQS(points, 3);
        for (Point point : ans)
            System.out.println(point.x + " " + point.y + " " + point.dist);
    }
    
    public static void main(String[] args) {
        FindKthClosestPoints sol = new FindKthClosestPoints();
        sol.test();
    }

}