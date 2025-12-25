// User function Template for Java

class Solution {
    static String postToInfix(String exp) {
        // code here
        
        // Time Complexity : O(n)
        
        // Space Complexity : O(n / 2 + 1)
        
        
        Stack<String> stack = new Stack<>();
        
        for(char ch: exp.toCharArray()){
            if(stack.isEmpty() || (ch != '+' && ch != '-' && ch != '*' && ch != '/' && ch != '^')){
                stack.push(ch + "");
            }
            else{
                String op2 = stack.pop();
                String op1 = stack.pop();
                String ans = "(" + op1 + ch + op2 + ")";
                stack.push(ans);
            }
        }
        
        return stack.pop();
    }
}
