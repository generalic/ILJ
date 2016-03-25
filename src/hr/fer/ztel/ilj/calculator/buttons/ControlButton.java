package hr.fer.ztel.ilj.calculator.buttons;

import java.util.function.Consumer;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

/**
 * Class which represents button which is used for some standard control
 * on the calculator. For example clear action or equals action.
 *
 * @author Boris Generalic
 *
 */
public class ControlButton extends Button {

	/**
	 * Consumes {@link CalculatorBackend} for defined action.
	 */
	private final Consumer<CalculatorBackend> consumer;

	/**
	 * Creates new instance of {@link ControlButton} class with given name and defined
	 * consumer action.
	 *
	 * @param name		name of the button
	 * @param consumer	defined action
	 */
	public ControlButton(final String name, final Consumer<CalculatorBackend> consumer) {
		super(name);
		this.consumer = consumer;
	}

	@Override
	public void execute(final CalculatorBackend logicUnit) {
		consumer.accept(logicUnit);
	}

}
