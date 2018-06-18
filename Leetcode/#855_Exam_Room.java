class ExamRoom {

    Set<Integer> set;
    final int n;
    
    public ExamRoom(int N) {
        set = new TreeSet<Integer>();
        n = N;
    }
    
    public int seat() {
        int maxGap = -1, maxPos = 0, last = -1;
        for (int pos : set) {
            if (last == -1) {
                if (pos != 0) {
                    maxGap = pos;
                    maxPos = 0;
                }
                last = pos;
                continue;
            }
            int tmp = (pos - last) / 2;
            if (tmp > maxGap) {
                maxGap = tmp;
                maxPos = last + tmp;
            }
            last = pos;
        }
        if (last != -1 && last != n - 1) {
            int tmp = n - 1 - last;
            if (tmp > maxGap) {
                maxGap = tmp;
                maxPos = n - 1;
            }
        }
        set.add(maxPos);
        return maxPos;
    }
    
    public void leave(int p) {
        set.remove(p);
    }
}

/**
 * Your ExamRoom object will be instantiated and called as such:
 * ExamRoom obj = new ExamRoom(N);
 * int param_1 = obj.seat();
 * obj.leave(p);
 */