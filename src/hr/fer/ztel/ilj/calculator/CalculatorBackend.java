package hr.fer.ztel.ilj.calculator;

import hr.fer.ztel.ilj.calculator.buttons.BinaryOperationButton;
import hr.fer.ztel.ilj.calculator.buttons.Button;
import hr.fer.ztel.ilj.calculator.buttons.ControlButton;
import hr.fer.ztel.ilj.calculator.buttons.DigitButton;
import hr.fer.ztel.ilj.calculator.register.Register;

import java.util.Objects;
import java.util.function.IntBinaryOperator;

public class CalculatorBackend {

	private Register<Integer> display = new Register<>(0);
	private Register<Integer> memory = new Register<>(0);
	private Register<String> operator = new Register<>();

	private IntBinaryOperator binaryOperator;

	private boolean nextNumber = false;

	/**
	 * Creates a new calculator with wiped registers.
	 *
	 */
	public CalculatorBackend() {
		pressClear();
	}

	/**
	 * Returns display register.
	 *
	 * @return	display register
	 */
	public Register<Integer> getDisplay() {
		return display;
	}

	/**
	 * Returns memory register.
	 *
	 * @return	memory register
	 */
	public Register<Integer> getMemory() {
		return memory;
	}

	/**
	 * Returns operator register.
	 *
	 * @return	operator register
	 */
	public Register<String> getOperator() {
		return operator;
	}

	public void setBinaryOperator(IntBinaryOperator binaryOperator) {
		this.binaryOperator = binaryOperator;
	}

	/**
	 * Checks which button is pressed and calls the method of that button.
	 * @param button	name of the pressed button
	 */
	public void press(Button button) {
		button.execute(this);
	}

	/**
	 * Method for pressing digits on calculator.
	 * @param digit	pressed digit
	 */
	public void pressDigit(int digit) {
		if(nextNumber) {
			display.setValue(0);
		}
		display.setValue(buildNewNumber(digit));
	}

	/**
	 * Calculates new value if a digit when a digit is pressed.
	 *
	 * @param b	new pressed digit
	 * @return	a * 10 + b(two digit number)
	 */
	private int buildNewNumber(int b) {
		int a = display.getValue();
		return a * 10 + b;
	}

	public void pressBinaryOperationButton() {
		memory.setValue(display.getValue());
		nextNumber = true;
	}

	/**
	 * Method for pressing equal(=) on calculator.
	 * If operator was not pressed program terminates(ie. 5 =).
	 *
	 */
	public void pressEquals() {
		if(Objects.nonNull(binaryOperator)) {
			int result = binaryOperator.applyAsInt(memory.getValue(), display.getValue());
			memory.setValue(0);
			display.setValue(result);
		}
		binaryOperator = null;
		operator.setValue("");
		nextNumber = true;
	}

	/**
	 * Wipes all calculator's registers.
	 *
	 */
	public void pressClear() {
		memory.setValue(0);
		display.setValue(0);
		operator.setValue("");
		binaryOperator = null;
		nextNumber = true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((display == null) ? 0 : display.hashCode());
		result = prime * result + ((memory == null) ? 0 : memory.hashCode());
		result = prime * result + ((operator == null) ? 0 : operator.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null) {
			return false;
		}
		if (getClass() != obj.getClass()) {
			return false;
		}
		CalculatorBackend other = (CalculatorBackend) obj;
		if (display == null) {
			if (other.display != null) {
				return false;
			}
		} else if (!display.equals(other.display)) {
			return false;
		}
		if (memory == null) {
			if (other.memory != null) {
				return false;
			}
		} else if (!memory.equals(other.memory)) {
			return false;
		}
		if (operator == null) {
			if (other.operator != null) {
				return false;
			}
		} else if (!operator.equals(other.operator)) {
			return false;
		}
		return true;
	}

	/**
	 * Returns current content of calculator's registers.
	 *
	 */
	@Override
	public String toString() {
		String d0Display = display.getValue().toString();
		String m0Memory = memory.getValue().toString();
		String o0Operator = operator.getValue().toString();

		String dDisplay = "D=" + d0Display + ", ";
		String mMemory = "M=" + m0Memory + ", ";
		String oOperator = o0Operator.equals("") ? "" : "O=" + o0Operator;

		String result = dDisplay + mMemory + oOperator;

		if(result.endsWith(", ")) {
			result = result.substring(0, result.length() - 2);
		}

		return "(" + result + ")";
	}

	public static void main(String[] args) {

		CalculatorBackend c = new CalculatorBackend();

		DigitButton b0 = new DigitButton(0);
		DigitButton b1 = new DigitButton(1);
		DigitButton b2 = new DigitButton(2);
		DigitButton b3 = new DigitButton(3);
		DigitButton b4 = new DigitButton(4);
		DigitButton b5 = new DigitButton(5);
		DigitButton b6 = new DigitButton(6);
		DigitButton b7 = new DigitButton(7);
		DigitButton b8 = new DigitButton(8);
		DigitButton b9 = new DigitButton(9);

		BinaryOperationButton plus = new BinaryOperationButton("+", (x, y) -> x + y);
		BinaryOperationButton minus = new BinaryOperationButton("-", (x, y) -> x - y);

		ControlButton equals = new ControlButton("=", CalculatorBackend::pressEquals);
		ControlButton clear = new ControlButton("C", CalculatorBackend::pressClear);




//		printInfo(c);
//		c.pressDigit(1);
//		printInfo(c);
//		c.pressDigit(0);
//		printInfo(c);
//		c.pressMinus();
//		printInfo(c);
//		c.pressDigit(2);
//		printInfo(c);
//		c.pressDigit(9);
//		printInfo(c);
//		c.pressPlus();
//		printInfo(c);
//		c.pressDigit(3);
//		printInfo(c);
//		c.pressEquals();
//		printInfo(c);
//		c.pressClear();
//		printInfo(c);

		printInfo(c);
		c.press(b1);
		printInfo(c);
		c.press(plus);
		printInfo(c);
		c.press(b2);
		printInfo(c);
		c.press(b3);
		printInfo(c);
		c.press(equals);
		printInfo(c);
	}

	private static void printInfo(CalculatorBackend c) {
		System.out.println("*****************");
		System.out.println(c.getDisplay().getValue());
		System.out.println(c.toString());
		System.out.println("*****************");
	}

}
