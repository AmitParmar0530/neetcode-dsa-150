class Solution {
    public int evalRPN(String[] tokens) {
        Deque<Integer> deque = new ArrayDeque<>();

        for(int i = 0; i < tokens.length ; i++){
            
            if (tokens[i].equals("+") || tokens[i].equals("-") ||
            tokens[i].equals("*") || tokens[i].equals("/")) {

            int b = deque.pop();                      // ✅ pop b first (last pushed)
            int a = deque.pop();                      // ✅ pop a second
            deque.push(operation(tokens[i], a, b));

            } else {
                deque.push(Integer.parseInt(tokens[i]));  // ✅ parse string → int
            }
        }
        return deque.pop();
    }

    public int operation(String operation, int a, int b){
        switch(operation){
            case "+": return a + b;
            case "-": return a - b;   // ✅ a - b  not b - a
            case "*": return a * b;
            case "/": return a / b;   // ✅ a / b  not b / a
            default: return 0; 
        }
    }
}
