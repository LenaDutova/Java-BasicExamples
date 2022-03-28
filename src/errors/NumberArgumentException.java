package errors;

/**
 * Дочерний класс относительно {@link ArgumentException}
 * Ошибки ввода численных данных
 */
public class NumberArgumentException
        extends ArgumentException{

    public NumberArgumentException(String message) {
        super(message);
    }

    @Override
    public String toString() {
        return "Field '" + this.getMessage();
    }
}
