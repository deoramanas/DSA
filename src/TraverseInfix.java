import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class TraverseInfix {
    public static final Map<Character, Integer> operatorMap = new HashMap<>();

    public static void main(String[] args) {

        String expression = "a+b*(d+e)";
        String expression1 = "x^y/(5*z)+2";
        String expression2 = "A+B*C/(E-F)";
        String expression3 = "(A+B)*(C+D)";

        operatorMap.put('+', 1);
        operatorMap.put('-', 1);
        operatorMap.put('*', 2);
        operatorMap.put('/', 2);
        operatorMap.put('^', 3);

        //System.out.println(operatorMap);
        String postfixExp = traverseInfixIntoPostfix(expression3);
        System.out.println(postfixExp);
        traversePostfix(postfixExp);
    }

    private static void traversePostfix(String postfix) {
        char[] characters = postfix.toCharArray();
        String result = "";
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < characters.length; i++) {
            if (operatorMap.containsKey(characters[i])) {
                String second_op = stack.pop();
                String first_op = stack.pop();
                result="";
                result += first_op + characters[i] + second_op;
                stack.push(result);
            } else {
                stack.push(String.valueOf(characters[i]));
            }
        }
        String res="";
        if (!stack.isEmpty()){
            res=stack.pop();
        }
        System.out.println("Final result:  "+ res);
    }

    private static String traverseInfixIntoPostfix(String expression) {

        char[] characters = expression.toCharArray();
        Stack<Character> stack = new Stack<>();
        String result = "";
        for (int i = 0; i < characters.length; i++) {
            if (characters[i] == '(') {
                stack.push(characters[i]);
            } else if (characters[i] == ')') {
                while (!stack.isEmpty()) {
                    if (stack.peek() == '(') {
                        stack.pop();
                        break;
                    }
                    result += stack.pop();

                }
            } else if (operatorMap.containsKey(characters[i])) {
                if (!stack.isEmpty()) {
                    Character alreadyPresentOperator = stack.peek();
                    if (operatorMap.containsKey(alreadyPresentOperator)) {
                        if (operatorMap.get(alreadyPresentOperator) < operatorMap.get(characters[i])) {
                            stack.push(characters[i]);
                        } else {
                            while (!stack.isEmpty() && operatorMap.get(alreadyPresentOperator) >= operatorMap.get(characters[i])) {
                                result += stack.pop();
                                if (!stack.isEmpty()) {
                                    alreadyPresentOperator = stack.peek();
                                }
                            }
                            stack.push(characters[i]);
                        }
                    } else {
                        stack.push(characters[i]);
                    }
                } else {
                    stack.push(characters[i]);
                }
            } else {
                result += characters[i];
            }
        }

        while (!stack.isEmpty()) {
            result += stack.pop();
        }
        return result;
    }
}
