package structs;

public class Parenthes
{
    private Parenthes(){}

    public static boolean isCorrect(String s, Stack<Character>stack)
    {
        for (int i = 0; i < s.length(); i++) {
            char symb = s.charAt(i);
            switch (symb) {
                case '(':
                case '[':
                case '{':
                    stack.push(symb);
                    break;
                case ')':
                    if (stack.isEmpty() || stack.pop() != '(') {
                        return false;
                    }
                    break;
                case ']':
                    if (stack.isEmpty() || stack.pop() != '[') {
                        return false;
                    }
                    break;
                case '}':
                    if (stack.isEmpty() || stack.pop() != '{') {
                        return false;
                    }
                    break;
            }
        }    
        return stack.size()==0;
    }   
}