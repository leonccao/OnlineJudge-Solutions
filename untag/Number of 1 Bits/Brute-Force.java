public class Solution {
	public int numSetBits(long a) {
	    int rtn = 0;
	    while (a > 0) {
	        if ((a & 1) == 1) rtn ++;
	        a >>= 1;
	    }
	    return rtn;
	}
}
