class Solution {
public:
    string shortestPalindrome(string s) {
        string reversedString = s;
        // Reverse the original string
        reverse(reversedString.begin(), reversedString.end());

        // Iterate through the string to find the longest palindromic prefix
        for (int i = 0; i < s.size(); ++i) {
            // memcmp to avoid creating substrings
            if (!memcmp(s.c_str(), reversedString.c_str() + i, s.size() - i)) {
                // Append the necessary part to make the palindrome
                return reversedString.substr(0, i) + s;
            }
        }
        // Fallback case, append the whole reversed string to the original
        // string
        return reversedString + s;
    }
};