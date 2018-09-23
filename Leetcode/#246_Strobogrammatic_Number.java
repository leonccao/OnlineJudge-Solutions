/*
### Corner cases
1. When input is empty the answer is true

### Solution

### Bug
1. `setCharAt()` is only available in `StringBuilder`
2. Case sentence

### Test case

*/
class Solution {
    public boolean isStrobogrammatic(String num) {
        if (num.length() == 0 || num == null)
            return true;
        for (char ch : num.toCharArray()) {
            if (ch == '3') return false;
            if (ch == '4') return false;
            if (ch == '7') return false;
            if (ch == '2') return false;
            if (ch == '5') return false;
        }
        StringBuilder sb = new StringBuilder(num);
        sb.reverse();
        for (int i = 0; i < sb.length(); i ++) {
            char ch = sb.charAt(i);
            char sw = '$';
            switch (ch) {
                case '1': sw = '1'; break;
                case '6': sw = '9'; break;
                case '8': sw = '8'; break;
                case '9': sw = '6'; break;
                case '0': sw = '0'; break;
            }
            sb.setCharAt(i, sw);
        }
        if (num.equals(sb.toString())) return true;
        return false;
    }
}