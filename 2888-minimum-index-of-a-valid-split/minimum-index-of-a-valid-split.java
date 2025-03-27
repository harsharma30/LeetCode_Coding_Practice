class Solution {

    public int minimumIndex(List<Integer> nums) {
        Map<Integer, Integer> firstMap = new HashMap<>();
        Map<Integer, Integer> secondMap = new HashMap<>();
        int n = nums.size();

        for (int num : nums) {
            secondMap.put(num, secondMap.getOrDefault(num, 0) + 1);
        }

        for (int index = 0; index < n; index++) {
            int num = nums.get(index);
            secondMap.put(num, secondMap.get(num) - 1);
            firstMap.put(num, firstMap.getOrDefault(num, 0) + 1);

            if (
                firstMap.get(num) * 2 > index + 1 &&
                secondMap.get(num) * 2 > n - index - 1
            ) {
                return index;
            }
        }

        return -1;
    }
}