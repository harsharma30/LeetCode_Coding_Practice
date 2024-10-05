class Solution {
    public boolean checkInclusion(String s1, String s2) {
        // Edge case: if s1 is longer than s2, no permutation is possible
        if (s1.length() > s2.length()) {
            return false;
        }

        // Frequency array for s1 and the first window of s2
        int[] s1Freq = new int[26];
        int[] windowFreq = new int[26];

        // Fill the frequency array for s1
        for (int i = 0; i < s1.length(); i++) {
            s1Freq[s1.charAt(i) - 'a']++;
            windowFreq[s2.charAt(i) - 'a']++;
        }

        // Check the first window before sliding
        if (matches(s1Freq, windowFreq)) {
            return true;
        }

        // Sliding window over s2
        for (int i = s1.length(); i < s2.length(); i++) {
            // Slide the window: remove the character going out and add the new character
            windowFreq[s2.charAt(i) - 'a']++;  // Add new character
            windowFreq[s2.charAt(i - s1.length()) - 'a']--;  // Remove old character

            // Check if the current window matches
            if (matches(s1Freq, windowFreq)) {
                return true;
            }
        }

        // If no matching window is found, return false
        return false;
    }

    // Helper function to compare two frequency arrays
    private boolean matches(int[] s1Freq, int[] windowFreq) {
        for (int i = 0; i < 26; i++) {
            if (s1Freq[i] != windowFreq[i]) {
                return false;
            }
        }
        return true;
    }
}