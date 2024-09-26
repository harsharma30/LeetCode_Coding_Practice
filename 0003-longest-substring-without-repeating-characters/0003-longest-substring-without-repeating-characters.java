class Solution {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        int start = 0, end = 0, maxLength = 0;
        Set<Character> seen = new HashSet<>();

        while (end < n) {
            char c = s.charAt(end);
            if (!seen.contains(c)) {
                seen.add(c);
                end++;
                maxLength = Math.max(maxLength, end - start);
            } else {
                seen.remove(s.charAt(start));
                start++;
            }
        }

        return maxLength;
    }
}