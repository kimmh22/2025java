package study09_intface;

public  class CompleteCalc extends Calculator {



	@Override
	public int times(int num1, int num2) {
		// TODO Auto-generated method stub
		return num1 * num2;
	}

	@Override
	public int divide(int num1, int num2) {

		if (num2 == 0) {
			return 0;
		} else {
			return num1 / num2;
		}

	} 
	public String showInfo() {
		return"완료";
	}

}
