package projectCode.stringcalculator;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.util.ArrayList;

import javax.naming.NameNotFoundException;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.CoreMatchers.is;



import junit.framework.AssertionFailedError;

public class SimpleCalculatorTest {
	SimpleCalculator stringCalc;

	 @Before
	 public void setUp() {
	  stringCalc = new SimpleCalculator();
	 }

	 @After
	 public void tearDown() {
	  stringCalc = null;
	 }
	  

	 @Test
	 public void stringCalculatorPassCase1() {
	  String actual = "100 * 2 + 12";
	  int expected = 212;
	  assertEquals(expected, SimpleCalculator.calculate(actual));
	  System.out.println("Case #1 :"+expected);
	 }
	 
	 @Test
	 public void stringCalculatorPassCase2() {
	  String actual = "100 * 2 + 12";
	  int expected = 212;
	  assertEquals(expected, SimpleCalculator.calculate(actual));
	  System.out.println("Case #2 :"+expected);
	 }
	 
	 @Test
	 public void stringCalculatorPassCase3() {
	  String actual = "100 * ( 2 + 12 )";
	  int expected = 1400;
	  assertEquals(expected, SimpleCalculator.calculate(actual));
	  System.out.println("Case #3 :"+expected);
	 }
	 
	 @Test
	 public void stringCalculatorPassCase4() {
	  String actual = "100 * ( 2 + 12 ) / 14";
	  int expected = 100;
	  assertEquals(expected, SimpleCalculator.calculate(actual));
	  System.out.println("Case #4 :"+expected);
	 }
	 
	 @Test
	 public void stringCalculatorCannotStart() {
	  String actual = "100 * 2 + 12 / 14)";
	  int expected = 100;
	  assertEquals(expected, SimpleCalculator.calculate(actual));
	  System.out.println("Case #5 :"+expected);
	 }
	 
	 @Test
	 public void stringCalculatorCannotEnd() {
	  String actual = "(100 * ( 2 + 12 ) / 14";
	  int expected = 100;
	  assertEquals(expected, SimpleCalculator.calculate(actual));
	  System.out.println("Case #6 :"+expected);
	 }
	 
	 @Test
	 public void exceptionhandling() {
		 try {
	  String actual = "100 * 2 / }}}}]0";
	  SimpleCalculator.calculate(actual);
	  //System.out.println("Case #2 :"+expected);
		 }
		 catch (Exception e) {
		     Assert.fail("Exception " + e);
		     System.out.println("Case #2 :"+e);
		   }
	 }
	 
	 @Test
	    public void stringCalculatorWithWrongExpression() {
	        try {
	        	String actual = "100 * 2 ++ 12";
	      	  SimpleCalculator.calculate(actual);
	        } catch (ArithmeticException e) {

	        	assertThat(e.getMessage(), is("/ by zero"));
				//assert others
	        }
	    }

	}