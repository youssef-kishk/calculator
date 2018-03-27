package calculator;

import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public abstract class PanesAndNodes extends Application {
	public void start(Stage arg0) throws Exception {
	}

	// dataReading method panes and nodes
	HBox readDataBox = new HBox();
	TextField number1Field = new TextField();
	TextField number2Field = new TextField();

	public void dataReadingNodesEdit(TextField t) {
		t.setMaxWidth(130);
		t.setMinHeight(27);
		t.setFocusTraversable(false);
	}

	// operations method panes and nodes
	VBox operationsBox = new VBox();
	TextField inputOperation = new TextField();
	Button enter = new Button("Enter");
	Button plus = new Button("+");
	Button minus = new Button(" - ");
	Button times = new Button(" * ");
	Button devision = new Button(" / ");
	Button backSpace = new Button("<-");

	public void operationsButtonSize(Button b) {
		b.setStyle("-fx-background-color:Gainsboro");
		b.setFont(Font.font(12));
		b.setScaleX(1.3);
		b.setScaleY(1.3);

	}

	// numbersButtons panes and nodes
	VBox arrangeButtons = new VBox();
	HBox oprationAndButtons = new HBox();
	VBox enterBox = new VBox();
	HBox sevenToNine = new HBox();
	Button seven = new Button("7");
	Button eight = new Button("8");
	Button nine = new Button("9");
	HBox fourToSix = new HBox();
	Button four = new Button("4");
	Button five = new Button("5");
	Button six = new Button("6");
	HBox oneToThree = new HBox();
	Button one = new Button("1");
	Button two = new Button("2");
	Button three = new Button("3");
	HBox zeroandNegative = new HBox();
	Button zero = new Button("0");
	Button point = new Button(" .");
	Button negative = new Button("-x");

	public void setNumbersButtonsSize(Button b) {
		b.setStyle("-fx-background-color:Gainsboro");
		negative.setFont(Font.font(11));
		b.setScaleX(1.4);
		b.setScaleY(1.4);
	}

	// optionsButtons method panes and nodes
	HBox buttons = new HBox();
	Button useCurrent = new Button("Use Current Output");
	Button clear = new Button("Reset");
	// editHistory method panes and nodes
	ComboBox<String> cb = new ComboBox<>();
	HBox editArrange = new HBox();
	Label edit = new Label(
			"\tFor Editing Certain Operation Press Edit \n\tAfter Choosing it from show History list");
	Button editValue = new Button("Edit");

	public void historyComboBox() {
		cb.setPromptText("Show History");
		cb.setPrefWidth(180);
		cb.setPrefHeight(30);
		cb.setTranslateX(12);
	}

}
