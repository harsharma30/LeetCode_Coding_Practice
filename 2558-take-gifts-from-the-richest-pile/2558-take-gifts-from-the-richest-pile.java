public class Solution {

    public long pickGifts(int[] gifts, int k) {
        int n = gifts.length;

        for (int i = 0; i < k; i++) {
            int richestPileIndex = 0;
            for (
                int currentPileIndex = 0;
                currentPileIndex < n;
                currentPileIndex++
            ) {
                if (gifts[richestPileIndex] < gifts[currentPileIndex]) {
                    richestPileIndex = currentPileIndex;
                }
            }

            gifts[richestPileIndex] = (int) Math.floor(
                Math.sqrt(gifts[richestPileIndex])
            );
        }

        long numberOfRemainingGifts = Arrays.stream(gifts)
            .mapToLong(gift -> gift)
            .sum();

        return numberOfRemainingGifts;
    }
}