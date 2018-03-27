package calculator;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.ContentDisplay;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public abstract class CalculatorGuiDesign extends PanesAndNodes {
	// main used pane and VBox an output text
	Pane pane = new Pane();
	VBox verticalArrange = new VBox();
	Label output = new Label("Choose TextBox first");

	public void start(Stage primaryStage) {
		pane.setStyle("-fx-background-color:#586474");
		// main VBox editing
		verticalArrange.setLayoutX(5);
		verticalArrange.setLayoutY(10);
		verticalArrange.setSpacing(15);
		// calling methods
		dataReading();
		operations();
		numbersButtons();
		showOutput();
		optionsButtons();
		editHistroy();
		historyComboBox();
		// adding main VBox to pane
		pane.getChildren().add(verticalArrange);
		Scene scene = new Scene(pane, 600, 350);
		primaryStage.setTitle("Simple Calculator By:Youssef Kishk , ID:3812");
		primaryStage.setScene(scene);
		primaryStage.show();
		primaryStage.setResizable(false);
	}

	public void dataReading() {
		number1Field.setPromptText("First Number");
		number2Field.setPromptText("Second Number");
		// first number label and text field editing
		dataReadingNodesEdit(number1Field);
		// second number label and text field editing
		dataReadingNodesEdit(number2Field);
		// HBox editing
		readDataBox.setTranslateX(14);
		readDataBox.setSpacing(58);
		// add nodes to HBox
		readDataBox.getChildren().addAll(number1Field, number2Field);
		// add HBox to main VBox
		verticalArrange.getChildren().add(readDataBox);
	}

	public void operations() {
		// setting spaces between nodes in HBox
		operationsBox.setSpacing(40);
		// Enter button size
		enter.setScaleX(1.2);
		enter.setScaleY(1.2);
		// plus button size
		operationsButtonSize(plus);
		// minus button size
		operationsButtonSize(minus);
		// times button size
		operationsButtonSize(times);
		// devision button size
		operationsButtonSize(devision);
		// backSpace button size
		backSpace.setScaleX(1.1);
		backSpace.setScaleY(1.1);
		operationsBox.setTranslateX(10);
		operationsBox.getChildren().addAll(plus, minus, times, devision);

	}

	public void numbersButtons() {
		// setting spaces between buttons in buttons 7,8,9
		sevenToNine.setSpacing(40);
		// size of buttons from PanesAndNodes class
		setNumbersButtonsSize(seven);
		setNumbersButtonsSize(eight);
		setNumbersButtonsSize(nine);
		// adding buttons to HBox
		sevenToNine.getChildren().addAll(seven, eight, nine);
		// setting spaces between buttons in buttons 4,5,6
		fourToSix.setSpacing(40);
		// size of buttons
		setNumbersButtonsSize(four);
		setNumbersButtonsSize(five);
		setNumbersButtonsSize(six);
		// adding buttons to HBox
		fourToSix.getChildren().addAll(four, five, six);
		// setting spaces between buttons in buttons 1,2,3
		oneToThree.setSpacing(40);
		// size of buttons
		setNumbersButtonsSize(one);
		setNumbersButtonsSize(two);
		setNumbersButtonsSize(three);
		// adding buttons to HBox
		oneToThree.getChildren().addAll(one, two, three);
		// setting spaces between buttons in buttons 0,.,-
		zeroandNegative.setSpacing(40);
		// size of buttons
		setNumbersButtonsSize(zero);
		setNumbersButtonsSize(point);
		setNumbersButtonsSize(negative);
		// adding buttons to HBox
		zeroandNegative.getChildren().addAll(zero, point, negative);
		// VBox editing
		arrangeButtons.setTranslateX(20);
		arrangeButtons.setTranslateY(10);
		arrangeButtons.setSpacing(40);
		// add all HBoxes to VBox
		arrangeButtons.getChildren().addAll(sevenToNine, fourToSix, oneToThree,
				zeroandNegative);
		// place operation behind numbers
		oprationAndButtons.setSpacing(50);
		operationsBox.setTranslateY(10);
		enterBox.getChildren().addAll(enter, backSpace);
		enterBox.setSpacing(30);
		enterBox.setTranslateY(10);

		oprationAndButtons.getChildren().addAll(arrangeButtons, operationsBox,
				enterBox);
		// add VBox to main VBox
		verticalArrange.getChildren().add(oprationAndButtons);
	}

	// output text
	public void showOutput() {
		Rectangle r = new Rectangle(320, 62);
		r.setFill(Color.WHITESMOKE);
		r.setStyle("-fx-stroke:black");
		r.setArcWidth(50);
		r.setArcHeight(50);
		output.setGraphic(r);
		output.setContentDisplay(ContentDisplay.CENTER);
		output.setTextFill(Color.DARKSLATEBLUE);
		output.setText("Output appears here");
		output.setFont(Font.font("", FontWeight.BOLD, 19));
		enterBox.getChildren().add(output);
	}

	public void optionsButtons() {
		buttons.setAlignment(Pos.CENTER);
		// buttons HBox editing
		buttons.setSpacing(37);
		// useCurrent button size editing
		useCurrent.setScaleX(1.2);
		useCurrent.setScaleY(1.2);
		// clear button size
		clear.setScaleX(1.2);
		clear.setScaleY(1.2);
		// add buttons to HBox
		buttons.getChildren().addAll(clear, useCurrent);
		// add HBox to main VBox
		enterBox.getChildren().add(buttons);
	}

	public void editHistroy() {
		// HBox editing
		editArrange.setAlignment(Pos.CENTER);
		editArrange.setSpacing(87);
		editArrange.setTranslateY(13);
		// setting edit label font and graphic it hold
		edit.setFont(Font.font("Algerian", FontWeight.BOLD,
				FontPosture.REGULAR, 16));
		edit.setContentDisplay(ContentDisplay.RIGHT);
		// valueToEdit text field editing
		// edit button size
		editValue.setScaleX(1.3);
		editValue.setScaleY(1.3);
		editArrange.getChildren().addAll(edit, editValue);
		readDataBox.getChildren().add(cb);
		verticalArrange.getChildren().add(editArrange);
	}
}