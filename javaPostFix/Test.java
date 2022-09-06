
import ADTS.algorithms.*;

class Test {

    public static void main(String[] args) {
        System.out.println("Post Fix Converter Examples 5.16: ");
        System.out.println("example - 1 " + PostFixStr.ConvertToPostFix("A+B"));
        System.out.println("example - 2 " + PostFixStr.ConvertToPostFix("A+B-C"));
        System.out.println("example - 3 " + PostFixStr.ConvertToPostFix("(A+B)*C-D"));

        System.out.println("Question 7: ");
        System.out.println("A. " + PostFixStr.evaluatePostfix("2 6 + 3 5 - /"));
        System.out.println("B. " + PostFixStr.evaluatePostfix("2 3 4 * 5 * -"));
        System.out.println("C. " + PostFixStr.evaluatePostfix("2 3 4 - / 5 *"));
        System.out.println("D. " + PostFixStr.evaluatePostfix("6 3 4 2 ^ * + 5 -"));
    }

}