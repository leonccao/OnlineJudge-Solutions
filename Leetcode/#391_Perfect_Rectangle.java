class Solution {
    class Rect implements Comparable<Rect> {
        int x1, x2, y1, y2;
        boolean end = false;
        
        Rect(int[] rect, boolean end) {
            x1 = rect[0];
            y1 = rect[1];
            x2 = rect[2];
            y2 = rect[3];
            this.end = end;
        }
        
        public int compareTo(Rect that) {
            if (this.y2 <= that.y1) return -1;
            if (this.y1 >= that.y2) return  1;
            return 0;
        }
    }
    
    public boolean isRectangleCover(int[][] rectangles) {
        int lx, ly, rx, ry;
        lx = ly = Integer.MAX_VALUE;
        rx = ry = Integer.MIN_VALUE;
        
        int Sall = 0;
        for (int[] rect : rectangles) {
            lx = Math.min(lx, rect[0]);
            ly = Math.min(ly, rect[1]);
            rx = Math.max(rx, rect[2]);
            ry = Math.max(ry, rect[3]);
            Sall += (rect[2] - rect[0]) * (rect[3] - rect[1]);
        }
        int Scover = (rx - lx) * (ry - ly);
        if (Sall != Scover) return false;
        
        Rect[] scan = new Rect[rectangles.length * 2];
        int nums = 0;
        for (int[] rect : rectangles) {
            scan[nums ++] = new Rect(rect, false);
            scan[nums ++] = new Rect(rect, true );
        }
        Arrays.sort(scan, new Comparator<Rect>() {
            @Override
            public int compare(Rect a, Rect b) {
                int va = a.end ? a.x2 : a.x1;
                int vb = b.end ? b.x2 : b.x1;
                if (va != vb) return va - vb;
                return a.x1 - b.x1;
            } 
        });
        
        TreeSet<Rect> set = new TreeSet<Rect>();
        for (Rect rect : scan) {
            if (rect.end) {
                set.remove(rect);
            } else {
                if (!set.add(rect))
                    return false;
            }
        }
        return true;
    }
}