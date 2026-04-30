class Solution {
    public int rob(int[] nums) {
        if(nums.length < 2)
            return nums[0];
        int n = nums.length;
        int[] skipFirst = new int[n-1];
        int[] skipLast = new int[n];
        for(int i = 0; i<n-1; i++){
            skipLast[i] = nums[i];
            skipFirst[i] = nums[i+1];
        }
        return Math.max(helper(skipFirst),helper(skipLast));
    }
    int helper(int[] nums){
        if(nums.length < 2)
            return nums[0];
        int n = nums.length;
        int[] dp = new int[n];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0],nums[1]);
        for(int i = 2; i<n; i++){
            dp[i] = Math.max((nums[i] + dp[i-2]), dp[i-1]);
        }
        return dp[n-1];
    }
}
