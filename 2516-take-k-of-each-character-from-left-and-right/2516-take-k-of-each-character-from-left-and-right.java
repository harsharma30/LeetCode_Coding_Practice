class Solution {
    public int takeCharacters(String s, int k) {
        int[] freq = new int[3];
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
        }
        if (min3(freq[0], freq[1], freq[2]) < k)
            return -1;
        int steps = Integer.MAX_VALUE, l = 0, n = s.length();
        for (int r = 0; r < n; r++) {
            freq[s.charAt(r) - 'a']--;
            while (l < n && min3(freq[0], freq[1], freq[2]) < k) {
                freq[s.charAt(l) - 'a']++;
                l++;
            }
            steps = Math.min(steps, n - (r - l + 1));
        }
        return steps;
    }
    private int min3(int x, int y, int z) {
        return Math.min(x, Math.min(y, z));
    }
}