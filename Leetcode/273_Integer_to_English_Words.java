class Solution {
    public String digitToWord(int digit) {
        switch (digit) {
            case 1: return "One";
            case 2: return "Two";
            case 3: return "Three";
            case 4: return "Four";
            case 5: return "Five";
            case 6: return "Six";
            case 7: return "Seven";
            case 8: return "Eight";
            case 9: return "Nine";
        }
        return "";
    }
    
    public String tenToWord(int ten) {
        switch (ten) {
            case 2: return "Twenty";
            case 3: return "Thirty";
            case 4: return "Forty";
            case 5: return "Fifty";
            case 6: return "Sixty";
            case 7: return "Seventy";
            case 8: return "Eighty";
            case 9: return "Ninety";
        }
        return "";
    }
    
    public String tensToWord(int tens) {
        switch (tens) {
            case 10: return "Ten";
            case 11: return "Eleven";
            case 12: return "Twelve";
            case 13: return "Thirteen";
            case 14: return "Fourteen";
            case 15: return "Fifteen";
            case 16: return "Sixteen";
            case 17: return "Seventeen";
            case 18: return "Eighteen";
            case 19: return "Nineteen";
        }
        return "";
    }
    
    public String partToWord(int part) {
        switch (part) {
            case 3: return "Billion";
            case 2: return "Million";
            case 1: return "Thousand";
        }
        return "";
    }
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        int[] stage = new int[4];
        int stg = 0, tmp = 0, cnt = 0;
        while (num > 0) {
            if (cnt == 3) {
                stage[stg ++] = tmp;
                tmp = cnt = 0;
            }
            tmp = tmp + num % 10 * (int)Math.pow(10, cnt ++);
            num /= 10;
        }
        stage[stg ++] = tmp;
        
        List<String> ans = new ArrayList<String>();       
        for (int part = stg - 1; part >= 0; part --) {
            tmp = stage[part];
            int hun = tmp / 100;
            int ten = tmp % 100 / 10;
            int one = tmp % 10;
            
            if (hun > 0) {
                ans.add(digitToWord(hun));
                ans.add("Hundred");
            }
            if (ten == 1)
                ans.add(tensToWord(ten * 10 + one));
            else {
                if (ten > 1)
                    ans.add(tenToWord(ten));
                if (one > 0)
                    ans.add(digitToWord(one));
            }
            if (tmp > 0 && part > 0)
                ans.add(partToWord(part));
        }
        return String.join(" ", ans);
    }
}

class Solution {
    final static String[] HUNDS = {"Hundred", "Thousand", "Million", "Billion"};
    final static String[] ONES  = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        long number = num;
        boolean minus = false;
        if (num < 0) {
            minus = true;
            number = -number;
        }
        
        List<String> ans = new ArrayList<String>();
        for (int cnt = 0; number > 0; cnt ++) {
            int hund = (int)(number % 1000);
            if (hund > 0) {
                if (cnt > 0) ans.add(HUNDS[cnt]);
                
                // one and ten bits
                int ten = hund % 100;
                if (ten > 0) {
                    if (ten < 20) ans.add(ONES[ten]);
                    else {
                        if (ten % 10 > 0)
                            ans.add(ONES[ten % 10]);
                        ans.add(TENS[ten / 10]);
                    }
                }

                // hundred bit
                if (hund > 99) {
                    ans.add(HUNDS[0]);
                    ans.add(ONES[hund / 100]);
                }
            }
            
            number /= 1000;
        }
        
        if (minus) ans.add("Negative");
        Collections.reverse(ans);
        return String.join(" ", ans);
    }
}

class Solution {    
    final static String[] HUNDS = {"Hundred", "Thousand", "Million", "Billion"};
    final static String[] ONES  = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        
        boolean negative = false;
        long n = num;
        if (num < 0) {
            negative = true;
            n = -n;
        }
        
        List<String> ans = new ArrayList<String>();
        int cnt = -1;
        while (n > 0) {
            int hunds = (int)(n % 1000);
            n /= 1000; ++ cnt;
            if (hunds == 0) continue;
            if (cnt > 0) ans.add(HUNDS[cnt]);
            
            int tens = hunds % 100;
            if (tens > 0 && tens < 20) ans.add(ONES[tens]);
            else {
                if (tens % 10 > 0) ans.add(ONES[tens % 10]);
                if (tens / 10 > 0) ans.add(TENS[tens / 10]);
            }
            if (hunds / 100 > 0) {
                ans.add(HUNDS[0]);
                ans.add(ONES[hunds / 100]);
            }
        }
        
        if (negative) ans.add("Negative");
        Collections.reverse(ans);
        return String.join(" ", ans);
    }
}

class Solution {
    final static int[] POW10 = {1, 10, 100, 1000, 0, 0, 1000000, 0, 0, 1000000000};
    final static String[] ONES  = {"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    final static String[] TENS = {"", "", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};
    
    public String numberToWords(int num) {
        if (num == 0) return "Zero";
        boolean negative = false;
        long n = num;
        if (num < 0) {
            negative = true;
            n = -n;
        }
        
        String rtn = helper(n);
        return negative ? "Negative " + rtn : rtn;
    }
    
    private String helper(long n) {
        String rtn = "";
        if (n < 20) rtn = ONES[(int)n];
        else if (n < POW10[2]) rtn = TENS[(int)n / POW10[1]] + " " + ONES[(int)n % POW10[1]];
        else if (n < POW10[3]) rtn = ONES[(int)n / POW10[2]] + " Hundred " + helper(n % POW10[2]);
        else if (n < POW10[6]) rtn = helper(n / POW10[3]) + " Thousand " + helper(n % POW10[3]);
        else if (n < POW10[9]) rtn = helper(n / POW10[6]) + " Million " + helper(n % POW10[6]);
        else rtn = helper(n / POW10[9]) + " Billion " + helper(n % POW10[9]);
        return rtn.trim();
    }
}