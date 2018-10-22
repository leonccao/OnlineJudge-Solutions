class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {        
        Queue<String> q = new LinkedList<String>();
        for (String s : words)
            q.offer(s);
        
        ArrayList<String> result = new ArrayList<String>();
        while (!q.isEmpty()) {
            int space = maxWidth - q.peek().length();
            StringBuilder line = new StringBuilder(q.poll());
            
            ArrayList<String> list = new ArrayList<String>();
            while (!q.isEmpty() && q.peek().length() + 1 <= space) {
                space -= q.peek().length() + 1;
                list.add(q.poll());
            }
            
            if (list.isEmpty()) {
                for (int i = 0; i < space; i ++)
                    line.append(' ');
            } else if (space == 0) {
                for (int i = 0; i < list.size(); i ++) {
                    line.append(' ');
                    line.append(list.get(i));
                }
            } else if (q.isEmpty()) {
                for (int i = 0; i < list.size(); i ++){
                    line.append(' ');
                    line.append(list.get(i));
                }
                for (int i = 0; i < space; i ++)
                    line.append(' ');
            } else {
                int blank = space / list.size();
                int extra = space % list.size();
                for (int i = 0; i < list.size(); i ++) {
                    for (int j = 0; j <= blank; j ++)
                        line.append(' ');
                    if (i < extra) line.append(' ');
                    line.append(list.get(i));
                }
            }
            result.add(line.toString());
        }
        
        return result;
    }
}