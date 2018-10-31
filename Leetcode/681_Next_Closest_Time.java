class Solution {
    public String nextClosestTime(String time) {
        char[] digits = new char[] {time.charAt(0), time.charAt(1), time.charAt(3), time.charAt(4)};
        
        int min = Integer.MAX_VALUE, larger = Integer.MAX_VALUE;
        String minRec = "", largerRec = "";
        int base = Integer.parseInt(time.substring(0, 2) + time.substring(3, 5));
        
        for (int i = 0; i < 4; i ++)
            for (int j = 0; j < 4; j ++) {
                String hourExp = "" + digits[i] + digits[j];
                int hour = Integer.parseInt(hourExp);
                if (hour > 23) continue;
                
                for (int k = 0; k < 4; k ++)
                    for (int l = 0; l < 4; l ++) { 
                        String minExp = "" + digits[k] + digits[l];
                        int minute = Integer.parseInt(minExp);
                        if (minute > 59) continue;
                        
                        String exp = hourExp + ":" + minExp;
                        int value = hour * 100 + minute;
                        if (value < min) {
                            min = value;
                            minRec = exp;
                        }
                        if (value > base && value < larger) {
                            larger = value;
                            largerRec = exp;
                        }
                    }
            }
        if (larger < Integer.MAX_VALUE) return largerRec;
        return minRec;
    }
}