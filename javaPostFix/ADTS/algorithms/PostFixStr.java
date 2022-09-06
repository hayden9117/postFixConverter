package ADTS.algorithms;

import ADTS.DataTypes.Stack;

public class PostFixStr {
    String str;

    public void algorithms(String str) {
        this.str = str;
    }

    public static int evaluatePostfix(String str) {

        Stack<Integer> stack = new Stack<>();
        // for each is chacter in character Array
        for (char c : str.toCharArray()) {

            if (c == ' ')
                continue;
            // if character is an Operand, push to the stack
            else if (Character.isDigit(c)) {

                stack.push(Character.getNumericValue(c));
            }

            else {
                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (c) {
                    case '+':
                        stack.push(val2 + val1);
                        break;

                    case '-':
                        stack.push(val2 - val1);
                        break;

                    case '/':
                        stack.push(val2 / val1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(val2, val1));
                        break;
                    case '*':
                        stack.push(val2 * val1);
                        break;

                }
            }
        }
        return stack.pop();
    }

    static int check(char el) {
        switch (el) {
            case '+':
            case '-':
                return 1;
            case '*':
            case '/':
                return 2;
            case '^':
                return 3;
        }
        return -1;
    }

    public static String ConvertToPostFix(String str) {
        final Stack<Character> stack = new Stack<>();
        String result = "";
        for (char el : str.toCharArray()) {

            if (check(el) > 0) {
                while (stack.isEmpty() == false && check(stack.peek()) >= check(el)) {
                    result += stack.pop();
                }
                stack.push(el);
            } else if (el == ')') {
                char x = stack.pop();
                while (x != '(') {
                    result += x;
                    x = stack.pop();
                }
            } else if (el == '(') {
                stack.push(el);
            } else {

                result += el;
            }
        }
        while (stack.isEmpty() == false) {
            result += stack.pop();
        }
        return result;
    }

}
