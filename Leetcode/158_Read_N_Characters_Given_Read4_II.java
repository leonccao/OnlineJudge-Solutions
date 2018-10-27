/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

      public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
        private int left = 0, limit = 0;
        private char[] tmp = new char[4];
        
        public int read(char[] buf, int n) {
            
            // read the incomplete chars from past
            int cnt = 0;
            if (left > 0) {
                cnt = Math.min(left, n);
                for (int i = 0; i < cnt; i ++)
                    buf[i] = tmp[limit - left + i];
                left -= cnt;
            }
            
            int last = 4;
            while (cnt < n && last == 4) {
                int len = read4(tmp);
                last = Math.min(len, n - cnt);
                for (int i = 0; i < last; i ++)
                    buf[cnt + i] = tmp[i];
                cnt += last;
                if (last < len) {
                    left = len - last;
                    limit = len;
                    break;
                } 
            }
            return cnt;
        }
    }/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    int bufcnt = 0, bufpos = 0;
    char[] buffer = new char[4];
    
    public int read(char[] buf, int n) {
        int pos = 0;
        while (pos < n) {
            if (bufcnt == bufpos) {
                bufcnt = read4(buffer);
                bufpos = 0;
            }
            if (bufcnt == 0) break;
            while (pos < n && bufpos < bufcnt)
                buf[pos ++] = buffer[bufpos ++];
        }
        return pos;
    }
}

// new
public class Solution extends Reader4 {
    /**
     * @param buf Destination buffer
     * @param n   Maximum number of characters to read
     * @return    The number of characters read
     */
    
    int bufSize = 0, bufPos = 0;
    char[] buffer = new char[4];
    
    public int read(char[] buf, int n) {
        int cnt = 0;
        while (cnt < n) {
            if (bufPos == bufSize) {
                bufSize = read4(buffer);
                bufPos = 0;
            }
            if (bufSize == 0) return cnt;
            while (cnt < n && bufPos < bufSize) 
                buf[cnt ++] = buffer[bufPos ++];
        }
        return n;
    }
}