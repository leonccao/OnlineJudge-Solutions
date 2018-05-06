class Solution {
    public String maskPII(String S) {
        if (S.indexOf('@') > -1) {
            S = S.trim().toLowerCase();
            int pos = S.indexOf('@');
            StringBuilder sb = new StringBuilder();
            sb.append(S.charAt(0));
            sb.append("*****");
            sb.append(S.substring(pos - 1, S.length()));
            return sb.toString();
        } else {
            List<Integer> nums = new ArrayList<Integer>();
            for (char ch : S.toCharArray())
                if (ch >= '0' && ch <= '9')
                    nums.add(ch - '0');
            StringBuilder sb = new StringBuilder();
            if (nums.size() > 10) {
                sb.append('+');
                for (int i = 0; i < nums.size() - 10; i ++)
                    sb.append("*");
                sb.append('-');
            }
            for (int i = 0; i < 3; i ++)
                sb.append('*');
            sb.append('-');
            for (int i = 0; i < 3; i ++)
                sb.append('*');
            sb.append('-');
            for (int i = nums.size() - 4; i < nums.size(); i ++)
                sb.append(nums.get(i));
            return sb.toString();
        }
    }
}