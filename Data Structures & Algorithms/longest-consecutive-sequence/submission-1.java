class Solution {
    public int longestConsecutive(int[] nums) {
        Map<Integer, Boolean> map = new HashMap<>();
        for(int i : nums){
            map.put(i, Boolean.FALSE);
        }
        int longestConsecutive = 0;

        for(int i : nums){
            int currentMax = 1;

            int nextNum = i+1;

            while(map.containsKey(nextNum) && !map.get(nextNum)){
                currentMax++;
                map.put(nextNum, Boolean.TRUE);
                nextNum++;
            }

            int prevNum = i-1;
            while(map.containsKey(prevNum) && !map.get(prevNum)){
                currentMax++;
                map.put(prevNum, Boolean.TRUE);
                prevNum--;
            }

            longestConsecutive = Math.max(longestConsecutive, currentMax);
        }

        return longestConsecutive;
    }
}
