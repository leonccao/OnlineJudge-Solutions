import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Collections;

public class HighestFive {
    public static class ReviewScore {
        int id;
        double value;
        public ReviewScore(int id, double value) {
            this.id = id;
            this.value = value;
        }
    }

    public static List<ReviewScore> solution(List<ReviewScore> reviews) {
        Map<Integer, List> map = new HashMap<>();
        for (ReviewScore review : reviews) {
            if (!map.containsKey(review.id))
                map.put(review.id, new ArrayList<>());
            map.get(review.id).add(review.value);
        }
        List<ReviewScore> ans = new ArrayList<>();
        for (int id : map.keySet()) {
            List<Double> list = map.get(id);
            Collections.sort(list, Collections.reverseOrder());
            double sum = 0;
            for (int i = 0; i < 5; i ++)
                sum += list.get(i);
            sum /= 5;
            ans.add(new ReviewScore(id, sum));
        }
        return ans;
    }

    public static void main(String[] args) {
        List<ReviewScore> reviews = new ArrayList<>();
        reviews.add(new ReviewScore(1, 1));
        reviews.add(new ReviewScore(2, 2));
        reviews.add(new ReviewScore(1, 3));
        reviews.add(new ReviewScore(2, 4));
        reviews.add(new ReviewScore(1, 5));
        reviews.add(new ReviewScore(2, 6));
        reviews.add(new ReviewScore(1, 7));
        reviews.add(new ReviewScore(2, 8));
        reviews.add(new ReviewScore(1, 9));
        reviews.add(new ReviewScore(2, 10));
        reviews.add(new ReviewScore(1, 11));
        reviews.add(new ReviewScore(2, 12));
        List<ReviewScore> ans = solution(reviews);
        for (ReviewScore review : ans) {
            System.out.println(review.id + " " + review.value);
        }
    }
}
