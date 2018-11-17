import java.util.*;

public class Main {

    static int[][][] s = new int[6][6][2];
    static List<Set<Integer>> rows, cols, blks;
    static int x, y, z;

    private static void input() {

        rows = new ArrayList<>();
        cols = new ArrayList<>();
        blks = new ArrayList<>();
        for (int i = 0; i < 6; i ++) {
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            blks.add(new HashSet<>());
        }

        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < 6; i ++)
        for (int j = 0; j < 6; j ++) {
            String t = sc.next();
            if (t.indexOf("/") == -1) {
                s[i][j][1] = -1;
                s[i][j][0] = t.equals("-") ? 0 : Integer.parseInt(t);
            } else {
                String[] words = t.split("/");
                s[i][j][0] = words[0].equals("-") ? 0 : Integer.parseInt(words[0]);
                s[i][j][1] = words[1].equals("-") ? 0 : Integer.parseInt(words[1]);
            }

            for (int k = 0; k < 2; k ++) {
                int tmp = s[i][j][k];
                if (tmp > 0) {
                    rows.get(i).add(tmp);
                    cols.get(j).add(tmp);
                    blks.get(i / 2 * 2 + j / 3).add(tmp);
                }
            }
        }
    }

    private static void find() {
        x = y = z = -1;
        int count = Integer.MIN_VALUE;
        for (int i = 0; i < 6; i ++)
        for (int j = 0; j < 6; j ++)
        for (int k = 0; k < 2; k ++) {
            if (s[i][j][k] != 0) continue;

            int tmp = 0;
            tmp += rows.get(i).size();
            tmp += cols.get(j).size();
            tmp += blks.get(i / 2 * 2 + j / 3).size();
            if (tmp > count) {
                count = tmp;
                x = i; y = j; z = k;
            }
        }
    }

    private static boolean search() {
        find();
        if (x == -1) return true;
        int a = x, b = y, c = z;

        Set<Integer> row = rows.get(a);
        Set<Integer> col = cols.get(b);
        Set<Integer> blk = blks.get(a / 2 * 2 + b / 3);

        int floor = c == 1 ? s[a][b][0] + 1 : 1;
        int ceil = (c == 0 && s[a][b][1] > 0) ? s[a][b][1] - 1 : 9;
        for (int i = floor; i <= ceil; i ++) {
            if (row.contains(i)) continue;
            if (col.contains(i)) continue;
            if (blk.contains(i)) continue;
            row.add(i); col.add(i); blk.add(i);
            s[a][b][c] = i;
            if (search()) return true;
            s[a][b][c] = 0;
            row.remove(i); col.remove(i); blk.remove(i);
        }
        return false;
    }

    private static void output() {
        for (int i = 0; i < 6; i ++) {
            for (int j = 0; j < 5; j ++) {
                if (s[i][j][1] == -1) 
                    System.out.print(s[i][j][0] + " ");
                else System.out.print(s[i][j][0] + "/" + s[i][j][1] + " ");
            }
            if (s[i][5][1] == -1) 
                System.out.println(s[i][5][0]);
            else System.out.println(s[i][5][0] + "/" + s[i][5][1]);
        }
    }

    public static void main(String[] args) {
        input();
        search();
        output();
    }
}
