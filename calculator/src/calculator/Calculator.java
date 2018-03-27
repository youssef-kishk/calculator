package calculator;

public class Calculator extends CalculatorGuiDesign implements
		CalculatorInterface {
	// data fields declaration
	private double firstNum;
	private double secondNum;
	private char operation;
	private double result;
	int check = 0;

	// implemented method that take input from user body
	public void input() {
		// try catch is used to check type miss matching
		check = 0;
		try {
			this.firstNum = Double.parseDouble(number1Field.getText());
			this.secondNum = Double.parseDouble(number2Field.getText());
			this.operation = inputOperation.getText().charAt(0);
		}
		// if input contain - or . only
		catch (Exception ee) {
			check = 1;
		}

	}

	public double getResult() {
		switch (operation) {
		case '+':
			result = firstNum + secondNum;
			break;
		case '-':
			result = firstNum - secondNum;
			break;
		case '*':
			result = firstNum * secondNum;
			break;
		case '/':
			result = firstNum / secondNum;
			break;
		}
		return result;
	}

	// array of string to hold last 5 operations
	String[] lastOperationsArray = new String[5];
	int count = 0;
	int checkOverriding = 0;

	// save last operations
	public void saveHistory() {
		if (count < 5) {
			lastOperationsArray[count] = output.getText();
			if (checkOverriding == 0)
				cb.getItems().add(count, lastOperationsArray[count]);
			else
				cb.getItems().set(count, lastOperationsArray[count]);
			count++;
		} else if (count == 5) {
			for (int i = 1; i < 5; i++) {
				lastOperationsArray[i - 1] = lastOperationsArray[i];
				cb.getItems().set(i - 1, lastOperationsArray[i - 1]);
			}
			count--;
			lastOperationsArray[count] = output.getText();
			cb.getItems().set(count, lastOperationsArray[count]);
			count++;
		}
	}
}
