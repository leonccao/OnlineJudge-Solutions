import java.util.Arrays;

public class TwoHeaviest {
    public static class Pair {
        double first;
        double second;
        Pair(double first, double second) {
            this.first = first;
            this.second = second;
        }
    }

    public static Pair solution(int numContainers, double maxCapacity, double[] containersWt) {
        Arrays.sort(containersWt);
        int r = numContainers - 1;
        double max = 0;
        Pair ans = null;
        for (int l = 0; l < r; l ++) {
            while (r > l && containersWt[l] + containersWt[r] > maxCapacity) r --;
            if (r > l && containersWt[l] + containersWt[r] > max) {
                max = containersWt[l] + containersWt[r];
                ans = new Pair(containersWt[l], containersWt[r]);
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int numContainers = 6;
        double maxCapacity = 33.3;
        double[] containersWt = {7.33, 8.13, 103.7313, 11.24, 23.79, 18.3501};
        Pair ans = solution(numContainers, maxCapacity, containersWt);
        System.out.println(ans.first + " " + ans.second);
    }
}
