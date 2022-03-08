package oop.foods;

/**
 * Дочерний класс для класса Пищи {@link Food}
 */
public class Mouse
        extends Food{

    private static final int SATIETY = 3;

    public Mouse() {
        super(SATIETY);
    }

    @Override
    public String toString() {
        return "Mouse " + super.toString();
    }
}
