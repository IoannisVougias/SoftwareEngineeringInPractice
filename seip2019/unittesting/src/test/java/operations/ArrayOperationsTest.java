package operations;

import org.junit.Test;
import org.junit.Assert;
import filehandlers.FileIO;

import static org.mockito.Mockito.*;

/***
 * Class that tests ArrayOperations Test cases: for methods reverseArray and
 * findMaxInFile with validNumbers txt and invalidContent txt files
 *
 * @author IoannisVougias
 */

public class ArrayOperationsTest {
	/***
	 * Files from resources folder
	 */
	String validNumbers = "src/test/resources/validNumbers.txt";
	String invalidContent = "src/test/resources/invalidContent.txt";

	@Test
  public void test_reverseArray_NormalBehaviour_Mocking() {
    //Mock integerOperations and fileIo depedency
    IntegerOperations io = mock(IntegerOperations.class);
    FileIO fi = mock(FileIO.class);
    //Use the parameterized Constructor
    ArrayOperrations ao = new ArrayOperrations(fi, io);
    //Case of opening the validNumbers txt file
    when(fi.readFile(validNumbers)).thenReturn(new int[] {1,2,3,4});
    //Case of testing reverseSign on all the numbers
    when(io.reverseSign(1)).thenReturn(-1);
    when(io.reverseSign(2)).thenReturn(-2);
    when(io.reverseSign(3)).thenReturn(-3);
    when(io.reverseSign(4)).thenReturn(-4);
    //Case of testing reverseArray on the array with these numbers
    ao.reverseArray(validNumbers);
  }

	@Test(expected = IllegalArgumentException.class)
	public void test_reverseArrayException() {
		FileIO fi = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);
		ArrayOperrations ao = new ArrayOperrations(fi, io);
		// Case of opening the invalidContent txt file
		when(fi.readFile(invalidContent)).thenReturn(new int[] {});
		ao.reverseArray(invalidContent);
	}

	@Test
	public void test_findMaxInFile_NormalBehaviour_Mocking() {
		FileIO fi = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);
		ArrayOperrations ao = new ArrayOperrations(fi, io);
		when(fi.readFile(validNumbers)).thenReturn(new int[] { 1, 2, 3, 4 });
		Assert.assertEquals(4, ao.findMaxInFile(validNumbers));
	}

	@Test(expected = IllegalArgumentException.class)
	public void test_findMaxInFileException() {
		// case of opening invalidContent txt file on findMaxInFile method
		FileIO fi = mock(FileIO.class);
		IntegerOperations io = mock(IntegerOperations.class);
		ArrayOperrations ao = new ArrayOperrations(fi, io);
		when(fi.readFile(invalidContent)).thenReturn(new int[] {});
		ao.findMaxInFile(invalidContent);
	}

}
