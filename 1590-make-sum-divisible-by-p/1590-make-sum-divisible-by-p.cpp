class Solution {
public:
    int minSubarray(vector<int>& nums, int p) {
        int n = nums.size();
        long long sum = accumulate(nums.begin(),nums.end(),0LL);
        int rem = sum % p;

        if(rem==0) return 0;

        int res = n;
        unordered_map<int,int> mp;
        mp[0] = -1; // To handle cases where subarray starts from the beginning
        long long prefSum = 0;
        
        for(int i=0; i<n; i++){
            prefSum += nums[i];
            int r = prefSum % p;
            
            int req = (r - rem + p) % p; // Handle negative remainders by adding `p` and then doing `%p` to ensure non-negative remainder
            if(mp.find(req)!=mp.end()){
                res = min(res, i - mp[req]);
            }
            mp[r] = i;
        }

        return (res!=n) ? res : -1;  // If no valid subarray found, return -1
    }
};