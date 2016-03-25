package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

public class EqualsButton extends Button {

	public EqualsButton() {
		super("=");
	}

	@Override
	public void execute(CalculatorBackend logicUnit) {
		logicUnit.pressEquals();
	}

}
