import java.util.*;

public class StringComparator {

    static class stringComparator implements Comparator<String> {
        @Override
        public int compare(String a, String b) {
            int i = 0, j = 0;
            while (i < a.length() && j < b.length()) {
                if (Character.isLetter(a.charAt(i)) || Character.isLetter(b.charAt(j))) {
                    if (a.charAt(i) == b.charAt(j)) {
                        i ++; j ++;
                        continue;
                    }
                    return a.charAt(i) - b.charAt(j);
                }
                
                StringBuilder sa = new StringBuilder();
                StringBuilder sb = new StringBuilder();
                while (i < a.length() && Character.isDigit(a.charAt(i)))
                    sa.append(a.charAt(i ++));
                while (j < b.length() && Character.isDigit(b.charAt(j)))
                    sb.append(b.charAt(j ++));
                long na = Long.parseLong(sa.toString());
                long nb = Long.parseLong(sb.toString());
                if (na == nb) continue;
                if (na < nb) return -1;
                return 1;
            }
            if (i < a.length()) return 1;
            if (j < b.length()) return -1;
            return 0;
        }
    }

    public static void main(String[] args) {
        String[] files = {"input1test3", "input10test", "input2", "inputt", "input01test2"};
        Arrays.sort(files, new stringComparator());
        for (String file : files)
            System.out.println(file);
    }
}