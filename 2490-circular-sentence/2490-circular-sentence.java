class Solution {

    public boolean isCircularSentence(String sentence) {
        // Use the split function to store the words in an array.
        String words[] = sentence.split(" ");
        int n = words.length;

        // Start comparing from the last character of the last word.
        char last = words[n - 1].charAt(words[n - 1].length() - 1);

        for (int i = 0; i < n; i++) {
            // If this character is not equal to the first character of current word, return
            // false.
            if (words[i].charAt(0) != last) return false;
            last = words[i].charAt(words[i].length() - 1);
        }

        return true;
    }
}