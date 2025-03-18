class Solution {
    public int climbStairs(int n) {
        if(n<=3){
            return n;
        }
        int prev1 = 3;
        int prev2 = 2;
        int current = 0;
        for(int i=3; i<n; i++){
            current = prev1 + prev2;
            prev2 = prev1;
            prev1 = current;
        }
        return current;
    }
}