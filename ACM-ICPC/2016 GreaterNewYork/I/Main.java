import java.util.*;

public class Main {

    final static int[][] MV = {{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
    final static String[] INS = {"down", "left", "up", "right"};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        NEW_GAME:
        while (true) {
            Map<List<Integer>, boolean[]> map = new HashMap<>();
            Map<List<Integer>, Integer> back = new HashMap<>();
            int[] cur = new int[] {0, 0};
            int last = -1;

            NEXT_MOVE:
            while (true) {
                List<Integer> curList = Arrays.asList(cur[0], cur[1]);
                if (!map.containsKey(curList)) {
                    map.put(curList, new boolean[] {false, false, false, false});
                    back.put(curList, last);
                }
                boolean[] rec = map.get(curList);

                for (int dir = 0; dir < 4; dir ++) {
                    if (rec[dir] || dir == back.get(curList)) continue;
                    rec[dir] = true;

                    System.out.println(INS[dir]);
                    if (!sc.hasNext()) return;
                    String fb = sc.next();
                    if (fb.equals("solved")) continue NEW_GAME;
                    if (fb.equals("wall")) continue;

                    if (fb.equals("ok")) {
                        cur[0] += MV[dir][0];
                        cur[1] += MV[dir][1];
                        last = (dir + 2) % 4;
                        continue NEXT_MOVE;
                    }
                }

                int dirTmp = back.get(curList);
                if (dirTmp == -1) {
                    System.out.println("no way out");
                    continue NEW_GAME;
                }
                System.out.println(INS[dirTmp]);
                sc.next();
                cur[0] += MV[dirTmp][0];
                cur[1] += MV[dirTmp][1];
                last = (dirTmp + 2) % 4;
                continue NEXT_MOVE;
            }
        }
    }
}
