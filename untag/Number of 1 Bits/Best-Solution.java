public class Solution {
	public int numSetBits(long a) {
	    int rtn = 0;
	    while (a > 0) {
	        a &= (a - 1);
	        rtn ++;
	    }
	    return rtn;
	}
}
