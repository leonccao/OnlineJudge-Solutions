class Solution {
    public List<String> readBinaryWatch(int num) {
        List<String> result = new ArrayList<String>();
        for (int hr = 0; hr < 12; hr ++)
            for (int mi = 0; mi < 60; mi ++ ) {
                int tmp = bits(hr) + bits(mi);
                if (tmp != num) continue;
                String s = "";
                if (mi < 10)
                    s = Integer.toString(hr) + ":0" + Integer.toString(mi);
                else s = Integer.toString(hr) + ":" + Integer.toString(mi);
                result.add(s);
            }
        return result;
    }
    
    public int bits(int time) {
        int result = 0;
        while (time > 0) {
            if (time % 2 == 1)
                result ++;
            time /= 2;
        }
        return result;
    }
}