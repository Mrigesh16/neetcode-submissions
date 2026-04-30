class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];
        for(int i=0; i<s1.length() ; i++){
            freq[s1.charAt(i)-'a']++;
        }

        int windowSize = s1.length();

        for(int i = 0; i<s2.length() ; i++){
            int idx = i;
            int currentWindow = 0;
            int[] currentFreq = new int[26];
            while(currentWindow < windowSize && idx < s2.length()){
                currentFreq[s2.charAt(idx) - 'a']++;
                currentWindow++;
                idx++;
            }

            if(isSameFreq(freq, currentFreq))
                return true;
        }
        return false;
    }

    boolean isSameFreq(int[] s1, int[] s2){
        for(int i=0;i<26;i++){
            if(s1[i] != s2[i])
                return false;
        }
        return true;
    }
}
