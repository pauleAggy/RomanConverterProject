package Service;

import java.util.Scanner;

public class RomanRunner {
	
	public static void main(String[] args) {
		 System.out.println("Enter a number :");
		 Scanner scanIn = new Scanner(System.in);  
		 int number = scanIn.nextInt();
		 String roman = convert(new RomanConverterImpl(),number);
		 System.out.println(roman);
	}
	
	public static String convert(RomanConverter romanConverter, int number) {
		return romanConverter.convertToRoman(number);
	}
   

}
