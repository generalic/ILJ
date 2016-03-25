package hr.fer.ztel.ilj.calculator.buttons;

import hr.fer.ztel.ilj.calculator.CalculatorBackend;

import java.util.function.Consumer;

public class ControlButton extends Button {

	private Consumer<CalculatorBackend> consumer;

	public ControlButton(String name, Consumer<CalculatorBackend> consumer) {
		super(name);
		this.consumer = consumer;
	}

	@Override
	public void execute(CalculatorBackend logicUnit) {
		consumer.accept(logicUnit);
	}

}
