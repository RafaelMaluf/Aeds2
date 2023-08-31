
import java.util.Stack;
public class Teste {
    public static void main(String[] args) {
        String input1 = "2 1 0 and(not(A) , not(B))";
        String input2 = "3 1 0 1 or(A , B , C)";
        
        System.out.println(evaluateBooleanExpression(input1)); // Deve imprimir "false"
        System.out.println(evaluateBooleanExpression(input2)); // Deve imprimir "true"
    }

    public static boolean evaluateBooleanExpression(String input) {
        String[] parts = input.split(" ");
        int n = Integer.parseInt(parts[0]);
        boolean[] values = new boolean[n];
        for (int i = 0; i < n; i++) {
            values[i] = Integer.parseInt(parts[i + 1]) == 1;
        }
        String expression = parts[n + 1];

        for (int i = 0; i < n; i++) {
            expression = expression.replace("not(" + (char) ('A' + i) + ")", Boolean.toString(!values[i]));
        }

        expression = expression.replaceAll(",", "");

        String[] operators = expression.split(" ");
        Stack<Boolean> stack = new Stack<>();

        for (String token : operators) {
            if (token.equals("and")) {
                boolean operand2 = stack.pop();
                boolean operand1 = stack.pop();
                stack.push(operand1 && operand2);
            } else if (token.equals("or")) {
                boolean operand2 = stack.pop();
                boolean operand1 = stack.pop();
                stack.push(operand1 || operand2);
            } else {
                boolean value = Boolean.parseBoolean(token);
                stack.push(value);
            }
        }

        return stack.pop();
    }
}
