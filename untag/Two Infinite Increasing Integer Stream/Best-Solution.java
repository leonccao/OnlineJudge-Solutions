import java.util.Deque;
import java.util.LinkedList;

public class Solution {
    public static void twoStream(Deque<Integer> a, Deque<Integer> b) {
        while (!a.isEmpty() || !b.isEmpty()) {
            if (a.isEmpty())
                System.out.println(b.poll());
            else if (b.isEmpty())
                System.out.println(a.poll());
            else if (a.peek() < b.peek())
                System.out.println(a.poll());
            else System.out.println(b.poll());
        }
    }

    public static void main(String[] args) {
        Deque<Integer> a = new LinkedList<Integer>();
        Deque<Integer> b = new LinkedList<Integer>();
        a.add(1);
        a.add(2);
        a.add(3);
        a.add(4);
        a.add(5);
        b.add(1);
        b.add(2);
        b.add(3);
        b.add(4);
        twoStream(a, b);
    }
}