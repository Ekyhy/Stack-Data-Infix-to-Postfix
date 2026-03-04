
import java.util.Stack;

public class taskFour {

        static int floorDiv(int a, int b){
            if (a * b < 0 && a % b != 0) 
                return (a / b) -1;
            return a/b;
        }
        // Fungsi untuk mengembalian precedence dari operator
        static  int precedence(char c) {
            if (c == '^') 
                return 3;
            else if (c == '/' || c == '*') 
                return  2;
            else if (c == '+' || c == '-') 
                return 1;
            else
                return -1;
        }

        // Fungsi untuk mengecek jika operator berjalan dari kanan
        static  boolean  isRightAssociative(char c){
            return c =='^';
        }

        public static String infixToPostFix(String s){
            Stack<Character> stack = new Stack<>();
            StringBuilder resBuilder = new  StringBuilder();

            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);

                // Jika operand ditambahkan pada hasil
                if (Character.isLetterOrDigit(c)) {
                    resBuilder.append(c).append(" ");
                }
                
                // Jika '(' di push ke dalam stack
                else if (c == '(') {
                    stack.push('(');
                }

                // Jika ')' di keluarkan dari dalam stack
                else if (c == ')') {
                    while (!stack.isEmpty() && stack.peek() != '(') {
                        resBuilder.append(stack.pop()).append(" ");
                    }
                    stack.pop();
                }

                else {
                    while (!stack.isEmpty() && stack.peek() != '(' &&
                            (precedence(stack.peek()) > precedence(c)    ||
                            (precedence(stack.peek()) == precedence(c) && !isRightAssociative(c)))){
                        resBuilder.append(stack.pop()).append(" ");
                    }
                    stack.push(c);
                }
            }

            // Keluarkan operator yang sedang berjalan
            while (!stack.isEmpty()) {
                resBuilder.append(stack.pop()).append(" ");
            }

            return resBuilder.toString().trim();
        }

        public static int evaluatePostFix(String exp){
            Stack<Integer> stack = new Stack<>();

            for(String token : exp.split("\\s+")){
                if (token.isEmpty()) continue;
                // Jika operand adalah bilangan angka, push ke dalam stack
                if  (Character.isDigit(token.charAt(0)) || (token.length() > 1 && token.charAt(0) == '-')) {
                    stack.push(Integer.parseInt(token));
                }

                else {
                    int val1 = stack.pop();
                    int val2 = stack.pop();
                    
                    switch (token) {
                        case "+": stack.push(val2 + val1); break;
                        case "-": stack.push(val2 - val1); break;
                        case "*": stack.push(val2 * val1); break;
                        case "/": stack.push(floorDiv(val2, val1)); break;
                        case "^": stack.push((int) Math.pow(val2, val1)); break;
                    }
                }
            }
            return stack.pop();
        }

        public static void main(String[] args) {
            String exp = "2*(4+5)/1";
      // Step 1: Ubah ke Postfix
        String postfix = infixToPostFix(exp);
        System.out.println("Infix  : " + exp);
        System.out.println("Postfix: " + postfix);
        
        // Step 2: Evaluasi hasil Postfix
        int result = evaluatePostFix(postfix);
        System.out.println("Hasil  : " + result);
        }
}
