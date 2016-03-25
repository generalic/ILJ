	package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

/**
 * Class which represents a button on the calculator.
 *
 * @author generalic
 *
 */
public abstract class Button {

	protected final String name;

	/**
	 * Creates a new button with given name.
	 *
	 * @param buttonName	name of the button
	 */
	public Button(String name) {
		this.name = name;
	}

	/**
	 * Returns button's name.
	 *
	 */
	@Override
	public String toString() {
		return name;
	}

	public abstract void execute(CalculatorBackend logicUnit);

}
