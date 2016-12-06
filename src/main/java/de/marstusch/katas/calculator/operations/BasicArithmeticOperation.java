package de.marstusch.katas.calculator.operations;

public abstract class BasicArithmeticOperation implements ArithmeticOperation {

   protected String[] extractOperands(String arithmeticExpression, String operator) {
      return arithmeticExpression.split(operator);
   }

}
