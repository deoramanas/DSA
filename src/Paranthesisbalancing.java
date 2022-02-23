import java.util.Stack;

public class Paranthesisbalancing {
    public static void main(String[] args) {
        Paranthesisbalancing paranthesisbalancing = new Paranthesisbalancing();
        String str = "]";

        System.out.println(paranthesisbalancing.isExpressionValid(str));
    }

    private boolean isExpressionValid(String str) {
        Stack<Character> stack = new Stack<>();
        char[] characters = str.toCharArray();
        for (int i = 0; i < characters.length; i++) {

            if (isOpening(characters[i])) {
                stack.push(characters[i]);
            } else if (!stack.isEmpty() && !isMatching(characters[i], stack.peek())) {
                return false;
            } else {
                stack.pop();
            }
        }
        return stack.isEmpty();
    }

    private boolean isMatching(char character, Character peek) {
        return (character == ')' && peek == '(') || (character == ']' && peek == '[') || (character == '}' && peek == '{');
    }

    private boolean isOpening(char character) {
        return character == '(' || character == '{' || character == '[';
    }
}
