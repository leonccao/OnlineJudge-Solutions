class Solution {
    public int lcm(int a, int b) {
        return a * b / gcd(a, b);
    }
    
    public int gcd(int a, int b) {
        int m = a % b;
        while (m != 0) {
            a = b;
            b = m;
            m = a % b;
        }
        return b;
    }
    
    public String largestNumber(int[] nums) {
        String[] s = new String[nums.length];
        for (int i = 0; i < s.length; i ++)
            s[i] = Integer.valueOf(nums[i]).toString();
        Arrays.sort(s, new Comparator<String>() {
            public int compare(String a, String b) {
                int len = lcm(a.length(), b.length());
                for (int i = 0; i < len; i ++) {
                    char ca = a.charAt(i % a.length());
                    char cb = b.charAt(i % b.length());
                    if (ca != cb) return cb - ca;
                }
                return 0;
            }
        });
        StringBuilder sb = new StringBuilder();
        for (String t : s)
            sb.append(t);
        String answer = sb.toString();
        if (answer.charAt(0) == '0')
            return "0";
        else return answer;
    }
}