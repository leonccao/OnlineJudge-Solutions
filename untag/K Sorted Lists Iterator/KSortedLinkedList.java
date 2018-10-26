import java.math.*;
import java.util.*;

public class KSortedLinkedList {

    public class Pointer {
        List<Integer> list;
        int index;
        Pointer(List<Integer> list, int index) { 
            this.list = list;
            this.index = index;
        }
        int getVal() {
            return list.get(index);
        }
    }

    public class KListIterator {

        PriorityQueue<Pointer> pq;

        public KListIterator(List<List<Integer>> lists) {
            pq = new PriorityQueue<>(new Comparator<Pointer>() {
                public int compare(Pointer a, Pointer b) {
                    return a.getVal() - b.getVal();
                }
            });
            for (List<Integer> list : lists)
                if (list != null && list.size() != 0)
                    pq.add(new Pointer(list, 0));
        }

        public boolean hasNext() {
            return !pq.isEmpty();
        }

        public int next() {
            Pointer cur = pq.poll();
            int rtn = cur.getVal();
            if (++ cur.index < cur.list.size())
                pq.add(cur);
            return rtn;
        }

    }

    public void test() {
        List<List<Integer>> lists = new LinkedList<>();
        lists.add(Arrays.asList(1, 4, 5));
        lists.add(Arrays.asList(1, 3, 4));
        lists.add(Arrays.asList(2, 6));

        KListIterator iterator = new KListIterator(lists);
        while (iterator.hasNext())
            System.out.print(iterator.next() + " ");
        System.out.println();
    }

    public static void main(String[] args) {
        KSortedLinkedList sol = new KSortedLinkedList();
        sol.test();
    }
}