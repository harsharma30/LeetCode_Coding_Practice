class Solution {
    public int[] twoSum(int[] nums, int target) {
        int s=nums.length;
        HashMap <Integer, Integer> mp=new HashMap<>();
        for(int i =0;i<s;i++)
        {   
            int n=target-nums[i]; //getting the value we need by subtracting the target with the current value 
            
            if(mp.containsKey(n)) //if the map already contains the "n" we are looking for
            {
                return new int[]{i,mp.get(n)};  //print there indexes 
            }
            mp.put(nums[i],i); //putting the value and its index onto the map
             
            
           
        }
        return new int[0];
}
}
