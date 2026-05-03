class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        int max = 0;
        for(int i=0; i<nums.length; i++){
            for(int j=0;j<i;j++){
                if(nums[i] > nums[j]){
                    if(dp[j] + 1 > dp[i])
                        dp[i] = dp[j] + 1;
                }
            }
            max = Math.max(max,dp[i]);
        }

        return max+1 ;
    }
}
