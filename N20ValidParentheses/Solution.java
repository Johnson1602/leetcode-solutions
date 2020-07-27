package N20ValidParentheses;

import java.util.Stack;

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char current = s.charAt(i);
            if (current == '(' || current == '[' || current == '{') {
                stack.push(current);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (topChar == '(' && current != ')') {
                    return false;
                } else if (topChar == '[' && current != ']') {
                    return false;
                } else if (topChar == '{' && current != '}') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "]";
        Solution solution = new Solution();
        System.out.println(solution.isValid(s));
    }
}
