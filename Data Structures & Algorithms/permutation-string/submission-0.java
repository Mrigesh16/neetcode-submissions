class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int[] freq = new int[26];

        for(int i = 0; i < s1.length(); i++){
            freq[s1.charAt(i)-'a']++;
        }

        int windowSize = s1.length();

        for(int i = 0;i < s2.length(); i++){
            int windIdx = 0, idx =i;
            int[] windFreq = new int[26];

            while(windIdx < windowSize && idx < s2.length()){
                windFreq[s2.charAt(idx) -'a']++;
                windIdx++;
                idx++;
            }

            if(isFreqSame(freq, windFreq)){
                return true;
            }
        }
        return false;
    }
    boolean isFreqSame(int[] s1, int[] s2){
        for(int i = 0; i<26 ; i++){
            if(s1[i] != s2[i])
                return false;
        }
        return true;
    }
}
