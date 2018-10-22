class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> row = new LinkedList<Integer>();
        row.add(1);
        for (int i = 1; i <= rowIndex; i ++) {
            int tmpLast = 0, tmpNow = 0;
            for (int j = 0; j < row.size(); j ++) {
                tmpNow = row.get(j) + tmpLast;
                tmpLast = row.get(j);
                row.set(j, tmpNow);
            }
            row.add(1);
        }
        return row;
    }
}