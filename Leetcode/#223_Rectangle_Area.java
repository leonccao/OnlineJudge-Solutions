class Solution {
    public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
        int area = (D - B) * (C - A) + (G - E) * (H - F);
        
        int down  = Math.max(B, F);
        int up    = Math.min(D, H);
        if (down >= up) return area;
        
        int left  = Math.max(A, E);
        int right = Math.min(C, G);
        if (left >= right) return area;
        
        return area - (up - down) * (right - left);
    }
}