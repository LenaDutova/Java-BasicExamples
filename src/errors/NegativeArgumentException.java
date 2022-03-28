package errors;

/**
 * Дочерний класс относительно {@link NumberArgumentException}
 * Ошибка - ввод отрицательного значения
 */
public class NegativeArgumentException
        extends NumberArgumentException {

    public NegativeArgumentException(String field) {
        super(field);
    }

    @Override
    public String toString() {
        return super.toString() + "' can not be negative";
    }

}
