class Solution {

    public int countDays(int days, int[][] meetings) {
        int freeDays = 0, latestEnd = 0;
        Arrays.sort(meetings, Comparator.comparingInt(a -> a[0]));

        for (int[] meeting : meetings) {
            int start = meeting[0], end = meeting[1];
            if (start > latestEnd + 1) {
                freeDays += start - latestEnd - 1;
            }
            latestEnd = Math.max(latestEnd, end);
        }

        freeDays += days - latestEnd;

        return freeDays;
    }
}