	package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

/**
 * Class which represents a button on the calculator.
 *
 * @author Boris Generalic
 *
 */
public abstract class Button {

	/**
	 * Name of this button.
	 */
	protected final String name;

	/**
	 * Creates a new button with given name.
	 *
	 * @param buttonName	name of the button
	 */
	public Button(final String name) {
		this.name = name;
	}

	/**
	 * Returns button's name.
	 */
	@Override
	public String toString() {
		return name;
	}

	/**
	 * Method which is called when some button which extends this class is pressed.
	 *
	 * @param calc	{@link CalculatorBackend} which is used to perform defined action
	 */
	public abstract void execute(CalculatorBackend calc);

}
