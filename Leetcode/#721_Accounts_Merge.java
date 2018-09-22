/*
### Corner cases
1. Same name but two different people
2. Same people but different name

### Solution 
1. Union-find, use HashMap to store parents

### Bugs
1. Alice mail1 mail2; Alice mail3 mail4; Alice mail2 mail3 <- should be only one person

### Test cases

*/
class Solution {
    
    private String find(Map<String, String> parent, String x) {
        if (parent.get(x).equals(x)) return x;
        parent.put(x, find(parent, parent.get(x)));
        return parent.get(x);
    }
    
    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, String> parent = new HashMap<String, String>();
        Map<String, String> name   = new HashMap<String, String>();
        
        // initialize
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i ++) {
                parent.put(account.get(i), account.get(i));
                name.put(account.get(i), account.get(0));
            }
        }
        
        // combine the emails of the same person together
        for (List<String> account : accounts) {
            String p = find(parent, account.get(1));
            for (int i = 2; i < account.size(); i ++) {
                String q = find(parent, account.get(i));
                if (!p.equals(q)) parent.put(q, p);
            }
        }
        
        Map<String, Set<String>> rec = new HashMap<String, Set<String>>();
        for (List<String> account : accounts) {
            for (int i = 1; i < account.size(); i ++) {
                String p = find(parent, account.get(i));
                Set<String> tmp = rec.getOrDefault(p, new TreeSet<String>());
                tmp.add(account.get(i));
                rec.put(p, tmp);
            }
        }
        
        // output
        List<List<String>> ans = new ArrayList<List<String>>();
        for (String p : rec.keySet()) {
            List<String> tmp = new ArrayList<String>(rec.get(p));
            tmp.add(0, name.get(p));
            ans.add(tmp);
        }
        return ans;
    }
}