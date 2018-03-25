class Solution {
    final static String[] table = {".-","-...","-.-.","-..",".","..-.","--.","....","..",".---","-.-",".-..","--","-.","---",".--.","--.-",".-.","...","-","..-","...-",".--","-..-","-.--","--.."};
    public int uniqueMorseRepresentations(String[] words) {
        HashSet<String> set = new HashSet<String>();
        int result = 0;
        for (String s : words) {
            s = s.toLowerCase();
            String tmp = "";
            for (int i = 0; i < s.length(); i ++)
                tmp += table[s.charAt(i) - 'a'];
            if (!set.contains(tmp)) {
                set.add(tmp);
                result ++;
            }
        }
        return result;
    }
}