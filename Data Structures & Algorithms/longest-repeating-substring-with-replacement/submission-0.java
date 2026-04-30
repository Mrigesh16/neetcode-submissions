class Solution {
    public int characterReplacement(String s, int k) {
        int[] frequency = new int[26];
        int maxFrequency = 0;
        int left = 0;
        int maxWindow = 0;
        for(int right = 0;right<s.length(); right++){
            frequency[s.charAt(right) - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[s.charAt(right)-'A']);
            int windowLength = right -left +1;
            if(windowLength - maxFrequency > k){
                frequency[s.charAt(left) - 'A']--;
                left++;
            }
            windowLength = right - left +1;
            maxWindow = Math.max(maxWindow, windowLength);
        }
        return maxWindow;
    }
}
