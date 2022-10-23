class Solution {
    public boolean haveConflict(String[] event1, String[] event2) {
        int startA = stringToInt(event1[0]);
        int endA = stringToInt(event1[1]);
        int startB = stringToInt(event2[0]);
        int endB = stringToInt(event2[1]);
        
        if (startB >= startA && startB <= endA) {
            return true;
        }
        
        if (endB >= startA && endB <= endA) {
            return true;
        }
        
        if (startA >= startB && startA <= endB) {
            return true;
        }
        
        if (endA >= startB && endA <= endB) {
            return true;
        }
        
        return false;
    }
    
    int stringToInt(String s) {
        s = s.replace(":", "");
        return Integer.valueOf(s);
    }
}