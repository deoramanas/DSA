import java.util.Stack;

public class SortUsingTwoStacks {
    public static void main(String[] args) {

        Stack<Integer> s= new Stack<>();
        s.add(83);
        s.add(23);
        s.add(68);
        s.add(57);
        s.add(12);
        s.add(9);

        Stack<Integer> newStack =new Stack<>();
        newStack.push(s.pop());
         method1(s, newStack);

        //method2(s,newStack);

        System.out.println(newStack);
        System.out.println(s);



    }

    private static void method2(Stack<Integer> s, Stack<Integer> newStack) {

        while (!s.isEmpty()){
            int temp = s.pop();
            while (!s.isEmpty() && temp < newStack.peek()){
                s.push(newStack.pop());
            }
            newStack.push(temp);
        }
    }

    private static void method1(Stack<Integer> s, Stack<Integer> newStack) {
        while (!s.isEmpty()){
            if(s.peek() > newStack.peek()){
                newStack.push(s.pop());
            }
            else{
                s.add(0, newStack.pop());
            }
        }
    }
}
