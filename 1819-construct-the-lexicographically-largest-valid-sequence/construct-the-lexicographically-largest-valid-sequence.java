public class Solution {

    public int[] constructDistancedSequence(int targetNumber) {
        int[] resultSequence = new int[targetNumber * 2 - 1];
        boolean[] isNumberUsed = new boolean[targetNumber + 1];
        findLexicographicallyLargestSequence(
            0,
            resultSequence,
            isNumberUsed,
            targetNumber
        );

        return resultSequence;
    }
    private boolean findLexicographicallyLargestSequence(
        int currentIndex,
        int[] resultSequence,
        boolean[] isNumberUsed,
        int targetNumber
    ) {
        if (currentIndex == resultSequence.length) {
            return true;
        }
        if (resultSequence[currentIndex] != 0) {
            return findLexicographicallyLargestSequence(
                currentIndex + 1,
                resultSequence,
                isNumberUsed,
                targetNumber
            );
        }
        for (
            int numberToPlace = targetNumber;
            numberToPlace >= 1;
            numberToPlace--
        ) {
            if (isNumberUsed[numberToPlace]) continue;

            isNumberUsed[numberToPlace] = true;
            resultSequence[currentIndex] = numberToPlace;
            if (numberToPlace == 1) {
                if (
                    findLexicographicallyLargestSequence(
                        currentIndex + 1,
                        resultSequence,
                        isNumberUsed,
                        targetNumber
                    )
                ) {
                    return true;
                }
            }
            else if (
                currentIndex + numberToPlace < resultSequence.length &&
                resultSequence[currentIndex + numberToPlace] == 0
            ) {
                resultSequence[currentIndex + numberToPlace] = numberToPlace;

                if (
                    findLexicographicallyLargestSequence(
                        currentIndex + 1,
                        resultSequence,
                        isNumberUsed,
                        targetNumber
                    )
                ) {
                    return true;
                }
                resultSequence[currentIndex + numberToPlace] = 0;
            }
            resultSequence[currentIndex] = 0;
            isNumberUsed[numberToPlace] = false;
        }

        return false;
    }
}