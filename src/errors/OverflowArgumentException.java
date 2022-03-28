package errors;

/**
 * Дочерний класс относительно {@link NumberArgumentException}
 * Ошибка - ввод значения, превышающего диапазон
 */
public class OverflowArgumentException
        extends NumberArgumentException {

    private int value;

    public OverflowArgumentException(String field, int value) {
        super(field);
        this.value = value;
    }

    @Override
    public String toString() {
        return super.toString() + "' can no be more than " + this.value;
    }
}
