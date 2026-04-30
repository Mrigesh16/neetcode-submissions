class Solution {
    public int lengthOfLongestSubstring(String s) {        
        int max = 0;
        int left = 0;
        Set<Character> charSet = new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            while(charSet.contains(s.charAt(i))){
                charSet.remove(s.charAt(left));
                left++;
            }
            charSet.add(s.charAt(i));
            max = Math.max(charSet.size(),max);
        }
        return max;
    }
}
