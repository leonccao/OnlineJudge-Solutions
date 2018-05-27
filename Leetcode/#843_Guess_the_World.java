/**
 * // This is the Master's API interface.
 * // You should not implement it, or speculate about its implementation
 * interface Master {
 *     public int guess(String word) {}
 * }
 */
class Solution {
    
    public int compare(String a, String b) {
        int same = 0;
        for (int i = 0; i < 6; i ++)
            if (a.charAt(i) == b.charAt(i))
                same ++;
        return same;
    }
    
    public void findSecretWord(String[] wordlist, Master master) {
        Map<String, Integer> map = new HashMap<String, Integer>();
        Arrays.sort(wordlist);
        
        Work:
        for (String word : wordlist) {
            // System.out.println(word);
            for (String sample : map.keySet()) {
                // System.out.println("Sample " + sample + " " + map.get(sample) + " " + compare(word, sample));
                if (compare(word, sample) != map.get(sample))
                    continue Work;
            }
            int tmp = master.guess(word);
            map.put(word, tmp);
            if (tmp == 6) return;
        }
        return;
    }
}