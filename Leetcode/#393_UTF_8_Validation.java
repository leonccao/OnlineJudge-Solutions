class Solution {
    public boolean validUtf8(int[] data) {
        int len = data.length;
        String[] utf = new String[len];
        int base = (1 << 8) - 1;
        for (int i = 0; i < len; i ++) {
            utf[i] = Integer.toBinaryString(data[i] & base);
            while (utf[i].length() < 8)
                utf[i] = "0" + utf[i];
        }
        return valid(utf, 0, utf.length);
    }
    
    private boolean valid(String[] utf, int start, int end) {
        int len = end - start, cnt = 0;
        for (int i = 0; i < 8; i ++)
            if (utf[start].charAt(i) == '1')
                cnt ++;
            else break;
        
        if (cnt == 1) return false;
        if (cnt == 0) cnt ++;
        if (cnt > 4) return false;
        if (cnt > len) return false;
        for (int i = start + 1; i < start + cnt; i ++)
            if (utf[i].charAt(0) != '1' ||
                utf[i].charAt(1) != '0')
                    return false;
        if (cnt == len) return true;
        return valid(utf, start + cnt, end);
    }
}