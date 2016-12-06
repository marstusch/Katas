package de.marstusch.katas.calculator.operations;

public class Subtraction extends BasicArithmeticOperation {

   @Override
   public int calculate(String arithmeticExpression) {
      String[] operands = extractOperands(arithmeticExpression, "-");
      if (operands.length == 2) {
         return Integer.valueOf(operands[0]) - Integer.valueOf(operands[1]);
      }
      return 0;
   }
}
