class Solution {
    public boolean canJump(int[] nums) {
        int idx = nums.length-1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]+ i >= idx)
                idx = i ;
        }
        return idx==0;
    }
}
