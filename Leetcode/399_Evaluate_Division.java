class Solution {
    public double[] calcEquation(String[][] equations, double[] values, String[][] queries) {
        Map<String, Map> map = new HashMap<String, Map>();
        for (int i = 0; i < equations.length; i ++) {
            if (!map.containsKey(equations[i][0]))
                map.put(equations[i][0], new HashMap<String, Double>());
            if (!map.containsKey(equations[i][1]))
                map.put(equations[i][1], new HashMap<String, Double>());
            double tmpVal = values[i];
            double tmpRevVal = 1.0 / tmpVal;
            Map<String, Double> tmpMap = map.get(equations[i][0]);
            tmpMap.put(equations[i][1], tmpVal);
            tmpMap = map.get(equations[i][1]);
            tmpMap.put(equations[i][0], tmpRevVal);
        }
        
        double[] ans = new double[queries.length];
        for (int i = 0; i < queries.length; i ++) {
            String start = queries[i][0];
            String end   = queries[i][1];
            if (!map.containsKey(start) || !map.containsKey(end)) {
                ans[i] = -1.0;
                continue;
            }
            if (start.equals(end)) {
                ans[i] = 1.0;
                continue;
            }
            Set<String> set = new HashSet<String>();
            ans[i] = find(start, end, 1.0, map, set);
        }
        return ans;
    }
    
    private double find(String cur, String target, double distance, Map<String, Map> map, Set<String> set) {
        if (set.contains(cur)) return -1.0;
        set.add(cur);
        if (cur.equals(target)) return distance;
        
        Map<String, Double> tmpMap = map.get(cur);
        for (String end : tmpMap.keySet()) {
            double tmpVal = find(end, target, distance * tmpMap.get(end), map, set);
            if (tmpVal > 0) return tmpVal;
        }
        return -1.0;
    }
}