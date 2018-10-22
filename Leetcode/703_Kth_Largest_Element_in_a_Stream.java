class KthLargest {

    final static int MAX_SIZE = 100000;
    
    int[] heap;
    int hsize, limit;
    
    private void swap(int a, int b) {
        int tmp = heap[a];
        heap[a] = heap[b];
        heap[b] = tmp;
    }
    
    private void up(int x) {
        if (x == 0) return;
        int father = (x - 1) / 2;
        if (heap[x] < heap[father])
            swap(x, father);
        up(father);
    }
    
    private void down(int x) {
        int left = x * 2 + 1;
        int right = x * 2 + 2;
        int min = heap[x], pos = -1;
        if (left < hsize && heap[left] < min) {
            min = heap[left];
            pos = left;
        }
        if (right < hsize && heap[right] < min) {
            min = heap[right];
            pos = right;
        }
        if (pos >= 0) {
            swap(x, pos);
            down(pos);
        }
    }
    
    private void push(int val) {
        heap[hsize ++] = val;
        up(hsize - 1);
        while (hsize > limit) pop();
    }
    
    private int pop() {
        int rtn = heap[0];
        swap(0, hsize - 1);
        hsize --;
        down(0);
        return rtn;
    }
    
    private int peek() {
        return heap[0];
    }
    
    public KthLargest(int k, int[] nums) {
        hsize = 0;
        limit = k;
        heap = new int[MAX_SIZE];
        for (int num : nums) 
            heap[hsize ++] = num;
        for (int i = (hsize - 2) / 2; i >= 0; i --) down(i);
        while (hsize > limit) pop();
    }
    
    public int add(int val) {
        push(val);
        return peek();
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */