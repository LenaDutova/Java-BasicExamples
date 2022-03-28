package errors;

/**
 * Родительский класс для ошибки ввода данных,
 * требующий изменить метод toString(),
 * описывающий конкретную ошибку
 */
public abstract class ArgumentException
        extends Exception {

    public ArgumentException(String message) {
        super(message);
    }

    @Override
    public abstract String toString();
}
