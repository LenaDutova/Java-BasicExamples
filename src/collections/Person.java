package collections;

import java.util.Comparator;
import java.util.Objects;

public class Person
        implements Comparator, Comparable {

    private static int count = 0;

    private int id;
    private String name;
    private String lastname;

    public Person() {}

    public Person(String name, String lastname) {
        this.id = ++count;
        this.name = name;
        this.lastname = lastname;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return name.equals(person.name) && lastname.equals(person.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, lastname);
    }

    @Override
    public String toString() {
        return name + " - " + lastname + "[" + id + "]";
    }

    /**
     * Переопределим метод класса {@link Comparator},
     * отвечающий за сортировку объектов -
     * будем сравнивать имена по алфавиту.
     *
     * И так как имена строкового типа,
     * воспользуемся базовым методом compareTo(),
     * который уже написан для двух объектов типа String
     *
     * @param one - первая персона
     * @param another - вторая персона
     * @return - число, в соответствии со следующей логикой
     * 0    : if (one == another)
     * -1   : if (one < another)
     * 1    : if (one > another),
     * обозначающее необходимость изменить порядок двух значений между собой
     */
    @Override
    public int compare(Object one, Object another) {
        return ((Person)one).name.compareTo(((Person) another).name);
    }

    /**
     * Переопределяем метод класса {@link Comparable},
     * отвечающий за сортировку объектов -
     * экземпляра на котором мы вызвали метод
     * и переданного как аргумент метода
     *
     * @param another - с кем сравниваем
     * @return число, обозначающее необходимость
     * изменить порядок двух значений между собой
     */
    @Override
    public int compareTo(Object another) {
        return this.name.compareTo(((Person) another).name);
    }

    // region // custom implementation of Comparator method

    /**
     * Сигнатура и логика метода идентична тому,
     * что мы переписали для класса {@link Comparator}
     *
     * В данном случае сортируем по фамилии
     *
     * @param one - первая персона
     * @param another - вторая персона
     * @return - число, обозначающее необходимость
     * изменить порядок двух значений между собой
     */
    public static int compareFromLastName(Object one, Object another) {
        return ((Person)one).lastname.compareTo(((Person) another).lastname);
    }

    public static int compareFromId(Object one, Object another) {
        return ((Integer)another) - ((Integer)one);
    }

    // endregion
}
