class Solution {

    public int maximumCandies(int[] candies, long k) {
        int maxCandiesInPile = 0;
        for (int i = 0; i < candies.length; i++) {
            maxCandiesInPile = Math.max(maxCandiesInPile, candies[i]);
        }

        int left = 0;
        int right = maxCandiesInPile;

        while (left < right) {
            int middle = (left + right + 1) / 2;

            if (canAllocateCandies(candies, k, middle)) {
                left = middle;
            } else {
                right = middle - 1;
            }
        }

        return left;
    }

    private boolean canAllocateCandies(
        int[] candies,
        long k,
        int numOfCandies
    ) {
        long maxNumOfChildren = 0;

        for (int pileIndex = 0; pileIndex < candies.length; pileIndex++) {
            maxNumOfChildren += candies[pileIndex] / numOfCandies;
        }

        return maxNumOfChildren >= k;
    }
}