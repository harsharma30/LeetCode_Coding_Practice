class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;

        // Ensure nums1 is always smaller than nums2
        if (m > n) {
            int[] temp = nums1;
            nums1 = nums2;
            nums2 = temp;
            int tmp = m;
            m = n;
            n = tmp;
        }

        int i = 0, j = 0, k = 0;
        int[] merged = new int[m + n];

        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                merged[k++] = nums1[i++];
            } else {
                merged[k++] = nums2[j++];
            }
        }

        // Copy remaining elements from nums1 or nums2
        while (i < m) {
            merged[k++] = nums1[i++];
        }
        while (j < n) {
            merged[k++] = nums2[j++];
        }

        // Find the median of the merged array
        int medianIndex = (m + n) / 2;
        if ((m + n) % 2 == 0) {
            return (double) (merged[medianIndex - 1] + merged[medianIndex]) / 2;
        } else {
            return (double) merged[medianIndex];
        }
    }
}