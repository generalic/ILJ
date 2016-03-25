package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

/**
 * Class which represents a button with digits on calculator.
 *
 * @author Formula1
 *
 */
public class DigitButton extends Button {

	private int number;

	/**
	 * Creates a new button with given digit on it.
	 *
	 * @param number	digit to represent
	 */
	public DigitButton(int number) {
		super(Integer.toString(number));
		this.number = number;
	}

	@Override
	public void execute(CalculatorBackend logicUnit) {
		logicUnit.pressDigit(number);
	}
}
