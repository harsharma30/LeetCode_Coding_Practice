class Solution {

    public long minEnd(int n, int x) {
        long result = x;

        while (--n > 0) {
            result = (result + 1) | x;
        }

        return result;
    }
}