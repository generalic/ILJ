package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

/**
 * Class which represents a button with digits on calculator.
 *
 * @author Boris Generalic
 *
 */
public class DigitButton extends Button {

	/** Number which this buttons stands for. */
	private final int number;

	/**
	 * Creates a new button with given digit on it.
	 *
	 * @param number	digit to represent
	 */
	public DigitButton(final int number) {
		super(Integer.toString(number));
		this.number = number;
	}

	@Override
	public void execute(final CalculatorBackend calc) {
		calc.pressDigit(number);
	}
}
