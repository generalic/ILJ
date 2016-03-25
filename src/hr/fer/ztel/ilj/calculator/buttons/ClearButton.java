package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

public class ClearButton extends Button {

	public ClearButton() {
		super("C");
	}

	@Override
	public void execute(CalculatorBackend logicUnit) {
		logicUnit.pressClear();
	}

}
