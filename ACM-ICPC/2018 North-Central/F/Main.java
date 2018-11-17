import java.util.*;

public class Main {
  public static class Point {
    int x;
    double y;
    public Point(int x, double y) {
      this.x = x;
      this.y = y;
    }
  }
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int n = sc.nextInt();
    Point[] points = new Point[n];
    for (int i = 0; i < n; i ++) {
      int x = sc.nextInt();
      double y = sc.nextDouble();
      points[i] = new Point(x, y);
    }
    Arrays.sort(points, new Comparator<Point>(){
      public int compare(Point a, Point b) {
        return a.x - b.x;
      }
    });
    double ans = 0;
    for (int i = 0; i < n - 1; i ++) {
      double tmp = Math.abs((double)(points[i].y - points[i + 1].y) / (points[i].x - points[i + 1].x));
      ans = Math.max(ans, tmp);
    }
    System.out.println(ans);
  }
}
