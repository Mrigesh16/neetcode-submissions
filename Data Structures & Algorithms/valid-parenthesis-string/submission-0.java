class Solution {

    public boolean checkValidString(String s) {

        int low = 0;   // minimum possible open brackets
        int high = 0;  // maximum possible open brackets

        for (char ch : s.toCharArray()) {

            if (ch == '(') {
                low++;
                high++;
            } 
            else if (ch == ')') {
                low--;
                high--;
            } 
            else { // '*'
                low--;   // treat '*' as ')'
                high++;  // treat '*' as '('
            }

            // too many closing brackets
            if (high < 0) {
                return false;
            }

            // low should never be negative
            low = Math.max(low, 0);
        }

        return low == 0;
    }
}