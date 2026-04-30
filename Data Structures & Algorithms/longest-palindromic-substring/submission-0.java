class Solution {
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        String str = "";
        for(int i = 0; i<s.length(); i++){
            String odd = helper(s,i,i);
            String even = helper(s,i,i+1);
            String longer = odd.length() > even.length() ? odd : even;
            str = longer.length() > str.length() ? longer : str;
        }
        return str;
    }
    String helper(String s, int i, int j){
        int l = s.length();
        while(i >=0 && j<l && s.charAt(i) == s.charAt(j)){
            i--;
            j++;
        }
        return s.substring(i+1,j);
    }
}
