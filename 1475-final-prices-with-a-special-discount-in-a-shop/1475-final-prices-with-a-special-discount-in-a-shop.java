class Solution {

    public int[] finalPrices(int[] prices) {
        int n = prices.length;
        // Create a copy of original prices array to store discounted prices
        int[] result = prices.clone();

        for (int i = 0; i < n; i++) {
            // Look for first smaller or equal price that comes after current item
            for (int j = i + 1; j < n; j++) {
                if (prices[j] <= prices[i]) {
                    // Apply discount by subtracting prices[j] from current price
                    result[i] = prices[i] - prices[j];
                    break;
                }
            }
        }

        return result;
    }
}