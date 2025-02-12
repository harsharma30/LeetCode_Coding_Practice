class Solution {
    private int calculateDigitSum(int num) {
        int digitSum = 0;
        while (num > 0) {
            digitSum += num % 10;
            num /= 10;
        }
        return digitSum;
    }

    public int maximumSum(int[] nums) {
        Pair<Integer, Integer>[] digitSumPairs = new Pair[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int digitSum = calculateDigitSum(nums[i]);
            digitSumPairs[i] = new Pair<>(digitSum, nums[i]);
        }
        Arrays.sort(
            digitSumPairs,
            Comparator.comparing(Pair<Integer, Integer>::getKey).thenComparing(
                Pair<Integer, Integer>::getValue
            )
        );

        int maxPairSum = -1;
        for (int index = 1; index < digitSumPairs.length; index++) {
            int currentDigitSum = digitSumPairs[index].getKey();
            int previousDigitSum = digitSumPairs[index - 1].getKey();
            if (currentDigitSum == previousDigitSum) {
                int currentSum =
                    digitSumPairs[index].getValue() +
                    digitSumPairs[index - 1].getValue();
                maxPairSum = Math.max(maxPairSum, currentSum);
            }
        }

        return maxPairSum;
    }
}