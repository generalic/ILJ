package start;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;
import hr.fer.ztel.ilj.calculator.buttons.BinaryOperationButton;
import hr.fer.ztel.ilj.calculator.buttons.ControlButton;
import hr.fer.ztel.ilj.calculator.buttons.DigitButton;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

/**
 * Controller class for Pane generated from FXML which represents layout for
 * calculator application.
 *
 * @author Boris Generalic
 *
 */
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
		final CalculatorBackend calc = new CalculatorBackend();
		bindButtons(calc);
		bindDisplays(calc);
	}

	/**
	 * Binds action to each button which will be performed when button is clicked.
	 *
	 * @param calc	{@link CalculatorBackend}
	 */
	private void bindButtons(final CalculatorBackend calc) {
		final DigitButton b0 = new DigitButton(0);
		digitButton0.setOnAction(e -> calc.press(b0));
		final DigitButton b1 = new DigitButton(1);
		digitButton1.setOnAction(e -> calc.press(b1));
		final DigitButton b2 = new DigitButton(2);
		digitButton2.setOnAction(e -> calc.press(b2));
		final DigitButton b3 = new DigitButton(3);
		digitButton3.setOnAction(e -> calc.press(b3));
		final DigitButton b4 = new DigitButton(4);
		digitButton4.setOnAction(e -> calc.press(b4));
		final DigitButton b5 = new DigitButton(5);
		digitButton5.setOnAction(e -> calc.press(b5));
		final DigitButton b6 = new DigitButton(6);
		digitButton6.setOnAction(e -> calc.press(b6));
		final DigitButton b7 = new DigitButton(7);
		digitButton7.setOnAction(e -> calc.press(b7));
		final DigitButton b8 = new DigitButton(8);
		digitButton8.setOnAction(e -> calc.press(b8));
		final DigitButton b9 = new DigitButton(9);
		digitButton9.setOnAction(e -> calc.press(b9));

		final BinaryOperationButton plus = new BinaryOperationButton("+", (x, y) -> x + y);
		plusButton.setOnAction(e -> calc.press(plus));
		final BinaryOperationButton minus = new BinaryOperationButton("-", (x, y) -> x - y);
		minusButton.setOnAction(e -> calc.press(minus));

		final ControlButton equals = new ControlButton("=", CalculatorBackend::pressEquals);
		equalsButton.setOnAction(e -> calc.press(equals));
		final ControlButton clear = new ControlButton("C", CalculatorBackend::pressClear);
		clearButton.setOnAction(e -> calc.press(clear));
	}

	/**
	 * Binds text which will be displayed on calculator display.
	 *
	 * @param calc	{@link CalculatorBackend}
	 */
	private void bindDisplays(final CalculatorBackend calc) {
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
