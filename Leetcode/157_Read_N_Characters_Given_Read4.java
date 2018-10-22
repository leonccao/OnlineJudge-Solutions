/* The read4 API is defined in the parent class Reader4.
      int read4(char[] buf); */

      public class Solution extends Reader4 {
        /**
         * @param buf Destination buffer
         * @param n   Maximum number of characters to read
         * @return    The number of characters read
         */
        public int read(char[] buf, int n) {
            int cnt = 0, last = 4;
            while (cnt < n && last == 4) {
                char[] tmp = new char[4];
                last = Math.min(read4(tmp), n - cnt);
                for (int i = 0; i < last; i ++)
                    buf[cnt + i] = tmp[i];
                cnt += last;
            }
            return cnt;
        }
    }