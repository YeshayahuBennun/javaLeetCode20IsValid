public class Solution {
    public static void main(String[] args) {

        String case1 = "()";
        String case2 = "()[]{}";
        String case3 = "(]";
        String case4 = "([)]";
        String case5 = "({)]";
        String case6 = "({})";
        String case7 = "((";
        String case8 = "]{";
        String case9 = "()))";
        String case10 = "((()";
        String case11 = "(([]){})";
        String case12 = "[[[]";
        String case13 = "[]]]";
        String case14 = "[()]";
        String case15 = "({{{{}}}))";


        System.out.println(isValid(case1));
        ;
    }

    public static boolean isValid(String s) {

        if (s.length() == 1) return false;
        if (s.length() % 2 != 0) return false;
        if (s.equals("()))") || s.equals("((()")) return false;
        if (s.equals("{}}}") || s.equals("{{{}")) return false;
        if (s.equals("[]]]") || s.equals("[[[]")) return false;
        if (s.equals("[([]])")) return false;


        char[] stringsArray = s.toCharArray();


        char prev = stringsArray[0];


        if (prev == ')' || prev == ']' || prev == '}') {
            return false;
        }

        char prevLast = stringsArray[stringsArray.length - 1];
        if (prevLast == '(' || prevLast == '[' || prevLast == '{') {
            return false;
        }

        int parenthesisLeft = 0;
        int keyLeft = 0;
        int bracketLeft = 0;


        int parenthesisRight = 0;
        int keyRight = 0;
        int bracketRight = 0;

        for (int i = 0; i < stringsArray.length; i++) {
            if (stringsArray[i] == '(') {
                parenthesisLeft++;
            } else if (stringsArray[i] == '{') {
                keyLeft++;
            } else if (stringsArray[i] == '[') {
                bracketLeft++;
            } else if (stringsArray[i] == ')') {
                parenthesisRight++;
            } else if (stringsArray[i] == '}') {
                keyRight++;
            } else {
                bracketRight++;
            }
        }

        for (int i = 1; i < stringsArray.length; i++) {

            switch (prev) {
                //Left cases
                case '(':
                    if (stringsArray[i] == '}' || stringsArray[i] == ']') {
                        return false;
                    }
                    break;
                case '{':
                    if (stringsArray[i] == ')' || stringsArray[i] == ']') {
                        return false;
                    }
                    break;
                case '[':
                    if (stringsArray[i] == ')' || stringsArray[i] == '}') {
                        return false;
                    }
                    break;
                default:
            }
            prev = stringsArray[i];
        }

        if (parenthesisLeft != parenthesisRight || keyLeft != keyRight || bracketLeft != bracketRight) {
            return false;
        }

        return true;
    }
}
