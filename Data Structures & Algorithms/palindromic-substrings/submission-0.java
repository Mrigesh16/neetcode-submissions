class Solution {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        int count = 0;
        for(int i = 0; i<s.length(); i++){
            count += helper(s,i,i);
            count += helper(s,i,i+1);
        }
        return count;
    }
    int helper(String s, int i, int j){
        int l = s.length();
        int count = 0;
        while(i >=0 && j<l && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
            count++;
        }
        return count;
    }
}
