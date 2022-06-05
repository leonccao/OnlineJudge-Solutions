import java.time.LocalDate;
import java.time.DayOfWeek;

class Solution {
    public String dayOfTheWeek(int day, int month, int year) {
        LocalDate localDate = LocalDate.of(year, month, day);
        DayOfWeek dayOfWeek = localDate.getDayOfWeek();
        String ans = dayOfWeek.toString();
        return ans.charAt(0) + ans.substring(1, ans.length()).toLowerCase();
    }
}