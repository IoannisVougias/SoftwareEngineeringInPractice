package operations;

import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameter;
import org.junit.runners.Parameterized.Parameters;

import org.junit.Assert;

/***
 * Dedicated class for the parameterized test of the method powerOfTwo
 *
 * @author IoannisVougias
 */
@RunWith(Parameterized.class)
public class IntegerOperations_Test_PowerOfTwo_Parameterized {

	/***
	 * Parameters to check powerOfTwo for power of 0 and power of 1
	 */

	@Parameter(value = 0)
	public int power_of_zero;
	@Parameter(value = 1)
	public int result_of_zero;
	@Parameter(value = 1)
	public int power_of_one;
	@Parameter(value = 2)
	public int result_of_one;

	IntegerOperations io = new IntegerOperations();

	/***
	 * Parameters to check powerOfTwo for power of 2,3,4,5
	 */

	@Parameters
	public static Collection<Object[]> data() {
		Object[][] data = new Object[][] { { 2, 4 }, { 3, 8 }, { 4, 16 }, { 5, 32 } };

		return Arrays.asList(data);
	}

	/***
	 * Test cases for power of zero and power of one
	 */
	@Test
	public void test_powerOfTwo() {
		Assert.assertEquals(result_of_zero, io.powerOfTwo(power_of_zero));
		Assert.assertEquals(result_of_one, io.powerOfTwo(power_of_one));
	}

}
