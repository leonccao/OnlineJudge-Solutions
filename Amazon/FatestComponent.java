import java.util.ArrayList;

public class FatestComponent {
    public static class ComponentNode {
        public int value;
        public ArrayList<ComponentNode> components;
        public ComponentNode() {
            components = new ArrayList<ComponentNode>();
        }
        public ComponentNode(int numOfLinesChanged) {
            this.value = numOfLinesChanged;
            this.components = new ArrayList<ComponentNode>();
        }
    }

    public static class Subtree {
        int size, sum;
        public Subtree(int size, int sum) {
            this.size = size;
            this.sum = sum;
        }
    }

    public static ComponentNode solution(ComponentNode root) {
        calculate(root);
        return ans;
    }

    static double max = Double.MIN_VALUE;
    static ComponentNode ans = null;

    public static Subtree calculate(ComponentNode root) {
        Subtree cur = new Subtree(1, root.value);
        for (ComponentNode component : root.components) {
            Subtree child = calculate(component);
            cur.size += child.size;
            cur.sum += child.sum;
        }
        if (root.components.size() > 0) {
            double tmp = cur.sum * 1.0 / cur.size;
            if (tmp > max) {
                max = tmp;
                ans = root;
            }
            System.out.println(root.value + " " + tmp);
        }
        return cur;
    }

    public static void main(String[] args) {
        ComponentNode n3 = new ComponentNode(110);
        ComponentNode n4 = new ComponentNode(20);
        ComponentNode n5 = new ComponentNode(30);
        ComponentNode n6 = new ComponentNode(150);
        ComponentNode n7 = new ComponentNode(80);
        ComponentNode n1 = new ComponentNode(120);
        n1.components.add(n3);
        n1.components.add(n4);
        n1.components.add(n5);
        ComponentNode n2 = new ComponentNode(180);
        n2.components.add(n6);
        n2.components.add(n7);
        ComponentNode n0 = new ComponentNode(200);
        n0.components.add(n1);
        n0.components.add(n2);

        ComponentNode res = solution(n0);
        System.out.println(res.value);
    }
}
