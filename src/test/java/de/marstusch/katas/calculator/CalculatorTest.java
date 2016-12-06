package de.marstusch.katas.calculator;

import static org.junit.Assert.assertThat;

import java.util.Arrays;

import org.hamcrest.CoreMatchers;
import org.junit.Before;
import org.junit.Test;

import de.marstusch.katas.calculator.Calculator;
import de.marstusch.katas.calculator.operations.Addition;
import de.marstusch.katas.calculator.operations.Division;
import de.marstusch.katas.calculator.operations.Multiplication;
import de.marstusch.katas.calculator.operations.Subtraction;

public class CalculatorTest {

   private Calculator calculator;

   @Before
   public void initTest() {
      calculator = new Calculator(
            Arrays.asList(
                  new Addition(), 
                  new Subtraction(), 
                  new Multiplication(), 
                  new Division()));
   }

   @Test
   public void returns_0_when_expression_contains_any_char() throws Exception {
      assertThat(calculator.calculate("a"), CoreMatchers.is(0));
   }

   @Test
   public void calculates_addition() throws Exception {
      assertThat(calculator.calculate("2+2"), CoreMatchers.is(4));
   }

   @Test
   public void calculates_subtraction() throws Exception {
      assertThat(calculator.calculate("40-20"), CoreMatchers.is(20));
   }

   @Test
   public void calculates_multiplication() throws Exception {
      assertThat(calculator.calculate("2*30"), CoreMatchers.is(60));
   }

   @Test
   public void calculates_division() throws Exception {
      assertThat(calculator.calculate("6/3"), CoreMatchers.is(2));
   }
}
