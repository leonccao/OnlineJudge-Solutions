class Solution {
    
    private class Node {
        String name;
        int height;
        Node(String name, int height) {
            this.name = name;
            this.height = height;
        }
    }
    
    public String[] sortPeople(String[] names, int[] heights) {
        Node[] a = new Node[names.length];
        for (int i = 0; i < names.length; i++) {
            a[i] = new Node(names[i], heights[i]);
        }
        Arrays.sort(a, (v, b) -> b.height - v.height);
        for (int i = 0; i < names.length; i++) {
            names[i] = a[i].name;
        }
        return names;
    }
}