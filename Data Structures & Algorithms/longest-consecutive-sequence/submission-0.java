class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer>map = new HashSet<>();
        int maxSoFar = 0;
        for(int i : nums){
            map.add(i);
        }
        for(int i : nums ){
            int forward = i+1;
            int count = 1;
            while(map.contains(forward)){
                forward++;
                count++;
            }
            maxSoFar = Math.max(count,maxSoFar);
            count = 0;
            int backward = i-1;
            while(map.contains(backward)){
                backward--;
                count++;
            }
            maxSoFar = Math.max(count,maxSoFar);
        }
        return maxSoFar;
    }
}
