class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (numRows == 0) return result;
        List<Integer> row = new ArrayList<Integer>();
        row.add(1);
        result.add(row);
        for (int i = 1; i < numRows; i ++) {
            List<Integer> rowLast = result.get(i - 1);
            List<Integer> rowNow  = new ArrayList<Integer>();
            rowNow.add(1);
            for (int j = 0; j < rowLast.size() - 1; j ++) 
                rowNow.add(rowLast.get(j) + rowLast.get(j + 1));
            rowNow.add(1);
            result.add(rowNow);
        }
        return result;
    }
}