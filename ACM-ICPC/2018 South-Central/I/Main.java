import java.util.*;

public class Main {

    final static int[][] index = {
        {1, 2, 3, 4, 5, 6},
        {3, 4, 2, 1, 5, 6},
        {2, 1, 4, 3, 5, 6},
        {4, 3, 1, 2, 5, 6},
        {5, 6, 3, 4, 2, 1},
        {2, 1, 3, 4, 6, 5},
        {6, 5, 3, 4, 1, 2},
        {1, 2, 5, 6, 4, 3},
        {1, 2, 4, 3, 6, 5},
        {1, 2, 6, 5, 3, 4}
        };

    static String minS;

    private static void dfs(char[] chs, Set<String> set) {
        String s = new String(chs);
        if (set.contains(s)) return;
        set.add(s);
        if (minS.compareTo(s) > 0)
            minS = s;
        for (int i = 1; i < 10; i ++) {
            char[] chd = new char[6];
            for (int j = 0; j < 6; j ++)
                chd[j] = chs[index[i][j] - 1];
            dfs(chd, set);
        }
    }

    private static String calc(int[] faces) {
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < 6; j ++) {
            //System.out.println(faces[index[0][j] - 1]);
            sb.append(faces[index[0][j] - 1]);
        }
        //System.out.println(sb.toString());
        minS = sb.toString();
        Set<String> set = new HashSet<>();
        char[] chs = new char[6];
        for (int i = 0; i < 6; i ++)
            chs[i] = (char)('0' + faces[i]);
        dfs(chs, set);
        /*for (int i = 1; i < 10; i ++) {
            sb = new StringBuilder();
            for (int j = 0; j < 6; j ++) {
                //System.out.println(index[i][j] - 1);
                sb.append(faces[index[i][j] - 1]);
            }
            String tmp = sb.toString();
            if (ans.compareTo(tmp) > 0)
                ans = tmp;
            System.out.println(ans);
        }*/
        return minS;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            int[] faces = new int[6];
            for (int j = 0; j < 6; j ++)
                faces[j] = sc.nextInt();
            String tmp = calc(faces);
            map.put(tmp, map.getOrDefault(tmp, 0) + 1);
            //System.out.println(dices[i]);
        }
        int ans = 0;
        for (String key : map.keySet())
            ans = Math.max(ans, map.get(key));
        System.out.println(ans);
    }
}
