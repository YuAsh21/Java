public class DecimalNumber extends Number{
	
	public DecimalNumber(){
		setValue("0");
	}

	public DecimalNumber(String number){
		setValue(number);
	}

	public void setValue(String number) throws InvalidDigitException{
		value = Integer.parseInt(number);
	}

	public void addValue(String number) throws InvalidDigitException{

	}

	private boolean isValid(char c){
		if(c.isDigit()){
			return true;
		}
		else{
			return false;
		}
	}

	private int computeValue(String number) throws InvalidDigitException{

	}

	public String toString(){

	}

}