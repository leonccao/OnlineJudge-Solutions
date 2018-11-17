import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        //int r = sc.nextInt();
        //int m = sc.nextInt();
        int rr = 1;
        List<List<Integer>> p = new ArrayList<>();
        p.add(new ArrayList<>());
        for (int m = 1; m < 1000; m ++) {
            int r = rr;
            Set<Integer> set = new HashSet<>();
            set.add(r);
            int d = 1;
            List<Integer> rec = new ArrayList<>();

                for (int i = 1; i <= 10000; i ++) {
                    if (set.contains(m)) {
                        System.out.println(m + " " + i);
                        if (p.size() == i) p.add(new ArrayList<>());
                        p.get(i).add(m);
                        break;
                    }
                    while (set.contains(d)) d ++;
                    long tmp = 0;
                    rec.add(d);
                    for (int j = rec.size() - 1; j >= 0; j --) {
                        tmp += rec.get(j);
                        if (tmp > m) break;
                        set.add((int)tmp);
                    }
                    //System.out.println("last: " + rec.get(rec.size() - 1));
                    r += d;
                    set.add(r);
                }
        }

        for (int i = 0; i < p.size(); i ++) {
            System.out.print(i + ": ");
            List<Integer> list = p.get(i);
            for (int num : list)
                System.out.print(num + " ");
            System.out.println();
        }
    }
}
