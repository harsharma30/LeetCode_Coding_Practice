class Solution {

    public int[] smallestRange(List<List<Integer>> nums) {
        int k = nums.size();
        // Stores the current index of each list
        int[] indices = new int[k];
        // To track the smallest range
        int[] range = new int[] { 0, Integer.MAX_VALUE };

        while (true) {
            int curMin = Integer.MAX_VALUE, curMax =
                Integer.MIN_VALUE, minListIndex = 0;

            // Find the current minimum and maximum values across the lists
            for (int i = 0; i < k; i++) {
                int currentElement = nums.get(i).get(indices[i]);

                // Update the current minimum
                if (currentElement < curMin) {
                    curMin = currentElement;
                    minListIndex = i;
                }

                // Update the current maximum
                if (currentElement > curMax) {
                    curMax = currentElement;
                }
            }

            // Update the range if a smaller one is found
            if (curMax - curMin < range[1] - range[0]) {
                range[0] = curMin;
                range[1] = curMax;
            }

            // Move to the next element in the list that had the minimum value
            if (++indices[minListIndex] == nums.get(minListIndex).size()) break;
        }

        return range;
    }
}