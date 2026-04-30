class Solution {
    public int lengthOfLongestSubstring(String s) {        
        int max = 0;
        int left = 0;
        Set<Character> temp = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            while(temp.contains(s.charAt(i))){
                temp.remove(s.charAt(left));
                left++;
            }
            temp.add(s.charAt(i));
            max = Math.max(temp.size(),max);
        }
        return max;
    }
}
