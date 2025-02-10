class Solution {

    public String clearDigits(String s) {
        int charIndex = 0;

        StringBuilder sb = new StringBuilder(s);
        while (charIndex < sb.length()) {
            if (Character.isDigit(sb.charAt(charIndex))) {
                sb.deleteCharAt(charIndex);
                if (charIndex > 0) {
                    sb.deleteCharAt(charIndex - 1);
                    charIndex--;
                }
            } else {
                charIndex++;
            }
        }
        return sb.toString();
    }
}