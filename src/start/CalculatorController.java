package start;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;
import hr.fer.ztel.ilj.calculator.buttons.BinaryOperationButton;
import hr.fer.ztel.ilj.calculator.buttons.ControlButton;
import hr.fer.ztel.ilj.calculator.buttons.DigitButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CalculatorController {

	@FXML
	private Button digitButton0;

	@FXML
	private Button digitButton1;

	@FXML
	private Button digitButton2;

	@FXML
	private Button digitButton3;

	@FXML
	private Button digitButton4;

	@FXML
	private Button digitButton5;

	@FXML
	private Button digitButton6;

	@FXML
	private Button digitButton7;

	@FXML
	private Button digitButton8;

	@FXML
	private Button digitButton9;

	@FXML
	private Button plusButton;

	@FXML
	private Button minusButton;

	@FXML
	private Button equalsButton;

	@FXML
	private Button clearButton;

	@FXML
	private TextField displayTextField;

	@FXML
	private TextField registersTextField;

	@FXML
	public void initialize() {
		CalculatorBackend calc = new CalculatorBackend();

		DigitButton b0 = new DigitButton(0);
		digitButton0.setOnAction(e -> calc.press(b0));
		DigitButton b1 = new DigitButton(1);
		digitButton1.setOnAction(e -> calc.press(b1));
		DigitButton b2 = new DigitButton(2);
		digitButton2.setOnAction(e -> calc.press(b2));
		DigitButton b3 = new DigitButton(3);
		digitButton3.setOnAction(e -> calc.press(b3));
		DigitButton b4 = new DigitButton(4);
		digitButton4.setOnAction(e -> calc.press(b4));
		DigitButton b5 = new DigitButton(5);
		digitButton5.setOnAction(e -> calc.press(b5));
		DigitButton b6 = new DigitButton(6);
		digitButton6.setOnAction(e -> calc.press(b6));
		DigitButton b7 = new DigitButton(7);
		digitButton7.setOnAction(e -> calc.press(b7));
		DigitButton b8 = new DigitButton(8);
		digitButton8.setOnAction(e -> calc.press(b8));
		DigitButton b9 = new DigitButton(9);
		digitButton9.setOnAction(e -> calc.press(b9));

		BinaryOperationButton plus = new BinaryOperationButton("+", (x, y) -> x + y);
		plusButton.setOnAction(e -> calc.press(plus));
		BinaryOperationButton minus = new BinaryOperationButton("-", (x, y) -> x - y);
		minusButton.setOnAction(e -> calc.press(minus));

		ControlButton equals = new ControlButton("=", CalculatorBackend::pressEquals);
		equalsButton.setOnAction(e -> calc.press(equals));
		ControlButton clear = new ControlButton("C", CalculatorBackend::pressClear);
		clearButton.setOnAction(e -> calc.press(clear));

		displayTextField.textProperty().bind(calc.getDisplay().valueProperty().asString());
		registersTextField.textProperty().bind(
				new SimpleStringProperty("D:")
						.concat(calc.getDisplay().valueProperty())
						.concat(new SimpleStringProperty(" M:"))
						.concat(calc.getMemory().valueProperty())
						.concat(new SimpleStringProperty(" O:"))
						.concat(calc.getOperator().valueProperty())
		);
	}

}
