package collections;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * Класс java.util.Arrays доступен с версии jdk 1.2
 *
 * C его помощью можно создавать, сравнивать, сортировать
 * и трансформировать одномерные массивы
 *
 * Стоит учитывать, что большая часть методов класса Arrays
 * изменяет массив, который передавался им в качестве аргумента
 * (а не возвращет новый массив)
 */
public class ArraysExample {

    private static final int N = 5;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {

        // region // fill

        /*
            Метод fill() заполняет массив значениями,
            которые так же были переданы в метод
         */
        String[] helloArray = new String[N];
        Arrays.fill(helloArray, "Hello");
        System.out.println(Arrays.toString(helloArray));

        /*
            Можно заменить часть значений,
            начиная с индекса (включительно)
            и до индекса (не включая)
         */
        Arrays.fill(helloArray, 1, 3, "Hi");        // с 1-го, но до 3-го элемента
        System.out.println(Arrays.toString(helloArray));
        System.out.println();

        // endregion

        // region // copy

        /*
            Метод copyOf() копирует значения массива (или его часть)
            и возвращет НОВЫЙ массив заданной длины
         */
        int[] tempArray = {1, 2, 5, 6, 7, 4, 8, 3, 9, 0};
        int[] notSortedArray = Arrays.copyOf(tempArray, tempArray.length - 1); // кроме последнего элемента
        System.out.println(Arrays.toString(notSortedArray));

        /*
            Метод copyOfRange() копирует часть значений массива,
            начиная с индекса (включительно)
            и до индекса (не включая)
         */
        int[] shortArray = Arrays.copyOfRange(tempArray, N, tempArray.length);  // от N до последнего элемента
        System.out.println(Arrays.toString(shortArray));

        /*
            Этот метод также позволит считать строку с консоли как массив строк

            Обратите внимание что будет, если ввести фразу длиннее или короче N
            Например: "Hello my dear friend"
         */
        String[] consoleArray = Arrays.copyOf(scanner.nextLine().split(" "), N);
        System.out.println(Arrays.toString(consoleArray));
        System.out.println();

        // endregion

        // region // toString

        /*
            Вы уже возможно поняли как работает метод toString()
            для отдномерных массивов. Но можно ли его использовать
            для многомерных массивов?
         */
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        System.out.println(Arrays.toString(matrix));
        System.out.println(Arrays.deepToString(matrix));    // deepToString() - для многомерных

        // endregion

        // region // sort

        /*
            Все массивы базовых типов можно отсортировать по возрастанию
            методом sort()
         */
        Arrays.sort(shortArray);
        System.out.println(Arrays.toString(shortArray));

        /*
            Сортировать все элементы массива
            или только его часть в диапазоне -
            начиная с индекса (включительно)
            и до индекса (не включая)
         */
        Arrays.sort(notSortedArray, N, notSortedArray.length);  // от N до последнего элемента
        System.out.println(Arrays.toString(notSortedArray));
        System.out.println();

        /*
            Но что делать, если массив состоит из объектов,
            о которых базовые типы данных не знают?
            Например, мы создали новый тип данных Person,
            сохранили в массиве несколько персон
            и хотим их отсортировать по имени?

            Можно указать вторым параметром объект Comparator,
            указывающий правило сортировки
         */
        Person[] persons = {
                new Person("Charles", "Babbage"),
                new Person("Alan", "Turing"),
                new Person("Ada", "Lovelace")
        };
        Arrays.sort(persons, new Person()); // Персона как дочерний объект Компаратора
        System.out.println(Arrays.toString(persons));

        Arrays.sort(persons, new Person().reversed());  // В этом случае, можно и в обратную сторону
        System.out.println(Arrays.toString(persons));

        /*
            Указываем конкретный метод, сравнивающий два значения.
            Должен быть с идентификатором static
         */
        Arrays.sort(persons, Person :: compareFromLastName);
        System.out.println(Arrays.toString(persons));
        System.out.println();

        // endregion

        // region // search

        /*
            Метод binarySearch()
            проверит есть ли заданное значение в массиве
            и вернет индекс позиции, на которой это значение находится,
            или отрицательное число, если ничего не найдет
         */
        System.out.println(Arrays.toString(shortArray));
        System.out.println(Arrays.binarySearch(shortArray, 4));
        System.out.println(Arrays.binarySearch(shortArray, 8));
        System.out.println(Arrays.binarySearch(shortArray, 10));
        System.out.println();

        /*
            Но этот метод работает только для отсортированных массивов
            Так для частично отсортированного массива (от N до конца),
            возникнет ошибка
         */
        System.out.println(Arrays.toString(notSortedArray));
        System.out.println(Arrays.binarySearch(notSortedArray, 4));
        System.out.println(Arrays.binarySearch(notSortedArray, 8));
        System.out.println(Arrays.binarySearch(notSortedArray, 10));
        System.out.println();

        /*
            Сравните индексы для так же самых элементов,
            если массив отсортировать до конца
         */
        Arrays.sort(notSortedArray);
        System.out.println(Arrays.toString(notSortedArray));
        System.out.println(Arrays.binarySearch(notSortedArray, 4));
        System.out.println(Arrays.binarySearch(notSortedArray, 8));
        System.out.println(Arrays.binarySearch(notSortedArray, 10));
        System.out.println();

        // endregion

        /*
            Стоит обратить внимание на то,
            что массив можно преобразовать в список,
            методом asList()
         */
        List list = Arrays.asList(tempArray);
    }



}
