package examples;

import java.util.Random;
import java.util.Scanner;

public class ArraysExample {

    static int n = 5;
    static Scanner scanner = new Scanner(System.in);
    static Random random = new Random();

    public static void main(String[] args) {
//        arrayCreation();      // создание одномерных массивов
//        readDimensionsArray();// пример 1
//        readPositiveArray();  // пример 2
//        matrixCreation();     // создание двумерного массива
//        sumCalculation();     // пример 3

        // можно создавать и использовать многомерные массивы
        int[][][][] mass = new int[1][2][3][4];
    }

    /**
     * Метод демонстрирует синтаксис
     * создания одномерного массива
     * и взаимодействие с его элементами
     */
    static void arrayCreation (){
        /*
            Выделение памяти под массив заданной длины.
            Если не инициализируем значения, то
            по умолчанию для разных типов данных выводятся значения:
            0 - для целочисленных
            0.0 - вещественных
            false - булевых переменных
            null - для ссылочных типов, в том числе String
         */
        int[] emptyArray;
        emptyArray = new int[n];
        printArray(emptyArray);

        /*
            К элементу массива можно обратится по его индексу.
            Индексация массивов начинается с нуля.
            В массиве с размерностью N не существует
            элемента с индексом N.
         */
        emptyArray[1] = 1;
        emptyArray[3] = 3;
//        emptyArray[5] = 1;  // ArrayIndexOutOfBoundsException
//        emptyArray[-1] = 1; // ArrayIndexOutOfBoundsException
        printArray(emptyArray);

        /*
            Выделение памяти под массив с заданными значениями.
            Значения указываются через запятую
         */
        int[] sampleArray = new int[]{1, 2, 3, 4, 5, 6};
        printArray(sampleArray);

        /*
            .length - свойство массива,
            возвращающее его длину
         */
        System.out.println(sampleArray.length);

        /*
            Выделение памяти под массив с заданными значениями.
            Если мы сразу инициализируем значения
            при определении переменной массива,
            то указывать оператор "new" не требуется.
         */
        int[] anotherArray = {1, 2, 3, 4, 5, 7, 8, 9};
        printArray(anotherArray);
        System.out.println(anotherArray.length);

        /*
            Можно изменить значение элемента. НО не массив.
            В этом случае выделяется память для новых данных
            и ссылка на них указывается для переменной массива
         */
        int[] nextArray = new int[n];
//        nextArray = {1, 2, 3}; // ошибка компиляции
        nextArray = new int[]{1, 2, 3};
    }

    /**
     * Метод считывает строку с консоли
     * и создает одномерный массив с количеством букв в словах,
     * разделенных пробелом, из этой строки
     */
    static void readDimensionsArray(){
        String[] words = scanner.nextLine().split(" ");
        printArray(words);

        int[] counts = new int[words.length];
        for (int i = 0; i < words.length; i++){
            counts[i] = words[i].length();
        }
        printArray(counts);
    }

    /**
     * Метод считывает строку цифр, разделенных запятой, с консоли
     * и создает одномерный массив с их значениями по модулю
     */
    static void readPositiveArray(){
        String[] digits = scanner.nextLine().split(", ");
        printArray(digits);

        int[] array = new int[digits.length];
        for (int i = 0; i < digits.length; i++){
            array[i] = Integer.parseInt(digits[i]);
            if (array[i] < 0) array[i] *= -1;
        }
        printArray(array);
    }

    /**
     * Метод демонстрирует синтаксис
     * создания двумерного массива
     * и взаимодействие с его элементами
     */
    static void matrixCreation (){
        /*
            Выделение памяти под массив заданной длины
         */
        int[][] identityMatrix = new int[n][n];

        /*
            К элементу массива можно обратится по его индексу
         */
        for (int i = 0; i < n; i++){
            identityMatrix[i][i] = 1;
        }
        printArray(identityMatrix);

        /*
            Выделение памяти под массив с заданными значениями.
            Значения указываются через запятую,
            строки указываются в фигурных скобках
            и отделяются запятой
         */
        int[][] sampleMatrix = new int[][]{
                {1, 2, 3, 4},
                {0},
                {6, 7, 8, 9}
        };
        printArray(sampleMatrix);

        sampleMatrix[1][0] = 5;
//        sampleMatrix[1][1] = 5;  // ArrayIndexOutOfBoundsException
        printArray(sampleMatrix);

        // количество "строк"
        System.out.println(sampleMatrix.length);
        // количество "столбцов" в строке
        System.out.println(sampleMatrix[0].length);
        System.out.println(sampleMatrix[1].length);

        /*
            Выделение памяти для новой строки
            и подмена ссылки на нее у массива
         */
        sampleMatrix[1] = new int[]{5, 5, 5, 5};
        printArray(sampleMatrix);
    }

    /**
     * Метод демонстрирует сложение двух
     * произвольных двумерных массивов, размерностью NxN
     */
    static void sumCalculation (){
        int[][] firstMatrix = createMatrix();
        int[][] secondMatrix = createMatrix();
        printArray(firstMatrix);
        System.out.println("\t\t+\n");
        printArray(secondMatrix);

        System.out.println("\t\t=\n");
        printArray(sumMatrix(firstMatrix, secondMatrix));
    }

    // region // Перегрузка метода / Вывод в консоль элементов массива

    static void printArray(int[] array){
        // печать без перевода строки
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) System.out.print("; "); // разделитель
            System.out.print(array[i]);
        }
        System.out.println("]");
    }

    static void printArray(String[] array){
        // печать без перевода строки
        System.out.print("[");
        for (int i = 0; i < array.length; i++) {
            if (i != 0) System.out.print("; "); // разделитель
            System.out.print("\"");
            System.out.print(array[i]);
            System.out.print("\"");
        }
        // перевод строки
        System.out.println("]");
    }

    static void printArray(int[][] array){
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (j != 0) System.out.print("\t"); // разделитель - табуляция
                System.out.print(array[i][j]);
            }
            // перевод строки
            System.out.println();
        }
        // перевод строки
        System.out.println();
    }

    // endregion

    /**
     * Метод создает двумерный массив размерностью NxN
     * и заполняет его случайными значениями
     * в диапазоне от 0 до 4 (включительно)
     * @return - целочисленный двумерный массив
     */
    static int[][] createMatrix(){
        int[][] matrix = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = random.nextInt(n);
            }
        }

        return matrix;
    }

    /**
     * Метод возвращет результат суммы
     * двух целочисленных матриц, одинаковой размерности
     * @param a - целочисленный двумерный массив
     * @param b - целочисленный двумерный массив
     * @return - целочисленный двумерный массив
     */
    static int[][] sumMatrix(int[][] a, int[][] b){
        int[][] matrix = new int[a.length][a[0].length];
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                matrix[i][j] = a[i][j] + b[i][j];
            }
        }
        return matrix;
    }
}
