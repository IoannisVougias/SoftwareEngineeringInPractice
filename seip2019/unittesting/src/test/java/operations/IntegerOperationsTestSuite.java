package operations;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/***
 * A class that performs test suite that executes all test classes of of the
 * IntegerOperations functional class
 *
 * @author IoannisVougias
 */

@RunWith(Suite.class)
@Suite.SuiteClasses({ IntegerOperationsTest.class, IntegerOperations_Test_PowerOfTwo_Parameterized.class })
public class IntegerOperationsTestSuite {

	/*
	 * This class remains empty. It is used only as a holder of the above
	 * annotations.
	 */

}
