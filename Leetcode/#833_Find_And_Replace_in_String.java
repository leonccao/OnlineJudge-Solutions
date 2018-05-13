class Solution {
    class Replace {
        int index;
        String source;
        String target;
        Replace(int index, String source, String target) {
            this.index = index;
            this.source = source;
            this.target = target;
        }
    }
    
    public String findReplaceString(String S, int[] indexes, String[] sources, String[] targets) {
        Replace[] reps = new Replace[indexes.length];
        for (int i = 0; i < reps.length; i ++)
            reps[i] = new Replace(indexes[i], sources[i], targets[i]);
        Arrays.sort(reps, new Comparator<Replace>() {
            public int compare(Replace a, Replace b) {
                return b.index - a.index;
            }
        });
        
        StringBuilder sb = new StringBuilder(S);
        for (Replace rep : reps) {
            String tmp = sb.substring(rep.index, rep.index + rep.source.length());
            if (tmp.equals(rep.source))
                sb.replace(rep.index, rep.index + rep.source.length(), rep.target);
        }
        return sb.toString();
    }
}