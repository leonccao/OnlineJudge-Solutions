class Solution {
    public String similarRGB(String color) {
        String result = "#";
        for (int i = 1; i < 7; i += 2) {
            String st = color.substring(i, i + 2);
            Integer target = Integer.parseInt(st, 16);
            Integer minn = 1234567, ans = -1;
            for (int j = 0; j < 16; j ++) {
                Integer now = j * 16 + j;
                if (Math.abs(now - target) < minn) {
                    minn = Math.abs(now - target);
                    ans = Integer.valueOf(j);
                }
            }
            result += Integer.toHexString(ans);
            result += Integer.toHexString(ans);
        }
        return result;
    }
}