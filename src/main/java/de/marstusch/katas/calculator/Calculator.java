package de.marstusch.katas.calculator;

import java.util.List;

import de.marstusch.katas.calculator.operations.ArithmeticOperation;

public class Calculator {

   private List<ArithmeticOperation> arithmeticOperations;

   public Calculator(List<ArithmeticOperation> arithmeticOperations) {
      this.arithmeticOperations = arithmeticOperations;
   }

   public int calculate(String arithmeticExpression) {
      int calculatedValue = 0;
      for (ArithmeticOperation operation : this.arithmeticOperations) {
         calculatedValue = operation.calculate(arithmeticExpression);
         if (calculatedValue != 0) {
            return calculatedValue;
         }
      }
      return calculatedValue;
   }
}
