class MyCalendarTwo {

    private List<int[]> bookings;
    private List<int[]> overlapBookings;

    private boolean doesOverlap(int start1, int end1, int start2, int end2) {
        return Math.max(start1, start2) < Math.min(end1, end2);
    }

    private int[] getOverlapped(int start1, int end1, int start2, int end2) {
        return new int[] { Math.max(start1, start2), Math.min(end1, end2) };
    }

    public MyCalendarTwo() {
        bookings = new ArrayList<>();
        overlapBookings = new ArrayList<>();
    }

    public boolean book(int start, int end) {
        for (int[] booking : overlapBookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                return false;
            }
        }

        for (int[] booking : bookings) {
            if (doesOverlap(booking[0], booking[1], start, end)) {
                overlapBookings.add(
                    getOverlapped(booking[0], booking[1], start, end)
                );
            }
        }

        bookings.add(new int[] { start, end });
        return true;
    }
}