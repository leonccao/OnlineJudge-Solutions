class Solution {
    class Worker {
        int quality, wage;
        double ratio;
        Worker(int quality, int wage) {
            this.quality = quality;
            this.wage = wage;
            ratio = (double)wage / (double)quality;
        }
    }
    
    public double mincostToHireWorkers(int[] quality, int[] wage, int K) {
        int n = quality.length;
        Worker[] workers = new Worker[n];
        for (int i = 0; i < n; i ++)
            workers[i] = new Worker(quality[i], wage[i]);
        Arrays.sort(workers, new Comparator<Worker>() {
            public int compare(Worker a, Worker b) {
                if (Math.abs(a.ratio - b.ratio) < 1E-5) return 0;
                if (a.ratio < b.ratio) return -1;
                return 1;
            }
        });
        
        PriorityQueue<Worker> heap = new PriorityQueue<Worker>(new Comparator<Worker>() {
            public int compare(Worker a, Worker b) {
                return b.quality - a.quality;
            }
        });
        int sumQ = 0;
        for (int i = 0; i < K; i ++) {
            heap.add(workers[i]);
            sumQ += workers[i].quality;
        }
        double ans = Double.MAX_VALUE;
        ans = Math.min(ans, workers[K - 1].ratio * sumQ);
            
        for (int i = K; i < n; i ++) {
            heap.add(workers[i]);
            sumQ += workers[i].quality;
            sumQ -= heap.poll().quality;
            ans = Math.min(ans, workers[i].ratio * sumQ);
        }
        return ans;
    }
}