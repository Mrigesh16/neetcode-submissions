class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> hasSet = new HashSet<>();
        for(int i = 0; i<nums.length; i++){
            if(hasSet.contains(nums[i]))
                return true;
            hasSet.add(nums[i]);
        }
        return false;
    }
}