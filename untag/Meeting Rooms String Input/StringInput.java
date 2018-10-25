public class StringInput {

    public class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

    public Interval translate(String input) {
        String[] splits = input.split("-");
        String start = splits[0].trim();
        String end   = splits[1].trim();
        return new Interval(convert(start), convert(end));
    }

    private int convert(String time) {
        boolean PM = false;
        if (time.charAt(time.length() - 1) == 'p') 
            PM = true;
        time = time.substring(0, time.length() - 1);
        String[] splits = time.split(":");
        int hour = Integer.parseInt(splits[0]);
        int minute = Integer.parseInt(splits[1]);
        if (PM && hour != 12) hour += 12;
        return hour * 60 + minute;
    }

    public void test() {
        String input = "01:34p - 02:59p";
        Interval result = translate(input);
        System.out.println(result.start + " " + result.end);
    }

    public static void main(String[] args) {
        StringInput sol = new StringInput();
        sol.test();
    }
}