package operations;

import org.junit.Test;
import org.junit.Assert;
import org.junit.rules.ExpectedException;
import org.junit.Rule;

/***
 * A class that performs tests on the IntegerOperations class. It contains test
 * cases for the functional methods of reverseSign, add, powerOfTwo
 *
 * @author IoannisVougias
 */
public class IntegerOperationsTest {

	IntegerOperations mm = new IntegerOperations();

	/***
	 * Test cases for method reverseSign
	 */
	@Test
	public void test_reverseSign_positive() {
		Assert.assertEquals(-10, mm.reverseSign(10));
	}

	@Test
	public void test_reverseSign_negative() {
		Assert.assertEquals(10, mm.reverseSign(-10));
	}

	@Test
	public void test_reverseSign_zero() {
		Assert.assertEquals(0, mm.reverseSign(0));
	}

	/**
	 * Test cases for add method
	 */
	@Test(expected = IllegalArgumentException.class)
	public void test_add_positive_negative() {
		mm.add(1, -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_add_negative_positive() {
		mm.add(-3, 3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_add_zero_negative() {
		mm.add(0, -3);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_add_negative_zero() {
		mm.add(-3, 0);
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_add_check_max_value() {
		mm.add(2147483647, Integer.MAX_VALUE - 5);
	}

	@Test
	public void test_add_positive_numbers() {
		Assert.assertEquals(10, mm.add(5, 5));
	}

	@Test
	public void test_add_zeros() {
		Assert.assertEquals(0, mm.add(0, 0));
	}

	@Test
	public void test_add_zero_positive() {
		Assert.assertEquals(23, mm.add(0, 23));
	}

	/**
	 * Test cases for powerOfTwo method
	 */
	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void test_powerOfTwo_negative_RuleExcpetion() {
		thrown.expect(IllegalArgumentException.class);
		mm.powerOfTwo(-1);
	}

	@Test
	public void test_powerOfTwo_overflow_RuleExcpetion() {
		thrown.expect(IllegalArgumentException.class);
		mm.powerOfTwo(31);
	}

}
