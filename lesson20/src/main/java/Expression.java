class Expression {
  private Stack<Character> operators = new Stack<>();
  private Stack<Double> operands = new Stack<>();

  public double evaluate(String exprStr) {
    for (int i = 0; i <exprStr.length(); i++ ) {
      char ch = exprStr.charAt(i);
      if (Character.isDigit(ch)) {
        operands.push((double)Character.getNumericValue(ch));
      } else if ("-+*/".indexOf(ch) != -1) {
        operators.push(ch);
      } else if (ch == ')') {
        double result = operands.pop();
        char operator = operators.pop();
        switch (operator) {
          case '+': result += operands.pop(); break;
          case '*': result *= operands.pop(); break;
          case '-': result = operands.pop() - result; break;
          case '/': result = operands.pop() / result; break;
        }
        operands.push(result);
    }
  }
  return operands.pop();
  }
}
