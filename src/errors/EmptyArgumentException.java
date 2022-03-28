package errors;

/**
 * Дочерний класс относительно {@link ArgumentException}
 * Ошибка - ввод пустой строки
 */
public class EmptyArgumentException
        extends ArgumentException {

    public EmptyArgumentException(String field) {
        super(field);
    }

    @Override
    public String toString() {
        return "Field '" + this.getMessage() + "' can not be empty";
    }

}
