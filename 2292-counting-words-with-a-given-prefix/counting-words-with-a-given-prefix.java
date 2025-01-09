class Solution {

    public int prefixCount(String[] words, String pref) {
        int count = 0;
        for (String word : words) {
            count += hasPrefix(word, pref);
        }
        return count;
    }

    private int hasPrefix(String str, String pref) {
        int itr;
        for (itr = 0; itr < str.length() && itr < pref.length(); itr++) {
            if (str.charAt(itr) != pref.charAt(itr)) {
                return 0; 
            }
        }

        if (itr != pref.length()) {
            return 0;
        }
        return 1;
    }
}