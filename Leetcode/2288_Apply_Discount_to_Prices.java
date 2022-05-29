class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split("\\s+");
        
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            if (sb.length() > 0) {
                sb.append(' ');
            }
            
            long price = isPrice(word);
            if (price < 0) {
                sb.append(word);
            } else {
                double priceDis = price / 100.0 * (100 - discount);
                String priceDisStr = "$" + String.format("%.2f", priceDis);
                sb.append(priceDisStr);
            }
        }
        return sb.toString();
    }
    
    private long isPrice(String word) {
        if (word.charAt(0) != '$' || word.length() < 2) {
            return -1;
        }
        
        try {
            return Long.parseLong(word.substring(1, word.length()));
        } catch (NumberFormatException e) {
            return -1;
        }
    }
}