class Solution {
    
    final static int[] DAYS = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
    
    public int countDaysTogether(String arriveAlice, String leaveAlice, String arriveBob, String leaveBob) {
        
        int aa = getDayOfYear(arriveAlice);
        int la = getDayOfYear(leaveAlice);
        int ab = getDayOfYear(arriveBob);
        int lb = getDayOfYear(leaveBob);
        
        return Math.max(0, Math.min(la, lb) - Math.max(aa, ab) + 1);
    }
    
    private int getDayOfYear(String day) {
        
        String monthStr = day.substring(0, 2);
        String dateStr = day.substring(3, 5);
        
        int month = Integer.valueOf(monthStr);
        int date = Integer.valueOf(dateStr);
        
        int sum = 0;
        for (int i = 0; i < month - 1; i++) {
            sum += DAYS[i];
        }
        return sum + date;
    }
}