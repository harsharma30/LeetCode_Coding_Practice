class Solution {

    public int minLength(String s) {
        // Continue processing while "AB" or "CD" substrings exist
        while (s.contains("AB") || s.contains("CD")) {
            if (s.contains("AB")) {
                // Remove all occurrences of "AB"
                s = s.replace("AB", "");
            } else if (s.contains("CD")) {
                // Remove all occurrences of "CD"
                s = s.replace("CD", "");
            }
        }

        return s.length();
    }
}
