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
    }