package collections;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * Пример работы с набором уникальных элементов
 *
 * Экземпляр класса Set создать нельзя,
 * но можно создать списки,
 * соответствующие его дочерним классам
 */
public class SetExample {
    public static void main(String[] args) {

        Set<Person> set =
//                createHashSet();
                createTreeSet();

        /*
            У наборов не так много базовых функций

            Метод add() добавляет новый элемент
            или addAll() добавит несколько элементов
         */
        set.add(new Person("Alan", "Turing"));
        set.add(new Person("Charles", "Babbage"));

        System.out.println(set.add(new Person("Ada", "Lovelace")));
        System.out.println(set.add(new Person("Ada", "Lovelace"))); // не добавит, так как такой элемент уже есть
        System.out.println(set.toString());
        System.out.println();

        /*
            Метод remove() удалит указанный объект, если найдет подобный
            (последующие элементы подвинутся вперед)
         */
        System.out.println(set.remove(new Person("Alan", "Turing")));
        System.out.println(set.toString());
        System.out.println();

        /*
            А метод contains() просто сообщит,
            что объект в списке есть - true
            или отсутствует - false
         */
        System.out.println(set.contains(new Person("Konrad", "Zuse")));

        /*
            Длину набора возрващает метод size()
            А метод isEmpty() уточняет, есть ли элементы в списке
         */
        System.out.println(set.isEmpty());
        System.out.println(set.size());
        System.out.println();
    }

    /**
     * Хеш-таблица представляет такую структуру данных,
     * в которой все объекты имеют
     * уникальный хеш-код или ключ
     *
     * Фактически этот класс хранит данные внутри
     * коллекции-словаря класса {@link java.util.HashMap},
     * в роли ключа которой выступает хранимый объект данных.
     *
     * @return - пустую хеш-таблицу
     */
    private static HashSet<Person> createHashSet(){
        return new HashSet<Person>();
    }

    /**
     * Структура данных в виде дерева,
     * в котором все объекты хранятся
     * в отсортированном виде по возрастанию.
     *
     * Для того чтобы сортировать объекты,
     * TreeSet требует, чтобы объекты указали
     * правило сортировки в соответствии с
     * интерфейсом java.lang.{@link Comparable}
     *
     * @return - пустое дерево
     */
    private static TreeSet<Person> createTreeSet(){
        // В том случае, если объект данных
        // уже реализует интерфейс java.lang.{@link Comparable}
        TreeSet<Person> treeSet = new TreeSet<Person>();

        // Или указать в конструкторе
        // объект java.lang.{@link Comparator}
        // или метод соответствующего класса,
        // который будет сравнивать два объекта
//        treeSet = new TreeSet<Person>(Person :: compareFromLastName);

        treeSet.add(new Person("Alan", "Turing"));
        treeSet.add(new Person("Charles", "Babbage"));
        treeSet.add(new Person("Ada", "Lovelace"));
        treeSet.add(new Person("Konrad", "Zuse"));
        System.out.println(treeSet.toString());
        System.out.println();

        /*
            Для отсортированного набора данных,
            мы можем получить:
            методом headSet() часть этого набора,
            элементы которого строго меньше заданного значения,
            или методом tailSet() часть этого набора,
            элементы которого больше или равны заданному значению
         */
        System.out.println(treeSet.headSet(new Person("Charles", "Babbage")));
        System.out.println(treeSet.tailSet(new Person("Charles", "Babbage")));
        System.out.println();

        /*
            А также просмотреть минимальный
            и максимальный элементы набора
         */
        System.out.println(treeSet.first());
        System.out.println(treeSet.last());
        System.out.println();

        treeSet.clear();
        return treeSet;
    }
}
