package collections;

import java.util.*;

/**
 * Пример работы со списками данных
 *
 * Экземпляр класса List создать нельзя,
 * но можно создать список,
 * соответствующий его дочерним классам
 */
public class ListExamples {
    public static void main(String[] args) {

        List<Person> list =
//                createArrayList();
                createLinkedList();

        // region // add

        /*
            Метод add() добавляет новый элемент в конец списка
         */
        list.add(new Person("Charles", "Babbage"));
        list.add(new Person("Alan", "Turing"));
        list.add(new Person("Ada", "Lovelace"));
        System.out.println(list.toString());

        /*
            Или на определенную позицию, указанную перед данными,
            если такая позиция не выходит за границу списка

            Элемент будет добавлен подвинут остальные элементы,
            если это требуется
         */
        list.add(0, new Person("Konrad", "Zuse")); // в начало
        list.add(2, new Person("John", "Neumann")); // на 2 позицию
        list.add(list.size(), new Person("Augustin", "Cauchy")); // добавить к концу
//        list.add(list.size() + 5, new Person("Augustin", "Cauchy")); // error
        System.out.println(list.toString());
        System.out.println();


        /*
            Можно добавить в один список элементы другого списка
            методом addAll(),
            а методом subList()
            наоборот получить часть элементов другого списка
         */
        list.addAll(list.subList(0, 2)); // продублировали Цузе и Бебиджа в конец списка
        System.out.println(list.toString());

        /*
            В отличие от массивов,
            длину списков возрващает метод size()

            А метод isEmpty() уточняет, есть ли элементы в списке
         */
        System.out.println("List length = " + list.size());
        System.out.println("List is empty = " + list.isEmpty());
        System.out.println();

        // endregion

        // region // index

        /*
            Метод indexOf() вернет номер позиции с начала списка,
            а метод lastIndexOf() номер позиции
            при поиске от конца списка к началу,
            в которой располагается объект.

            В обоих случаях, если объект найден не будет,
            метод вернет -1
         */
        System.out.println(list.indexOf(new Person("Konrad", "Zuse")));
        System.out.println(list.lastIndexOf(new Person("Konrad", "Zuse")));
        System.out.println();


        /*
            А метод contains() просто сообщит,
            что объект в списке есть - true
            или отсутствует - false
         */
        System.out.println(list.contains(new Person("Konrad", "Zuse")));

        /*
            Метод containsAll() аналогично проверит,
            что несколько элементов, содержатся в списке
         */
        List<Person> subList = new ArrayList<>();
        subList.add(new Person("John", "Neumann"));
        subList.add(new Person("Konrad", "Zuse"));
        System.out.println(list.containsAll(subList));
        System.out.println();

        // endregion

        // region // get & set & remove

        /*
            Метод get() вернет объект из указанной позиции
            А метод set() изменит объект в заданной позиции
         */
        System.out.println(list.get(5));
        System.out.println(list.set(5, new Person("Bjarne", "Stroustrup"))); // возвращает "затираемый" объект
        System.out.println(list.get(5));

        /*
            Метод remove() удалит объект из заданной позиции
            или указанный объект, если найдет подобный
            (последующие элементы подвинутся вперед)
         */

        System.out.println(list.remove(0)); // возвращает "удаляемый" объект
        System.out.println(list.remove(new Person("Charles", "Babbage"))); // удалось ли ему удалить кого либо?
        System.out.println(list);
        System.out.println();

        // endregion

        // region // sort

        /*
            Сортировка списков работает по тем же принципам,
            что и для массивов
         */
        list.sort(Person :: compareFromLastName);
        System.out.println(list);
        System.out.println();

        /*
            Фактически предыдущая запись аналогична вызову
            метода sort() класса Collections, который умеет
            "обращаться" с большинство коллекций
         */
        Collections.sort(list, new Person());

        // endregion

        /*
            Список также можно перевести в массив
         */
        Person[] personsArray = (Person[]) list.toArray();

        /*
            Можно удалить все элементы -
            получить пустой список
         */
        list.clear();
    }

    /**
     * Динамический массив данных
     *
     * Фактически это массив,
     * некоторой длины в который помещаются элементы.
     * Как только в массиве заканчивается место,
     * то выделяется новый массив большей длины,
     * в который копируются первоначальные значения
     *
     * За удобство работы с данными приходится платить
     * издержками по памяти и времени
     * при изменении количества данных в списке
     *
     * @return - пустой динамический массив данных
     */
    private static ArrayList<Person> createArrayList(){
        return new ArrayList<Person>();
    }

    /**
     * Двусвязный список данных
     *
     * Фактически это группа элементов,
     * каждый из которых знает
     * какой элемент расположен перед ним,
     * а какой после него
     *
     * За удобство работы с данными приходится платить
     * издержками времени при переборе элементов
     * при поиске, добавлении или удалении элементов в середине списка
     *
     * @return - пустой двусвязный список
     */
    private static LinkedList<Person> createLinkedList(){
        LinkedList<Person> linkedList = new LinkedList<Person>();

        /*
            У LinkedList есть специфические методы
            для взаимодействия с первым и последним
            элементами списка
         */
        linkedList.addFirst(new Person("Charles", "Babbage"));
        linkedList.addLast(new Person("Alan", "Turing"));
        System.out.println(linkedList);
        System.out.println();


        System.out.println(linkedList.getFirst());
        System.out.println(linkedList.getLast());

        /*
            Базовые методы интерфейса List
            дублируются следующими командами:
            add -> offer
            remove -> poll
            get -> peek
         */
        System.out.println(linkedList.peekLast());
        System.out.println();

        /*

            Кроме это есть специфические методы
            для взаимодействия со связанным списком данных
            push - "протолкнуть" элемент в начало связанного списка
         */
        linkedList.push(new Person("John", "Neumann"));
        System.out.println(linkedList);
        System.out.println();

        /*
            pop() - "вытолкнуть" первый объект из связанного списка
         */

        System.out.println(linkedList.pop());
        System.out.println(linkedList);
        System.out.println();

        linkedList.clear();
        return linkedList;
    }
}
