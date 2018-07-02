class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBill = 0, tenBill = 0, twenBill = 0;
        for (int bill : bills) {
            if (bill == 5) {
                fiveBill ++;
            } else if (bill == 10) {
                if (fiveBill < 1) return false;
                fiveBill --;
                tenBill ++;
            } else {
                if (!(fiveBill >= 3) && !(tenBill >= 1 && fiveBill >= 1)) return false;
                if (tenBill >= 1) {
                    tenBill --;
                    fiveBill --;
                } else fiveBill -= 3;
            }
        }
        return true;
    }
}