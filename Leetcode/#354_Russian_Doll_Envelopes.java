class Solution {
    
    class Envelope {
        int index, val;
        Envelope(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    public int maxEnvelopes(int[][] envelopes) {
        int len = envelopes.length;
        
        Envelope[] envs = new Envelope[len];
        for (int i = 0; i < len; i ++)
            envs[i] = new Envelope(envelopes[i][0], envelopes[i][1]);
            
        Arrays.sort(envs, new Comparator<Envelope>() {
            public int compare(Envelope a, Envelope b) {
                if (a.index != b.index)
                    return a.index - b.index;
                return b.val - a.val;
            }
        });
        
        List<Integer> list = new ArrayList<Integer>();
        list.add(-1);
        for (Envelope env : envs) {
            int l = 0, r = list.size();
            while (l < r - 1) {
                int mid = (l + r) / 2;
                if (list.get(mid) < env.val)
                    l = mid;
                else r = mid;
            }
            int tmp = l + 1;
            if (tmp >= list.size())
                list.add(env.val);
            else if (env.val < list.get(tmp))
                list.set(tmp, env.val);
        }
        
        return list.size() - 1;
    }
}