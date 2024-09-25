class Solution {
    public boolean isPalindrome(int x) {
        // Handle negative numbers directly
        if (x < 0) {
            return false;
        }

        // Reverse the number without converting to string
        int reversed = 0;
        int original = x;
        while (x != 0) {
            int lastDigit = x % 10;
            x /= 10;
            reversed = reversed * 10 + lastDigit;
        }

        // Check if the reversed number is equal to the original
        return reversed == original;
    }
}