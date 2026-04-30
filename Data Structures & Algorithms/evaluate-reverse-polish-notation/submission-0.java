class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for(String c : tokens){
            if(c.equals("+") ||c.equals("-") ||c.equals("*") ||c.equals("/")){
                if(c.equals("+")){
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp1+temp2);
                }else if(c.equals("-")){
                        int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2-temp1);
                }else if(c.equals("*")){
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp1*temp2);
                }
                else{
                    int temp1 = stack.pop();
                    int temp2 = stack.pop();
                    stack.push(temp2/temp1);
                }
            }else{
                stack.push(Integer.parseInt(c));
            }
        }
        return stack.pop();
    }
}
