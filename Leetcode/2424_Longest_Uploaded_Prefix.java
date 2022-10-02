class LUPrefix {
    
    int[] fa;

    public LUPrefix(int n) {
        fa = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            fa[i] = i;
        } 
    }
    
    public void upload(int video) {
        fa[video - 1] = video;
    }
    
    public int longest() {
        return get(0);
    }
    
    private int get(int a) {
        int f = fa[a];
        while (fa[f] != f) {
            f = fa[f];
        }
        fa[a] = f;
        return f;
    }
}

/**
 * Your LUPrefix object will be instantiated and called as such:
 * LUPrefix obj = new LUPrefix(n);
 * obj.upload(video);
 * int param_2 = obj.longest();
 */