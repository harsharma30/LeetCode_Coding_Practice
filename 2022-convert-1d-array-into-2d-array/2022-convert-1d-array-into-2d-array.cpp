class Solution {
public:
    vector<vector<int>> construct2DArray(vector<int>& original, int m, int n) {
        // Check if it is possible to form an m x n 2D array
        if (m * n != original.size()) {
            // If not, return an empty 2D array
            return vector<vector<int>>(0, vector<int>(0));
        }

        // Initialize the result 2D array with m rows and n columns
        vector<vector<int>> resultArray(m, vector<int>(n));

        // Initialize a counter to track the current index in the original array
        int index = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // Assign the current element from original array to the 2D
                // array
                resultArray[i][j] = original[index];
                // Move to the next element in the original array
                index++;
            }
        }

        return resultArray;
    }
};