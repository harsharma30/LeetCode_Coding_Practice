class Solution {
    public int fib(int n) {
        if(n==1){
            return 1;
        }
        if(n==0){
            return 0;
        }
        // 0 1 1 2 3 5 
            int f1 = 0;
            int f2 = 1;
            int t = 0;
            for(int i=0; i<n-1; i++){
                t = f1+f2;
                f1 = f2;
                f2 = t;
            }
            return t;
    }
}