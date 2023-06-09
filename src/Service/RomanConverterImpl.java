package Service;

public class RomanConverterImpl implements RomanConverter{

	@Override
	public String convertToRoman(int number) {
		if(number <=0 || number > 3000) return "NOT IMPLEMENTED BY ROMANS";

		String numberToConvert = String.valueOf(number);
		StringBuilder result= new StringBuilder();
		int len = numberToConvert.length();
		
		//fill any number less than 4 digits with zeros before
		if(len<4) {
			int fillZeros = 4-len;
			String zeros ="";
			for(int i = 1; i <= fillZeros; i++)
				zeros+="0";
			numberToConvert=zeros+numberToConvert;
		}
		String[] positions = {"milliers","centaines","dizaines","unites"};
		for(int i = 0; i<numberToConvert.toCharArray().length;i++) {
			if(numberToConvert.charAt(i)!='0') {
				int digitValue = Integer.parseInt(String.valueOf(numberToConvert.charAt(i)));
				String digitToRoman = convertDigitToRoman(digitValue, positions[i]);
				result.append(digitToRoman);
			}
		}
		return result.toString();
	}

	
	public String convertDigitToRoman(int digitValue, String positionInNumber)  {

		String	singlepattern= returnSinglePattern(digitValue,positionInNumber);

		if(digitValue < 4) 
			return repeatPattern(digitValue,singlepattern);

		else if(digitValue == 5)
			return singlepattern;
		
		else if( 5 < digitValue && digitValue < 9) 
			return additionCase( digitValue, positionInNumber);			
		else
			return substractionCase( digitValue, positionInNumber);
			
	}

	public String repeatPattern(int numRepetitions,String patternToRepeat) {
		StringBuilder result = new StringBuilder();
		for(int i=1;i<=numRepetitions;i++) result.append(patternToRepeat);
		return result.toString();
	}

	public String returnSinglePattern(int digitValue,String positionInNumber) {
		if(digitValue < 4) {
			if(positionInNumber.equals("unites")) return "I";
			if(positionInNumber.equals("dizaines")) return "X";
			if(positionInNumber.equals("centaines")) return "C";
			if(positionInNumber.equals("milliers")) return "M";
		}else if(digitValue == 5) {
			if(positionInNumber.equals("unites")) return "V";
			if(positionInNumber.equals("dizaines")) return "L";
            if(positionInNumber.equals("centaines")) return "D";	
		}
		return "";	
	}
	
	public String additionCase(int digitValue,String positionInNumber) {
		int numOfRepetitions = digitValue -5;
		String patternToRepeat =  returnSinglePattern(1, positionInNumber);
		return ""+returnSinglePattern(5,positionInNumber)+""+repeatPattern(numOfRepetitions,patternToRepeat);
	}

	public String substractionCase(int digitValue,String positionInNumber) {
		if(digitValue == 9) {
			if(positionInNumber.equals("unites"))
				return ""+returnSinglePattern(1,"unites")+""+returnSinglePattern(1,"dizaines");
			if(positionInNumber.equals("dizaines"))
				return ""+returnSinglePattern(1,"dizaines")+""+returnSinglePattern(1,"centaines");
			if(positionInNumber.equals("centaines"))
				return ""+returnSinglePattern(1,"centaines")+""+returnSinglePattern(1,"milliers");
		}else {
			if(positionInNumber.equals("unites"))
				return ""+returnSinglePattern(1,"unites")+""+returnSinglePattern(5,"unites");
			if(positionInNumber.equals("dizaines"))
				return ""+returnSinglePattern(1,"dizaines")+""+returnSinglePattern(5,"dizaines");
			if(positionInNumber.equals("centaines"))
				return ""+returnSinglePattern(1,"centaines")+""+returnSinglePattern(5,"centaines");
		}
		return "";
	}
	


}
