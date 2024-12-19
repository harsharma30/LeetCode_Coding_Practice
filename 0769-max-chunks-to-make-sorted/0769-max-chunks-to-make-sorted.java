class Solution {

    public int maxChunksToSorted(int[] arr) {
        int n = arr.length;
        int[] prefixMax = arr.clone();
        int[] suffixMin = arr.clone();

        for (int i = 1; i < n; i++) {
            prefixMax[i] = Math.max(prefixMax[i - 1], prefixMax[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            suffixMin[i] = Math.min(suffixMin[i + 1], suffixMin[i]);
        }

        int chunks = 0;
        for (int i = 0; i < n; i++) {
            if (i == 0 || suffixMin[i] > prefixMax[i - 1]) {
                chunks++;
            }
        }

        return chunks;
    }
}