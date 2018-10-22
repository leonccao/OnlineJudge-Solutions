class Solution {
    public int minimumLengthEncoding(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            public int compare(String a, String b) {
                return b.length() - a.length();
            }
        });
        int ans = 0;
        for (int i = 0; i < words.length; i ++) {
            int lenAdd = words[i].length() + 1;
            for (int j = 0; j < i; j ++) {
                if (words[j].endsWith(words[i]))
                    lenAdd = 0;
            }
            ans += lenAdd;
        }
        return ans;
    }
}