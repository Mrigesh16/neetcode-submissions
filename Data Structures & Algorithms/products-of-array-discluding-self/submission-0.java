class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        left[0]=1;left[1]=nums[0];
        right[n-1]=1; right[n-2] = nums[n-2];
        for(int i = 2; i<n; i++){
            left[i] = left[i-1]*nums[i-1];
        }
        for(int i = n-2;i>=0;i--){
            right[i] = right[i+1]*nums[i+1];
        }
        int[] ans = new int[n];
        for(int i =0;i<n;i++){
            ans[i] = left[i]*right[i];
        }
        return ans;

    }
}  
