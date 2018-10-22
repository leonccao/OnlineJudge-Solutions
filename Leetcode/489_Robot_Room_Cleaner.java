/*
### Corner cases

### Solution
1. DFS

### Bugs
1. typo
2. `robot.clean()`

### Test cases

*/
/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */
class Solution {
    final static int[][] MV = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    
    private void sweep(Robot robot, int x, int y, int dir, Set<String> visited) {
        robot.clean();
        visited.add(x + " " + y);
        for (int turn = 0; turn < 4; turn ++) {
            int dirCur = (dir + turn) % 4;
            int p = x + MV[dirCur][0];
            int q = y + MV[dirCur][1];
            if (!visited.contains(p + " " + q) && robot.move()) {
                sweep(robot, p, q, dirCur, visited);
                robot.turnRight();
                robot.turnRight();
                robot.move();
                robot.turnRight();
                robot.turnRight();
            }
            robot.turnRight();
        }
    }
    
    public void cleanRoom(Robot robot) {
        sweep(robot, 0, 0, 0, new HashSet<String>());
    }
}