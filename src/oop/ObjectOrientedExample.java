package oop;

import oop.animals.Animal;
import oop.animals.Cat;
import oop.foods.Bone;
import oop.foods.Food;
import oop.foods.Milk;

import java.util.Random;

public class ObjectOrientedExample {
    public static Random random = new Random();

    public static void main(String[] args) {
//        firstDemo();
//        secondDemo();
        lastDemo();
    }

    /**
     * Пример стареющего,
     * передвигающегося в пространстве
     * и кушающего животного
     */
    static void firstDemo(){
        Animal firstAnimal = new Animal("Goat", true, 10, 1);
        System.out.println(firstAnimal.toString());

        firstAnimal.addYear();
        firstAnimal.addYear(2);
        firstAnimal.move();
        firstAnimal.move();
        firstAnimal.eat(new Food(5));
        System.out.println(firstAnimal.toString());
    }

    /**
     * Пример размножения животных
     */
    static void secondDemo(){
        Animal firstAnimal = new Animal("Goat", true, 5, 10);
        Animal someAnimal = new Animal("Giraffe", true, 5, 10);
        Animal anotherAnimal = new Animal("Dog", false, 5, 10);
        Animal lastAnimal = new Animal("Dolphin", false, 30, 10);

        System.out.println(someAnimal.toString());
        System.out.println(anotherAnimal.toString());

        Animal child;
//        child = someAnimal.creation(someAnimal); // error - single animal
//        child = someAnimal.creation(firstAnimal); // error - equal gender
        child = someAnimal.creation(anotherAnimal);
//        child = someAnimal.creation(lastAnimal); // error - partner was died :(

        System.out.println(child.toString());
    }

    /**
     * Пример с котиками
     * Попытки покормить котика чем-попало и молоком
     * Попытки скрестить котика с чем-то рогатым,
     */
    static void lastDemo (){
        Animal firstAnimal = new Animal("Goat", true, 10, 10);
        Animal kitty = new Cat(true, 3, 8);
        Animal femaleCat = new Cat(true, 3, 8);

        Cat cat = new Cat(false, 5, 1);
        System.out.println(cat.toString());

//        cat.eat(new Food (2));  // error - incorrect food
//        kitty.eat(new Bone());   // error - incorrect food
        kitty.eat(new Bone()); // Но козу можно покормить костями, т.к. она не привередлива

        Food milk = new Milk();
        cat.eat(milk);
        System.out.println(milk.toString());
        System.out.println(cat.toString());

        cat.voice();

        Animal kitten;

//        kitten = cat.creation(firstAnimal); // error - different animals
//        kitten = cat.creation(cat);         // error - single animal
//        kitten = femaleCat.creation(kitty);  // error - equal gender
        kitten = cat.creation(kitty);
        System.out.println(kitten.toString());
    }
}
