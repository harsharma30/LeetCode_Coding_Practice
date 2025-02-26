class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        List<Boolean> result = new ArrayList<>();
        int n = candies.length;
        int maxCandy = 0;
        for (int candy : candies) {
            maxCandy = Math.max(maxCandy, candy);
        }
        for(int i=0; i<n; i++){
            result.add(candies[i] + extraCandies >= maxCandy);
        }
        return result;
    }
}