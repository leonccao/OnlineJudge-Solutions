class Solution {
    
    final static int T = 26;
    
    public int leastInterval(char[] tasks, int n) {
        
        int[] left = new int[T];
        int[] ava  = new int[T];
        for (char ch : tasks) {
            int tmp = ch - 'A';
            left[tmp] ++;
        }
        for (int i = 0; i < T; i ++)
            if (left[i] > 0)
                ava[i] = 0;
        
        int clock = 0, cnt = 0;
        while (cnt < tasks.length) {
            int pos = -1;
            int leftp = Integer.MIN_VALUE;
            int cool = 0;
            // find the one with largest storage left
            for (int i = 0; i < T; i ++) {
                if (left[i] == 0) continue;
                if (ava[i] <= clock && left[i] > leftp) {
                    pos = i;
                    leftp = left[i];
                }
                cool = Math.max(cool, ava[i] - clock);
            }
            
            // CPU working
            if (pos != -1) {
                left[pos] --;
                ava[pos] += n + 1;   
                clock ++;
                cnt ++;
            // CPU idle
            } else clock += cool;
        }
        
        return clock;
    }
}

class Solution {
    public int leastInterval(char[] tasks, int n) {
        int maxn = Integer.MIN_VALUE;
        int[] cnt = new int[26];
        for (char ch : tasks) {
            maxn = Math.max(maxn, ++ cnt[ch - 'A']);
        }
        int ans = (maxn - 1) * (n + 1);
        for (int i = 0; i < 26; i ++) {
            if (cnt[i] == maxn)
                ans ++;
        }
        return Math.max(ans, tasks.length);
    }
}

// O(n) O(n)
class Solution {
    public int leastInterval(char[] tasks, int n) {
        char[] cnt = new char[26];
        int maxn = 0;
        for (int task : tasks) {
            cnt[task - 'A'] ++;
            maxn = Math.max(maxn, cnt[task - 'A']);
        }
        int ans = (maxn - 1) * (n + 1);
        for (int i = 0; i < 26; i ++)
            if (cnt[i] == maxn)
                ans ++;
        return Math.max(ans, tasks.length);
    }
}

// PriorityQueue or Sort, output solution
class Solution {
    
    private class Task {
        char name;
        int cnt;
        public Task(char name) {
            this.name = name;
            this.cnt = 0;
        }
    }
    
    public int leastInterval(char[] tasks, int n) {
        Task[] tks = new Task[26];
        for (char ch = 'A'; ch <= 'Z'; ch ++)
            tks[ch - 'A'] = new Task(ch);
        for (char task : tasks)
            tks[task - 'A'].cnt ++;
        
        PriorityQueue<Task> pq = new PriorityQueue<Task>(new Comparator<Task>() {
            public int compare(Task a, Task b) {
                return b.cnt - a.cnt;
            } 
        });
        for (int i = 0; i < 26; i ++)
            if (tks[i].cnt > 0)
                pq.add(tks[i]);
        
        int ans = 0;
        List<Character> path = new ArrayList<Character>();
        while (!pq.isEmpty()) {
            List<Task> tmp = new ArrayList<Task>();
            for (int i = 0; i <= n; i ++) {
                ans ++;
                if (!pq.isEmpty()) {
                    Task cur = pq.poll();
                    path.add(cur.name);
                    if (-- cur.cnt > 0) tmp.add(cur);
                    if (pq.isEmpty() && tmp.isEmpty()) break;
                }
            }
            for (Task cur : tmp) pq.add(cur);
        }
        
        for (char cur : path)
            System.out.print(cur + " ");
        System.out.println();
        return ans;
    }
}