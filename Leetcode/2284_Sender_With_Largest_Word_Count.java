class Solution {
    public String largestWordCount(String[] messages, String[] senders) {
        Map<String, Integer> map = new HashMap<>();
        int max = Integer.MIN_VALUE;
        String maxSender = "";
        for (int i = 0; i < senders.length; i++) {
            String sender = senders[i];
            int count = messages[i].split(" ").length;
            int accCnt = map.getOrDefault(sender, 0);
            accCnt += count;
            map.put(sender, accCnt);
            
            if (accCnt > max || (accCnt == max && sender.compareTo(maxSender) > 0)) {
                max = accCnt;
                maxSender = sender;
            }
        }
        return maxSender;
    }
}