class Solution {
    public String decodeMessage(String key, String message) {
        char[] table = new char[27];
        for (int i = 0; i < 26; i++) {
            table[i] = ' ';
        }
        int index = 0;
        for (char ch : key.toCharArray()) {
            if (ch == ' ') {
                continue;
            }
            if (table[ch - 'a'] == ' ') {
                char temp = 'a';
                temp += index++;
                table[ch - 'a'] = temp;
            }
        }
        
        
        StringBuilder sb = new StringBuilder();
        for (char ch : message.toCharArray()) {
            if (ch == ' ') {
                sb.append(' ');
                continue;
            }
            sb.append(table[ch - 'a']);
        }
        return sb.toString();
    }
}