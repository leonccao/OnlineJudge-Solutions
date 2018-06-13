class Solution {
    class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
        Point(Point p) {
            this.x = p.x;
            this.y = p.y;
        }
    }
    
    class Line {
        Point a, b;
        Line(Point a, Point b) {
            this.a = a;
            this.b = b;
        }
    }
    
    private int cross(int a, int b, int c, int d) {
        return a * d - b * c;
    }
    
    private boolean intersect(Line f, Line g) {
        if (Math.max(f.a.x, f.b.x) < Math.min(g.a.x, g.b.x)) return false;
        if (Math.max(f.a.y, f.b.y) < Math.min(g.a.y, g.b.y)) return false;
        if (Math.max(g.a.x, g.b.x) < Math.min(f.a.x, f.b.x)) return false;
        if (Math.max(g.a.y, g.b.y) < Math.min(f.a.y, f.b.y)) return false;
        int tmpa = cross(f.b.x - g.a.x, f.b.y - g.a.y, g.b.x - g.a.x, g.b.y - g.a.y);
        int tmpb = cross(f.a.x - g.b.x, f.a.y - g.b.y, g.a.x - g.b.x, g.a.y - g.b.y);
        if (tmpa * tmpb >= 0) return true;
        return false;
    }
    
    public boolean isSelfCrossing(int[] x) {
        Point curPoint = new Point(0, 0);
        Queue<Line> ns = new LinkedList<Line>();
        Queue<Line> we = new LinkedList<Line>();
        we.add(new Line(new Point(0, 0), new Point(0, 0)));
            
        for (int i = 0; i < x.length; i ++) {
            Line curLine;
            int len = x[i];
            switch (i % 2) {
                case 0: // north or south
                    int tmpy = (i % 4 == 0) ? curPoint.y + len : curPoint.y - len;
                    curLine = new Line(new Point(curPoint), new Point(curPoint.x, tmpy));
                    if (we.size() > 2)
                        if (intersect(we.poll(), curLine))
                            return true;
                    if (we.size() > 1)
                        if (intersect(we.peek(), curLine))
                            return true;
                    ns.add(curLine);
                    curPoint.y = tmpy;
                    break;
                    
                case 1: // west or east
                    int tmpx = (i % 4 == 1) ? curPoint.x - len : curPoint.x + len;
                    curLine = new Line(new Point(curPoint), new Point(tmpx, curPoint.y));
                    if (ns.size() > 2)
                        if (intersect(ns.poll(), curLine))
                            return true;
                    if (ns.size() > 1)
                        if (intersect(ns.peek(), curLine))
                            return true;
                    we.add(curLine);
                    curPoint.x = tmpx;
                    break;
            }
        }
        
        return false;
    }
}