package oop.foods;

/**
 * Дочерний класс для класса Пищи {@link Food}
 */
public class Bone
        extends Food{

    private static final int SATIETY = 4;

    public Bone() {
        super(SATIETY);
    }

    @Override
    public String toString() {
        return "Bone " + super.toString();
    }
}
