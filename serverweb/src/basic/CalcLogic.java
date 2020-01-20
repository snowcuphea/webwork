package basic;

public class CalcLogic {
	public int calc(int num1, String method, int num2) {
		int result =0;
		System.out.println("비즈니스 로직 호출");
		
		switch (method) {
		case "+":
			result = num1+num2;
			break;
			
		case "-":
			result = num1-num2;
			break;
			
		case "*":
			result = num1*num2;
			break;
			
		case "/":
			result = num1/num2;
			break;

		default:
			break;
			
		}
		
		return result;
	}

}
