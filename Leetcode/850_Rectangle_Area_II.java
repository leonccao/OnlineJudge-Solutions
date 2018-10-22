class Solution {
    final static int MOD = 1000000000 + 7;
    
    class Node {
        int index;
        int val;
        Node(int index, int val) {
            this.index = index;
            this.val = val;
        }
    }
    
    public int rectangleArea(int[][] rectangles) {
        if (rectangles.length == 0) return 0;        
        
        int rects = rectangles.length;
        int[] steps = new int[rects * 2];
        for (int i = 0; i < rects; i ++) {
            steps[2 * i] = rectangles[i][1];
            steps[2 * i + 1] = rectangles[i][3];
        }
        Arrays.sort(steps);
        int stepLen = 0;
        for (int i = 1; i < steps.length; i ++)
            if (steps[i] != steps[stepLen])
                steps[++ stepLen] = steps[i];
        stepLen ++;
        
        int lastWide = 0;
        long area = 0;
        for (int i = 0; i < stepLen; i ++) {
            int step = steps[i];
            if (i > 0) {
                area = (area + (long)lastWide * (step - steps[i - 1])) % MOD;
            }
            
            List<Node> list = new ArrayList<Node>();
            for (int j = 0; j < rectangles.length; j ++) {
                if (step < rectangles[j][1]) continue;
                if (step >= rectangles[j][3]) continue;
                list.add(new Node(rectangles[j][0],  1));
                list.add(new Node(rectangles[j][2], -1));
            }
            Collections.sort(list, new Comparator<Node>() {
                public int compare(Node a, Node b) {
                    return a.index - b.index;
                }
            });
            
            lastWide = 0;
            int tmp = 0;
            for (int j = 0; j < list.size(); j ++) {
                if (j  > 0 && tmp > 0) {
                    lastWide = (lastWide + list.get(j).index - list.get(j - 1).index) % MOD;
                }
                
                tmp += list.get(j).val;
            }
        }
        return (int)area;
    }
}