package SerivceTest;

import static org.junit.Assert.*;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import Service.RomanConverterImpl;

public class RomanConverterImplTest {

	@ParameterizedTest
	@ValueSource(ints = {0,1,3,3001})
	public void testConvertToRoman(int number) {
		if(number<=0 || number > 3000)
			assertTrue(new RomanConverterImpl().convertToRoman(number).equals("NOT IMPLEMENTED BY ROMANS"));
		String actualResult = new RomanConverterImpl().convertToRoman(369);
		String expectedResult = "CCCLXIX";
		assertTrue(actualResult instanceof String);
		assertEquals(expectedResult, actualResult);
	}
	
	
	@Test
	public void testConvertDigitToRoman() {
		int [] expectedDigitsTab = {1,2,3,4,5,6,7,8,9};
		String[] expectedResult = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
		assertTrue(new RomanConverterImpl().convertDigitToRoman(1,"unites") instanceof String);
		for(int i = 0 ; i < 9; i ++)
			assertTrue(new RomanConverterImpl().convertDigitToRoman(expectedDigitsTab[i],"unites").equals(expectedResult[i]));

		
	}
	


}
