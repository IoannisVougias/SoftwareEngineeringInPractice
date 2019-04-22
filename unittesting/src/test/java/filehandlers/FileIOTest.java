package filehandlers;

import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.Assert;
import org.junit.Rule;

/***
 * Class for testing FileIO class Testing Normal behaviour, Invalid input and a
 * file with wrong content
 * 
 * @author IoannisVougias
 */

public class FileIOTest {

	FileIO file = new FileIO();

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	/***
	 * Test case for when the input is false
	 ***/

	@Test
	public void test_readFile_illegalArgumentException() {
		thrown.expect(IllegalArgumentException.class);
		file.readFile("invalidinput.txt");
	}

	/***
	 * Test cases for normal and NumberFormatException behaviour
	 */

	String validNumbers = "src/test/resources/validNumbers.txt";
	String invalidContent = "src/test/resources/invalidContent.txt";
	int[] validResults = { 1, 2, 3, 4 };

	@Test
	public void test_readFileNormalBehaviour() {
		Assert.assertArrayEquals(validResults, file.readFile(validNumbers));
	}

	@Test
	public void test_readFile_NumberFormatException() {
		thrown.expect(NumberFormatException.class);
		file.readFile(invalidContent);
	}

}
