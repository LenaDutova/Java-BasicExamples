package oop.animals;

import oop.ObjectOrientedExample;
import oop.foods.Food;
import oop.foods.Milk;
import oop.foods.Mouse;

/**
 * Дочерний класс для класса Животных {@link Animal}
 * Котики могут кушать только молоко {@link Milk} и мышек {@link oop.foods.Mouse}
 * и давать потомство только от других котиков
 */
public class Cat
        extends Animal{

    public Cat() {
        super("Cat");
    }

    public Cat(boolean gender) {
        super("Cat", gender);
    }

    public Cat(boolean gender, int age, int hungry) {
        super("Cat", gender, age, hungry);
    }

    // region // override parent methods

    /**
     * Метод уточняет,
     * что вторая особь тоже котик,
     * проверяет все ошибки супрекласса для скрещивания животных,
     * а затем возвращает новую особь
     * @param animal - вторая особь передается в качестве аргумента метода
     * @return - объект Котика, а не просто Animal
     */
    @Override
    public Animal creation(Animal animal) {
        if (animal instanceof Cat) {
            super.creation(animal);
            return new Cat(
                    ObjectOrientedExample.random.nextBoolean()
            );
        }
        else throw new Error("Недопустим гибридизации Котиков");
    }

    /**
     * Уточняем тип пищи, а затем передает вызов родительскому методу
     * @param food - еда, переданная животному
     * @return - true - если котик покушал
     */
    @Override
    public boolean eat(Food food) {
        if (food instanceof Milk || food instanceof Mouse)
            return super.eat(food);
        else throw new Error("Котики этого не кушают");
    }

    // endregion
    // region // add custom behavior method

    /**
     * Котики мурчат
     */
    public void voice(){
        System.out.println("Мур-мур-мур");
    }

    // endregion
}
