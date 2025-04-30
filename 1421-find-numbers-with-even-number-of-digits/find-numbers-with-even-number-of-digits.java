class Solution {
    public int findNumbers(int[] nums) {
        int count = 0;
        for (int i : nums) {
            if (countDigits(i) % 2 == 0) {
                count++;
            }
        }
        return count;
    }

    private int countDigits(int x) {
        int cnt = 0;
        while (x > 0) {
            x /= 10;
            cnt++;
        }
        return cnt;
    }
}