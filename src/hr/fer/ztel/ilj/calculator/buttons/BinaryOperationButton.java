package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

import java.util.function.IntBinaryOperator;

public class BinaryOperationButton extends Button {

	private IntBinaryOperator operator;

	public BinaryOperationButton(String name, IntBinaryOperator operator) {
		super(name);
		this.operator = operator;
	}

	@Override
	public void execute(CalculatorBackend logicUnit) {
		logicUnit.pressBinaryOperationButton();
		logicUnit.getOperator().setValue(name);
		logicUnit.setBinaryOperator(operator);
	}

}
