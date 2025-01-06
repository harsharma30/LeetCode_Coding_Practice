class Solution {

    public int[] minOperations(String boxes) {
        int[] answer = new int[boxes.length()];
        for (int currentBox = 0; currentBox < boxes.length(); currentBox++) {
            // If the current box contains a ball, calculate the number of moves for every box.
            if (boxes.charAt(currentBox) == '1') {
                for (
                    int newPosition = 0;
                    newPosition < boxes.length();
                    newPosition++
                ) {
                    answer[newPosition] += Math.abs(newPosition - currentBox);
                }
            }
        }
        return answer;
    }
}