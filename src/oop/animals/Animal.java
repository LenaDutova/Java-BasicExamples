package oop.animals;

import oop.ObjectOrientedExample;
import oop.foods.Food;

import java.util.Objects;

/**
 * Родительский класс Животных
 */
public class Animal
    implements ICreatable<Animal>{

    private static final int MAX_AGE = 15;
    private static final int MAX_SATIETY = 5;

    // свойства доступные дочерним классам
    protected String name;      // наименование животного
    protected boolean gender;   // пол
    protected int age;          // возраст
    protected int satiety;      // сытость

    // служебные свойства не доступные даже дочерним классам
    private int maxAge;         // отмеренный животному срок жизни
    private int maxSatiety;     // вместимость "брюха"

    // region   // Constructors  overloading

    /*
       Конструктор по умолчанию - это конструктор,
       в который не передаются параметры
       и который отвечает только за выделение памяти
       под свойства объекта.
       Даже если вы не написали ни один конструктор,
       то "Конструктор по умолчанию" существует не явно.
       НО ровно до того момента,
       пока не появился хотя бы один
       явно описанный конструктор
    */
    public Animal() {
        // Наименование по умолчанию
        this.name = "Unknown";

        // Генерация максимального возраста и предельной сытости животного
        this.maxAge = ObjectOrientedExample.random.nextInt(MAX_AGE) + MAX_AGE;            // 15 - 30
        this.maxSatiety = ObjectOrientedExample.random.nextInt(MAX_SATIETY) + MAX_SATIETY;// 5 - 10

        // По умолчанию, животное уже покушало
        this.satiety = maxSatiety;
    }

    /*
        Alt+Insert - Constructor
        Сгенерирует конструктор
        и проинициализирует свойства объекта,
        заданными вами параметрами

        Сгенерированный конструктор не проверяет значения
        Эта задача разработчика кода
     */
    public Animal(String name) {
        this();
        this.setName(name);
    }

    public Animal(String name, boolean gender) {
        this(name);
        this.gender = gender;
    }

    public Animal(String name, boolean gender, int age, int hungry) {
        this(name, gender);
        this.setAge(age);
        this.setSatiety(hungry);
    }

    // endregion

    // region   // Setters

    /*
        Alt + Insert - setter
        Методы класса, задающие значения свойств объекта.
        Принято название таких методов записывать в формате
        set[Свойство]
        даже для значений типа boolean

        Следует проверять значения,
        которые задаются свойствам
     */

    public void setName(String name) {
        if (name == null || name.isEmpty())
            throw new Error("Наименование животного не может быть пустым");
        else this.name = name;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }

    public void setAge(int age) {
        if (age < 0)
            throw new Error("Возраст не может быть отрицательным");
        else {
            /*
                Если возраст не превышает максимальную продолжительность жизни,
                использовать этот возраст,
                иначе год гибели животного
             */
            this.age = (age < maxAge) ? age : maxAge;
        }

    }

    public void setSatiety(int satiety) {
        if (satiety < 0)
            throw new Error("Сытость не может быть отрицательной");
        else {
            this.satiety = (satiety < maxSatiety) ? satiety : maxSatiety;
        }
    }

    // endregion

    // region   // Getters

    /*
        Alt + Insert - getter
        Методы класса, возвращающие значения свойств объекта.
        Принято название таких методов записывать в формате
        get[Свойство]
        или is[Свойство] для значений типа boolean
     */

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSatiety() {
        return satiety;
    }

    public boolean isGender() {
        return gender;
    }

    // endregion

    // region   // Custom Getters

    public boolean isDied(){
        return age >= maxAge;
    }

    public boolean isHungry (){
        return satiety == 0;
    }

    public boolean isWellFed (){
        return satiety == maxSatiety;
    }

    public String getGender (){
        return gender ? "Самочка" : "Самец";
    }

    // endregion

    // region   // Methods overloading

    /**
     * Старим животное на один год, если оно пока живо
     */
    public void addYear(){
        if (!isDied()) this.age++;
    }

    /**
     * Старим животное на несколько лет, если или пока оно еще живо
     * @param age - на сколько лет необходимо состарить животное
     */
    public void addYear(int age){
        if (age < 0)
            throw new Error("С возрастом не молодеют");
        this.age += age;
        if (this.age > maxAge)
            this.age = maxAge;   // К сожалению животное почило чуть раньше задаваемого срока
    }

    // endregion

    // region   // Custom Methods

    /**
     * Создание нового животного (детеныша)
     * при наличии двух особей разного пола.
     * Одну особь представляет экземпляр класса,
     * на котором вызывается метод
     *
     * @param animal - вторая особь передается в качестве аргумента метода
     * @return - новое животное, полученное в результате скрешивания
     */
    @Override
    public Animal creation (Animal animal){
        if (this == animal)
            throw new Error("Необходима пара");
        if (this.gender == animal.gender)
            throw new Error("Каждой твари по паре");
        if (this.isDied() || animal.isDied())
            throw new Error("Без некромантии");
        return new Animal(
                ObjectOrientedExample.random.nextBoolean() ? this.getName() : animal.getName(),
                ObjectOrientedExample.random.nextBoolean()
        );
    }

    /**
     * Метод передвижения животного
     * Если животное голодно, то оно не движется
     * @return - true - если движение произошло
     */
    public boolean move (){
        if (isHungry()) {
            System.out.println("Zzz... Zzz... Zzz...");
            return false;
        } else{
            this.satiety--;
            System.out.println("I like to move it, move it!");
            return true;
        }
    }

    /**
     * Поглощая пищу животное увеличивает уровень своей сытости
     * @param food - еда, переданная животному
     * @return - true - если животное кушало
     */
    public boolean eat(Food food){
        if (isWellFed() || food.isUsed()) return false;
        else {
            int hungry = maxSatiety - satiety;
            this.satiety += food.eatFood(hungry);
            return true;
        }
    }

    // endregion

    // region   // Override methods

    /*
        Alt+Insert - toString()
        Все объекты Java неявно наследуются от класса Object,
        метод toString() которого выводит информацию о его свойствах (полях)
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + " [" +
                "name='" + name + '\'' +
                ", gender='" + getGender() + '\'' +
                ", age=" + age +
                ", hungry=" + satiety +
                (isDied() ? ", RIP" : "") +
                ']';
    }

    /*
        Alt+Insert - equals()
        Метод equals() класса Object по умолчанию сравнивает
        не эквивалентность свойств объекта,
        а только идентичность ссылок.

        Для того, чтобы сравнивать отдельные значения, а не ссылки,
        метод стоит переопределять в своей программе.

        Мы будем игнорировать текущий голод животного - hungry
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Animal animal = (Animal) o;
        return gender == animal.gender && age == animal.age && maxAge == animal.maxAge && maxSatiety == animal.maxSatiety && name.equals(animal.name);
    }

    /*
        Alt+Insert - equals()
        Метод hashCode() класса Object создает численный идентификатор
        на основе значений свойств (полей) объекта.

        Для двух сравниваемых объектов:
        Если хеш-коды разные, то и объекты гарантированно разные.
        Если хеш-коды равны, то объекты НЕ ВСЕГДА равны (возможно равны)

        Мы будем игнорировать текущий голод животного - hungry
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, gender, age, maxAge, maxSatiety);
    }

    // endregion

}
