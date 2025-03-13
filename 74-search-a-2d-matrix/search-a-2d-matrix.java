class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        //int n = matrix.length;
        boolean ans = false;
        for(int i = 0; i<matrix.length; i++){
            for(int j = 0; j<matrix[i].length;j++){
                if(matrix[i][j] == target){
                    ans = true;
                }
            }
        }
        return ans;
    }
}