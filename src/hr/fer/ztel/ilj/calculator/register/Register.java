package hr.fer.ztel.ilj.calculator.register;

import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;

/**
 * Class which represents a register, used for saving values, in calculator.
 *
 * @author Boris Generalic
 *
 */
public class Register<T> {

	private ObjectProperty<T> value;

	public Register() {
		this(null);
	}

	public Register(final T value) {
		super();
		this.value = new SimpleObjectProperty<>(value);
	}

	/**
	 * Returns value which is stored in the register.
	 *
	 *
	 * @return	stored value in the register
	 */
	public T getValue() {
		return value.get();
	}

	public ObjectProperty<T> valueProperty() {
		return value;
	}

	/**
	 * Stores value in the register.
	 *
	 * @param value	value to store
	 */
	public void setValue(final T value) {
		this.value.set(value);
	}

	@Override
	public boolean equals(final Object o) {
		if (this == o) {
			return true;
		}
		if (o == null || getClass() != o.getClass()) {
			return false;
		}

		final Register<?> register = (Register<?>) o;

		return value != null ? value.equals(register.value) : register.value == null;

	}

	@Override
	public int hashCode() {
		return value != null ? value.hashCode() : 0;
	}
}
