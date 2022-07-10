/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    static final int[][] MV = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    
    public int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        
        int i = 0, j = 0;
        int dir = 0;
        for (ListNode cur = head; cur != null; cur = cur.next) {
            matrix[i][j] = cur.val;
            int ni = i + MV[dir][0];
            int nj = j + MV[dir][1];
            if (ni < 0 || ni >= m || nj < 0 || nj >= n || matrix[ni][nj] != -1) {
                dir = (dir + 1) % 4;
                
                ni = i + MV[dir][0];
                nj = j + MV[dir][1];
            }
            i = ni;
            j = nj;
        }
        return matrix;
    }
}