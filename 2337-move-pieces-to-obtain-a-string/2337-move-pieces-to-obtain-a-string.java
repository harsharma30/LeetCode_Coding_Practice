class Solution {

    public boolean canChange(String start, String target) {
        // Queue to store characters and indices from both strings
        Queue<Pair<Character, Integer>> startQueue =
            new LinkedList<>(), targetQueue = new LinkedList<>();

        // Record non-underscore characters and their indices
        for (int i = 0; i < start.length(); i++) {
            if (start.charAt(i) != '_') {
                startQueue.add(new Pair<>(start.charAt(i), i));
            }
            if (target.charAt(i) != '_') {
                targetQueue.add(new Pair<>(target.charAt(i), i));
            }
        }

        // If number of pieces don't match, return false
        if (startQueue.size() != targetQueue.size()) return false;

        // Compare each piece's type and position
        while (!startQueue.isEmpty()) {
            Pair<Character, Integer> startPair = startQueue.poll();
            Pair<Character, Integer> targetPair = targetQueue.poll();

            char startChar = startPair.getKey();
            int startIndex = startPair.getValue();
            char targetChar = targetPair.getKey();
            int targetIndex = targetPair.getValue();

            // Check character match and movement rules
            if (
                startChar != targetChar ||
                (startChar == 'L' && startIndex < targetIndex) ||
                (startChar == 'R' && startIndex > targetIndex)
            ) {
                return false;
            }
        }

        return true;
    }
}