class Solution {
    
    public class Holder {
        String log;
        int rank;
        public Holder(String log, int rank) {
            this.log = log;
            this.rank = rank;
        }
    }
    
    public String[] reorderLogFiles(String[] logs) {
        Holder[] holds = new Holder[logs.length];
        for (int i = 0; i < logs.length; i ++)
            holds[i] = new Holder(logs[i], i);
        Arrays.sort(holds, new Comparator<Holder>(){
            public int compare(Holder a, Holder b) {
                String[] as = a.log.split(" ");
                String[] bs = b.log.split(" ");
                boolean ta = Character.isLetter(as[1].charAt(0));
                boolean tb = Character.isLetter(bs[1].charAt(0));
                if (ta && tb) {
                    return a.log.substring(a.log.indexOf(" ") + 1, a.log.length()).compareTo(b.log.substring(b.log.indexOf(" ") + 1, b.log.length()));
                } else if (!ta && !tb) {
                    return a.rank - b.rank;
                } else if (ta && !tb) {
                    return -1;
                } else if (!ta && tb) {
                    return 1;
                }
                return 0;
            } 
        });
        String[] ans = new String[logs.length];
        for (int i = 0; i < logs.length; i ++)
            ans[i] = holds[i].log;
        return ans;
    }
}