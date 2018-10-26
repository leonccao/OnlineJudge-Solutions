
class Solution {
    public int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);
    }
    
    private int helper(List<NestedInteger> lists, int depth) {
        int sum = 0;
        for (int i = 0; i < lists.size(); i ++) {
            NestedInteger list = lists.get(i);
            
            if (depth > 1 && i == 0) System.out.print("(");
            if (i > 0) System.out.print(" + ");
            
            if (list.isInteger()) {
                sum += list.getInteger() * depth;
                System.out.print(list.getInteger());
            } else sum += helper(list.getList(), depth + 1);
            
            if (depth > 1 && i == lists.size() - 1)
                System.out.print(") * " + depth);
        }
        return sum;
    }
    
    
}