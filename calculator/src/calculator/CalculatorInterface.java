package calculator;

public interface CalculatorInterface {
	// Take input from user
	public void input();

	// Return the result of the current operations
	public double getResult();

	// save already done operations by max of 5 operations
	public void saveHistory();
}
