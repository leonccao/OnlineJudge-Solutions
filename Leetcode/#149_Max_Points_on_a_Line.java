/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

import java.math.BigDecimal;
import java.math.MathContext;

class Solution {
    public BigDecimal calcGrad(Point S, Point E) {
        return new BigDecimal(S.y - E.y).divide(new BigDecimal(S.x - E.x), MathContext.DECIMAL128);
    }
    
    public int maxPoints(Point[] points) {
        if (points.length < 3)
            return points.length;
        int answer = 2;
        for (int i = 0; i < points.length; i ++) {
            Point A = points[i];
            
            int sameP = 0, sameX = 0;
            for (int j = i; j < points.length; j ++)
                if (points[i].x == points[j].x) {
                    if (points[i].y == points[j].y)
                        sameP ++;
                    sameX ++;
                }
            answer = Math.max(answer, sameP);
            answer = Math.max(answer, sameX);
            
            Map<BigDecimal, Integer> map = new HashMap<BigDecimal, Integer>();
            for (int j = i + 1; j < points.length; j ++) {
                if (points[i].x == points[j].x)
                    continue;
                Point B = points[j];
                BigDecimal grad = calcGrad(A, B);
                if (map.containsKey(grad))
                    map.put(grad, map.get(grad) + 1);
                else map.put(grad, 1);
            }
            for (BigDecimal key : map.keySet())
                answer = Math.max(answer, map.get(key) + sameP);
        }
        return answer;
    }
}