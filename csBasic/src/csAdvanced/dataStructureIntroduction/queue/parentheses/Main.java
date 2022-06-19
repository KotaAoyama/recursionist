package csAdvanced.dataStructureIntroduction.queue.parentheses;

import java.util.*;

class Solution{
    public static boolean isParenthesesValid(String parentheses){
        if (parentheses.length() < 2) return false;

        Map<Character, Character> parenthesesMap = new HashMap<>();
        parenthesesMap.put('{', '}');
        parenthesesMap.put('[', ']');
        parenthesesMap.put('(', ')');

        Stack<Character> stack = new Stack<>();
        stack.push(parentheses.charAt(0));

        for (int i = 1; i < parentheses.length(); i++) {
            if (!stack.empty() &&
                    parenthesesMap.getOrDefault(stack.peek(), null) != null &&
                    parenthesesMap.getOrDefault(stack.peek(), null).equals(parentheses.charAt(i))) {
                stack.pop();
            } else {
                stack.push(parentheses.charAt(i));
            }
        }

        return stack.empty();
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println(Solution.isParenthesesValid("{}")); // --> true
        System.out.println(Solution.isParenthesesValid("[{}]")); // --> true
        System.out.println(Solution.isParenthesesValid("[{(]")); // --> false
        System.out.println(Solution.isParenthesesValid("(){}[]")); // --> true
        System.out.println(Solution.isParenthesesValid("((()(())))")); // --> true
        System.out.println(Solution.isParenthesesValid("[{(}])")); // --> false
        System.out.println(Solution.isParenthesesValid("]][}{({()){}(")); // --> false
        System.out.println(Solution.isParenthesesValid("{(([])[])[]}[]")); // --> true
        System.out.println(Solution.isParenthesesValid("{(([])[])[]]}")); // --> false
        System.out.println(Solution.isParenthesesValid("{{[[(())]]}}")); // --> true
    }
}
