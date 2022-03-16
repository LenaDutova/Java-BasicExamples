package oop.animals;

/**
 * Контракт, в соответствии с которым
 * класс обязуется реализовать метод creation()
 *
 * @param <T> - объект партнер, некоторого типа
 */
public interface ICreatable <T> {

    /**
     * Вернуть новый объект, соответствующий типу "партнера"
     *
     * @param another - объект "партнер"
     * @return - новый объект "потомок"
     */
    T creation (T another);

}
