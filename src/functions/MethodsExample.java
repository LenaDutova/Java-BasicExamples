package functions;

public class MethodsExample {

    // Свойство класса
    static int count = 5;
    static boolean condition = true;

    /*
        Стартовый метод main
        Если из него
        удалить какое либо из ключевых слов "public", "static" или "void",
        изменить название со слова "main"
        или изменить тип или количество переменных метода,
        то метод перестанет отвечать за запуск программы
     */
    public static void main(String[] args) {
        System.out.println("Main start");

        /*
            Из метода с идентификатором "static" можно вызвать,
            метод с таким же идентификатором.
            static-методы видят друг-друга
         */
//        welcome();    // не скомпилируется пока welcome() не добавят ключевое слово "static"
        worker();


        congratulations(true);  // значение как аргумент
        congratulations(true);  // переменная как аргумент


        // Возвращают значения, которые необходимо вывести на печать, чтобы увидеть
        System.out.println(sum(10, 20));
        System.out.println(sum(20, 10));    // программа не следит за порядком аргументов одного типа

        System.out.println(differ(20, 10));
        System.out.println(differ(10, 20)); // за смысловую нагрузку такого порядка отвечает программист

        System.out.println(max (100, 80));  // а если надо сравнить три числа?
        System.out.println(max (max(90, 100), 80)); // вызов метода как аргумент - композиция


        System.out.println(samplePowerCalculation(2, 10));  // вычисление через итерации циклов
        System.out.println(powerCalculation(2, 10));        // вычисление через рекурсию

        /*
            В случае рекурсии, вычисления откладываются до достижения частного случая.
            После чего вычисления "сворачиваются" в обратном порядке - от частного через
            все отложенные операции очереди инструкций
         */
        System.out.println(factorialCalculation(count));                // вычисление через рекурсию
        System.out.println(factorialCalculation(Integer.MAX_VALUE));    // очередь инструкций не бесконечна!

        System.out.println("Main stop");
    }

    // region // Очередь инструкций

    // Метод класса
    void welcome() {
        System.out.println("\tWelcome, Dear Friend");
    }
    static void worker() {
        /*
            Если убрать у свойства count ключевое слово "static",
            то метод потеряет ее из своего "поля зрения".
            Но static не делает свойство константой -
            его значение можно изменить
         */
        count = 3;
        System.out.println("\tMethod start");
        for (int i = 0; i < count; i++) {
            System.out.println("\tMethod work " + i);
        }
        System.out.println("\tMethod stop");
    }

    // endregion
    // region // Передаваемые и возвращаемые значения

    static void congratulations (boolean condition){
        if (condition) System.out.println("Excellent!");
        else System.out.println("Try again later. " +
                "See you at the reexamination!");
    }

    static int sum (int x, int y){
        return x + y;
    }

    static double differ (int x, double y){
        return x - y;
    }

    // композиция функций - вызов функции в качестве аргумента
    static int max (int x, int y){
        System.out.println("Max: " + x + " ? " + y);

        if (x > y) return x;
        else return y;
    }

    // endregion
    // region // Сигнатура метода

    /*
     * Сигнатура методов чувствительна к регистру в названии методов
     */
    static void method(){}
    static void mEthod(){
    }

    /*
     * Сигнатура методов игнорирует названия переменных
     */
    static void method (int a){
    }
//    static void method (int x){} // не скомпилируется

    /*
     * Сигнатура методов чувствительна к типам переменных и порядку их указания
     */
    static void method (int a, int b, boolean condition){}
    static void method (boolean condition, int a, int b){}

    /*
     * Сигнатура методов игнорирует возвращаемый тип
     */
//    static int method(boolean condition, int a, int b){
//        return 0;
//    } // не скомпилируется

    // endregion
    // region // Перегрузка метода

    static void printValue (byte value){
        System.out.println("Byte value = " + value);
    }

    static void printValue (short value){
        System.out.println("Short value = " + value);
    }

    static void printValue (int value){
        System.out.println("Integer value = " + value);
    }

    static void printValue (long value){
        System.out.println("Long value = " + value);
    }

    static void printValue (String value){
        System.out.println("String value = " + value);
    }

    // endregion
    // region // Рекурсия / Возведение в степень

    static int samplePowerCalculation (int x, int power) {
        int result = 1;
        for (int i = 0; i < power; i++) {
            result *= x;
        }
        return result;
    }

    static int powerCalculation (int x, int power) {
        System.out.println("Method start with power = " + power);
        if (power == 0) return 1;
        if (power == 1) return x;
        else return x * powerCalculation (x, power - 1);
    }

    // endregion
    // region // Переполнение памяти при использовании рекурсии / Факториал

    static int factorialCalculation (int x){
        System.out.println("Method start with x = " + x);
        if (x < 0)
            throw new Error("Факториал — функция, определённая на множестве неотрицательных целых чисел");

        if (x == 0) return 1;
        else return x * factorialCalculation(--x);
    }

    // endregion
}