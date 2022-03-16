package collections;

import java.util.*;

/**
 * Итератор позволяет вам перемещаться
 * по коллекции, получать или удалять элементы
 *
 * Он аналогичен "пальцу", проводимому по коллекции
 * от ее началу к концу и последовательно указывающему
 * на ее элементы
 */
public class IteratorExample {
    public static void main(String[] args) {
        /*
            Метод iterator() возвращает итератор
            для вызывающей коллекции.
            Этот метод определен для всех коллекций Java
         */
        Iterator<Person> iterator;

        // коллекция, реализованная как массив
        Person[] persons = {
                new Person("Charles", "Babbage"),
                new Person("Alan", "Turing"),
                new Person("Ada", "Lovelace")
        };
        iterator = Arrays.stream(persons).iterator(); // для Arrays

        // коллекция, реализованная как список
//        List<Person> list = new ArrayList();
//        list.add(new Person("Charles", "Babbage"));
//        list.add(new Person("Alan", "Turing"));
//        list.add(new Person("Ada", "Lovelace"));
//        iterator = list.iterator();

        // коллекция, как уникальный набор значений
//        Set<Person> set = new HashSet<>();
//        set.add(new Person("Charles", "Babbage"));
//        set.add(new Person("Alan", "Turing"));
//        set.add(new Person("Charles", "Babbage"));
//        iterator = set.iterator();

        // коллекция, реализованная как словарь
//        Map<String, Person> persons = new HashMap();
//        persons.put("key-0", new Person("John", "Neumann"));
//        persons.put("key-2", new Person("Augustin", "Cauchy"));
//        persons.put("key-1", new Person("Alan", "Turing"));
//        // для Map необходимо указать коллекцию перебора
//        iterator = persons.values().iterator(); // значения
//        Iterator <String> keyIterator = persons.keySet().iterator(); // или ключи

        /*
            Метод hasNext() сообщает о том,
            есть ли ещё элементы за элементом,
            на который мы сейчас "указываем"
         */
        while (iterator.hasNext()){
            /*
                Метод next() возвращает нам элемент
                коллекции, на который мы сейчас "указываем"
             */
            Person person = iterator.next();
            System.out.println(person.toString());
        }
    }
}
