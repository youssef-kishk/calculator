package calculator;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Actions extends Calculator {
	public static void main(String[] args) {
		Application.launch(args);
	}

	// overriding start method to complete rest of its body
	public void start(Stage stage2) {
		// calling parent method body
		super.start(stage2);
		// calling methods
		callMethods();
	}

	public void callMethods() {
		enterButtonAction();
		operationsButtonsActions();
		numbersButtonsActions(nine);
		numbersButtonsActions(eight);
		numbersButtonsActions(seven);
		numbersButtonsActions(six);
		numbersButtonsActions(five);
		numbersButtonsActions(four);
		numbersButtonsActions(three);
		numbersButtonsActions(two);
		numbersButtonsActions(one);
		numbersButtonsActions(zero);
		pointButtonAction();
		negativeButtonAction();
		backspaceButtonAction();
		useCurrentValueAction();
		clearAction();
		editButtonAction();
	}

	// setting enter button to action to calculate value
	public void enterButtonAction() {
		enter.setOnAction(e -> {
			plus.setDisable(false);
			minus.setDisable(false);
			times.setDisable(false);
			devision.setDisable(false);
			input();
			if (check == 1
					|| (inputOperation.getText().charAt(0) == '/' && number2Field
							.getText().equals("0"))) {
				output.setText("Invalid Input");
				number1Field.clear();
				number2Field.clear();
				inputOperation.clear();
				return;
			}
			getResult();
			// check operation input
			if (inputOperation.getText().charAt(0) == '+'
					|| inputOperation.getText().charAt(0) == '-'
					|| inputOperation.getText().charAt(0) == '*'
					|| inputOperation.getText().charAt(0) == '/') {
				output.setText(number1Field.getText()
						+ inputOperation.getText() + number2Field.getText()
						+ "=" + getResult());
				if (editButtonCheck == 1) {
					lastOperationsArray[editPlace] = output.getText();
					cb.getItems()
							.set(editPlace, lastOperationsArray[editPlace]);
					editButtonCheck = 0;
				} else if (editButtonCheck == 0) {
					try {
						saveHistory();
					} catch (Exception e1) {
					}
				}
				if (lastOperationsArray[0] != null) {
					useCurrent.setDisable(false);
				}
			}
			number1Field.clear();
			number2Field.clear();
			inputOperation.clear();
			inputOperation.setDisable(false);
		});
	}

	public void operationsButtonsActions() {
		// setting operations buttons to action according to pressed button
		plus.setOnAction(e -> {
			if (inputOperation.getText().equals("")
					|| !inputOperation.isDisabled())
				inputOperation.setText("+");
			plus.setDisable(true);
			minus.setDisable(false);
			times.setDisable(false);
			devision.setDisable(false);
		});
		minus.setOnAction(e -> {
			if (inputOperation.getText().equals("")
					|| !inputOperation.isDisabled())
				inputOperation.setText("-");
			plus.setDisable(false);
			minus.setDisable(true);
			times.setDisable(false);
			devision.setDisable(false);
		});
		times.setOnAction(e -> {
			if (inputOperation.getText().equals("")
					|| !inputOperation.isDisabled())
				inputOperation.setText("*");
			plus.setDisable(false);
			minus.setDisable(false);
			times.setDisable(true);
			devision.setDisable(false);
		});
		devision.setOnAction(e -> {
			if (inputOperation.getText().equals("")
					|| !inputOperation.isDisabled())
				inputOperation.setText("/");
			plus.setDisable(false);
			minus.setDisable(false);
			times.setDisable(false);
			devision.setDisable(true);
		});
	}

	int checkClickPosition = 0;

	public void numbersButtonsActions(Button b) {
		// checking mouse position to determine which text box to write in
		number1Field.setOnMouseClicked((MouseEvent e1) -> {
			checkClickPosition = 1;
		});
		number2Field.setOnMouseClicked((MouseEvent e1) -> {
			checkClickPosition = 2;
		});
		// set value in text box according to pressed button value and chosen
		// text box
		b.setOnAction(e -> {
			if (checkClickPosition == 1) {
				number1Field.setText(number1Field.getText() + b.getText());
			} else if (checkClickPosition == 2) {
				number2Field.setText(number2Field.getText() + b.getText());
			} else
				output.setText("Choose Number Field first");
		});
	}

	// handling point button action
	public void pointButtonAction() {
		point.setOnAction(e -> {
			if (checkClickPosition == 1
					&& !number1Field.getText().contains("."))
				number1Field.setText(number1Field.getText() + ".");
			else if (checkClickPosition == 2
					&& !number2Field.getText().contains("."))
				number2Field.setText(number2Field.getText() + ".");
		});
	}

	// handling negative button action
	public void negativeButtonAction() {
		negative.setOnAction(e -> {
			if (checkClickPosition == 1) {
				if (number1Field.getText().isEmpty()) {
					number1Field.setText("-");
				} else if (!number1Field.getText().contains("-")) {
					number1Field.setText("-" + number1Field.getText());
				}
			} else if (checkClickPosition == 2) {
				if (number2Field.getText().isEmpty()) {
					number2Field.setText("-");
					output.setText("");
				} else if (!number2Field.getText().contains("-")) {
					number2Field.setText("-" + number2Field.getText());
					output.setText("");
				}
			}
		});
	}

	// handling back space button actions
	public void backspaceButtonAction() {
		backSpace.setOnAction(e -> {
			if (checkClickPosition == 1 && !number1Field.getText().isEmpty())
				number1Field.setText(number1Field.getText().substring(0,
						number1Field.getText().length() - 1));
			else if (checkClickPosition == 2
					&& !number2Field.getText().isEmpty())
				number2Field.setText(number2Field.getText().substring(0,
						number2Field.getText().length() - 1));
			else
				output.setText("Choose TextBox first");
		});
	}

	// using current value in new operation in selected text field
	public void useCurrentValueAction() {
		useCurrent.setDisable(true);
		useCurrent.setOnAction(e -> {
			if (output.getText().contains("=")
					&& !output.getText().contains(")")) {
				if (checkClickPosition == 2)
					number2Field.setText(output.getText().split("=")[1]);
				else
					number1Field.setText(output.getText().split("=")[1]);
			}
		});
	}

	// clear button action that clear all data
	public void clearAction() {
		clear.setOnAction(e -> {
			number1Field.clear();
			number2Field.clear();
			inputOperation.clear();
			output.setText("");
			useCurrent.setDisable(true);
			inputOperation.setDisable(false);
			editValue.setDisable(true);
			count = 0;
			cb.getItems().clear();
		});
	}

	// used to check if this operation is edited so override it in its place at
	// array don't add it in new location
	int editButtonCheck;
	int editPlace;
	// edit button action
	String strEditFromHistory = "";

	public void editButtonAction() {
		// check box action
		cb.setOnAction(e -> {
			strEditFromHistory = cb.getValue();
			editPlace = cb.getItems().indexOf(cb.getValue());
			editValue.setDisable(false);
		});
		editButtonCheck = 0;
		editValue.setDisable(true);
		editValue.setOnAction(e -> {
			number1Field.clear();
			number2Field.clear();
			inputOperation.clear();
			inputOperation.setDisable(false);
			editButtonCheck = 1;
			try {
				// read operation user want to edit and get it from array
				int check = Integer.MAX_VALUE, c = 0;
				// check if first number is negative number
				if (strEditFromHistory.charAt(0) == '-') {
					number1Field.setText(number1Field.getText()
							+ strEditFromHistory.toCharArray()[0]);
					c = 1;
				}
				for (int i = c; i < strEditFromHistory.length(); i++) {
					// end loop at = character
					if (strEditFromHistory.toCharArray()[i] == '=')
						break;
					// check if character is a number
					if (Character.isDigit(strEditFromHistory.charAt(i))
							|| strEditFromHistory.charAt(i) == '.') {
						if (i < check)
							number1Field.setText(number1Field.getText()
									+ strEditFromHistory.toCharArray()[i]);
						else
							number2Field.setText(number2Field.getText()
									+ strEditFromHistory.toCharArray()[i]);
					}
					// check operation
					else if (strEditFromHistory.charAt(i) == '+'
							|| strEditFromHistory.charAt(i) == '-'
							|| strEditFromHistory.charAt(i) == '*'
							|| strEditFromHistory.charAt(i) == '/') {
						inputOperation.setText(""
								+ strEditFromHistory.toCharArray()[i]);
						check = i;
						// check if second number starts with negative
						if (strEditFromHistory.charAt(i + 1) == '-') {
							number2Field.setText("-" + number2Field.getText());
							i++;
						}
					}
				}
				int temp = editPlace;
				cb.setValue(null);
				editPlace = temp;
			}
			// handling exception
			catch (Exception ex) {
				output.setText("Invalid Input");
				editButtonCheck = 0;
			}

		});
	}
}