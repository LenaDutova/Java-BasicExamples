package errors;

/**
 * Дочерний класс относительно {@link ArgumentException}
 * Ошибка - ввод недопустимого аргумента
 */
public class InvalidArgumentException
        extends ArgumentException {

    public InvalidArgumentException(String field) {
        super(field);
    }

    @Override
    public String toString() {
        return "Invalid value for field '" + this.getMessage() + "'";
    }
}
