class Solution {
    public double dist(int[] a, int[] b) {
        return Math.sqrt(Math.pow(a[0] - b[0], 2) + Math.pow(a[1] - b[1], 2));
    }
    
    public double largestTriangleArea(int[][] points) {
        double maxn = 0;
        for (int i = 0; i < points.length; i ++)
            for (int j = 0; j < points.length; j ++) {
                if (i == j) continue;
                for (int k = 0; k < points.length; k ++) {
                    if (i == k || j == k) continue;
                    double a = dist(points[i], points[j]);
                    double b = dist(points[i], points[k]);
                    double c = dist(points[j], points[k]);
                    double p = (a + b + c) / 2;
                    double s = Math.sqrt(p * (p - a) * (p - b) * (p - c));
                    if (s > maxn) maxn = s;
                    //System.out.println(maxn);
                }
            }
        return maxn;
    }
}