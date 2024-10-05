class Solution {
public:

    int isPalindrome(string &s,int i,int j,vector<vector<int>>&dp)
    {
        if(i>=j)return 1;
        if(dp[i][j] != -1)return dp[i][j];
        if(s[i] == s[j])
           return dp[i][j] = isPalindrome(s,i+1,j-1,dp);
        return dp[i][j] = 0;   
    }

    string longestPalindrome(string s) 
    {
        int n = s.length();
        int maxLen = INT_MIN;
        int start = 0;
        vector<vector<int>>dp(n,vector<int>(n,-1));

        for(int i=0 ; i<n ; i++)
        {
            for(int j=i ; j<n ; j++)
            {
                if(isPalindrome(s,i,j,dp))
                {
                    if(j-i+1 > maxLen)
                    {
                        maxLen = j-i+1;
                        start = i;
                    }
                }
            }
        }
        return s.substr(start,maxLen);
    }
};