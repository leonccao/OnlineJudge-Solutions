/*
### Corner cases
1. Input maybe empty
2. Only one people there, then he is celebrity
3. Celebrity may do not exist 

### Solution 
1. Solution
One variable "cand", if cand doesn't know B, B cannot be celebrity, everything fine. If cand knows B, cand is not celebrity anymore, B maybe celebrity, change value of cand to B.
Then check whether everybody knows cand and cand doesn't know any of them.

### Bugs

### Test cases


*/
/* The knows API is defined in the parent class Relation.
      boolean knows(int a, int b); */

      public class Solution extends Relation {
        public int findCelebrity(int n) {
            if (n == 0) return -1;
            
            int cand = 0;
            for (int i = 1; i < n; i ++) {
                if (knows(cand, i))
                    cand = i;
            }
            
            for (int i = 0; i < cand; i ++) {
                if (knows(cand, i))
                    return -1;
            }
            
            for (int i = 0; i < n; i ++) {
                if (i == cand) continue;
                if (!knows(i, cand))
                    return -1;
            }
            return cand;
        }
    }