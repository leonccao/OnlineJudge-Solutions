class Solution {
    public int candy(int[] ratings) {
        if (ratings.length < 1) return 0;
        int[] tag = new int[ratings.length];
        tag[0] = 1;
        for (int i = 1; i < ratings.length; i ++) {
            tag[i] = 1;
            if (ratings[i] > ratings[i - 1])
                tag[i] = tag[i - 1] + 1;
        }
        int sum = tag[ratings.length - 1];
        for (int i = ratings.length - 2; i >= 0; i --) {
            if (ratings[i] > ratings[i + 1] && tag[i] <= tag[i + 1])
                tag[i] = tag[i + 1] + 1;
            sum += tag[i];
        }
        return sum;
    }
}