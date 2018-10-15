import java.util.*;

public class RecommendFriends {
    public static List<String> recommend(String name) {
        List<String> tmp = getFriends(name);
        Set<String> set = new HashSet<String>(tmp);
        
        Map<String, Integer> map = new HashMap<String, Integer>();
        int maxn = 0;
        for (String mid : set) {
            tmp = getFriends(mid);
            for (String friend : tmp) {
                if (set.contains(friend) || friend.equals(name))
                    continue;
                int cnt = map.getOrDefault(friend, 0) + 1;
                maxn = Math.max(maxn, cnt);
                map.put(friend, cnt);
            }
        }

        List<String>[] bucket = new List[maxn + 1];
        for (int i = 0; i <= maxn; i ++)
            bucket[i] = new ArrayList<String>();
        for (String key : map.keySet())
            bucket[map.get(key)].add(key);
        
        List<String> res = new ArrayList<String>();
        for (int i = maxn; i > 0; i --)
            for (int j = 0; j < bucket[i].size(); j ++)
                res.add(bucket[i].get(j));
        return res;
    }

    public static List<String> getFriends(String name) {
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        map.put("Lily", new ArrayList<String>());
        map.put("Lucy", new ArrayList<String>());
        map.put("Hanmeimei", new ArrayList<String>());
        map.put("Jim", new ArrayList<String>());
        map.put("Lilei", new ArrayList<String>());
        map.put("Poly", new ArrayList<String>());
        map.get("Lily").add("Lilei");
        map.get("Lily").add("Poly");
        map.get("Lily").add("Hanmeimei");
        map.get("Lily").add("Jim");
        map.get("Lucy").add("Lilei");
        map.get("Lucy").add("Poly");
        map.get("Lucy").add("Hanmeimei");
        map.get("Lucy").add("Lily");
        map.get("Lilei").add("Jim");
        map.get("Lilei").add("Lucy");
        map.get("Lilei").add("UncleWang");
        map.get("Lilei").add("Hanmeimei");
        map.get("Lilei").add("Lily");
        map.get("Jim").add("Lily");
        map.get("Jim").add("Lucy");
        map.get("Jim").add("Lilei");
        map.get("Poly").add("Jim");
        map.get("Poly").add("Lilei");
        return map.get(name);
    }

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        //List<String> res = sol.recommendation("Poly");
        List<String> res = recommend("Poly");
        for (String each : res) {
            System.out.println(each);
        }
    }
}