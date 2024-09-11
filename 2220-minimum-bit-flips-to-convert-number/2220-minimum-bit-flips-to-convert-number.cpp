class Solution {
public:
    int minBitFlips(int start, int goal) {
        // Base case: both numbers have been fully processed
        if (start == 0 && goal == 0) return 0;

        // Flip for the current least significant bit
        int flip = (start & 1) != (goal & 1);

        // Recurse for the next bits by right-shifting both numbers
        return flip + minBitFlips(start >> 1, goal >> 1);
    }
};