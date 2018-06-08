class Solution {
    public List<String> findItinerary(String[][] tickets) {
        Map<String, List<String>> map = new HashMap<String, List<String>>();
        for(String[] ticket : tickets) {
            if (map.containsKey(ticket[0]))
                map.get(ticket[0]).add(ticket[1]);
            else {
                List<String> list = new ArrayList<String>();
                list.add(ticket[1]);
                map.put(ticket[0], list);
            }
        }
        
        Map<String, Integer> index = new HashMap<String, Integer>();
        for (String key : map.keySet()) {
            Collections.sort(map.get(key));
            index.put(key, 0);
        }
        
        List<String> ans = new LinkedList<String>();
        Stack<String> stack = new Stack<String>();
        stack.push("JFK");
        while (!stack.isEmpty()) {
            String start = stack.peek();
            int pos = index.containsKey(start) ? index.get(start) : -1;
            
            if (pos == -1 || pos == map.get(start).size())
                ans.add(0, stack.pop());
            else {
                String end = map.get(start).get(pos);
                index.put(start, pos + 1);
                stack.push(end);
            }
        }
        return ans;
    }
}