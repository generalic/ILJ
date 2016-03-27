package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

import java.util.function.IntBinaryOperator;

/**
 * Class which represents binary operation button of the calculator.
 *
 * @author Boris Generalic
 *
 */
public class BinaryOperationButton extends Button {

	/**
	 * Binary operator which takes two numbers and calculates the result.
	 */
	private final IntBinaryOperator operator;

	/**
	 * Creates a new instance of {@link BinaryOperationButton}.
	 *
	 * @param name		name of the button
	 * @param operator	given binary operator
	 */
	public BinaryOperationButton(final String name, final IntBinaryOperator operator) {
		super(name);
		this.operator = operator;
	}

	@Override
	public void execute(final CalculatorBackend calc) {
		calc.pressBinaryOperationButton();
		calc.getOperator().setValue(name);
		calc.setBinaryOperator(operator);
	}

}
