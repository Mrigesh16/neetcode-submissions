class Solution {
    public String minWindow(String s, String t) {
        int[] frequencyT = new int[256];
        int[] frequencyS = new int[256];
        for(int i = 0; i<t.length(); i++){
            frequencyT[t.charAt(i)]++;
        }
        int minLength = Integer.MAX_VALUE, right = 0, left = 0, minStart=0;

        for(;right < s.length(); right++){
            frequencyS[s.charAt(right)]++;
            while(isPresent(frequencyS,frequencyT)){
                if(right-left + 1 < minLength){
                    minLength = right-left+1;
                    minStart = left;
                }
                frequencyS[s.charAt(left++)]--;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : s.substring(minStart,minStart+minLength);
    }
    boolean isPresent(int[] frequencyS, int[] tempFrequencyT){
        for(int i = 0; i<256; i++){
            if(tempFrequencyT[i] > frequencyS[i])
                return false;
        }
        return true;
    }
}
