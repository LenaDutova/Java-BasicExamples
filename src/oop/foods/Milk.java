package oop.foods;

/**
 * Дочерний класс для класса Пищи {@link Food}
 */
public class Milk
        extends Food{

    private static final int SATIETY = 5;

    public Milk() {
        super(SATIETY);
    }

    @Override
    public String toString() {
        return "Milk " + super.toString();
    }
}
