package basic;

import java.util.Scanner;

/**
 * При запуске данного примера учтите,
 * что программа не зависла -
 * она ожидает от вас ввода в консоль.
 */
public class ScannerExample {

    /*
        psvm + tab или psvm + ctrl + space
        "Входная точка" или стартовый метод, с которого запускается java-программа
     */
    public static void main(String[] args) {

        /*
            Alt + Enter
            Добавление класса из другого пакета/директории в область видимости

            Объект Сканера необходимо создать с помощью оператора new
            и указать источник данных - System.in - системную консоль
         */
        Scanner scanner = new Scanner(System.in);

        //Сканер ожидает подтверждения ввода пользователем строки -
        // нажатия клавиши Enter
        String str1 = scanner.nextLine();   // Считать всю введенную строку
        String str2 = scanner.next();       // Считать слово из введенной строки до разделителя (по умолчанию пробела, табуляции, перевода строки)

        System.out.println( str1 + " (" + str2 + ")");



        // Сканер всегда считывает с консоли текст - String.
        // Если нужны данные других типов, то:
        // 1) Преобразовать строку к требуемому типу через класс-оболочку:

        int a1 = Integer.parseInt(scanner.next());
        boolean b1 = Boolean.parseBoolean(scanner.next());

        // 2) Использовать специализированный метод сканера

        int a2 = scanner.nextInt();
        boolean b2 = scanner.nextBoolean();
        System.out.println(a1 + "+" + a2 + "=" + (a1+a2));
        System.out.println("b1 = " + b1 + ", b2 = " + b2);

        // Для строк таких механизмов нет. Так как получить символ?
        // По номеру позиции в считанном слове:

        char ch = scanner.next().charAt(0);
        System.out.println(ch + " - first symbol in word");



        /*
        Когда мы используем методы next() и next[Тип](),
        в введенном предложении курсор перемещается
        от одного разделителя к следующему при чтении данных.

        Можно проверить, все ли слова в предложении было проанализированы
        или остались еще не учтенные команды пользователя, методами
        hasNext[Тип](), которые проверяют данные, но не переводят курсор
        за это слово
         */
        System.out.println("Is there another word? - " + scanner.hasNext());
        System.out.println("Is it number? - " + scanner.hasNextInt());
        System.out.println("Is it boolean? - " + scanner.hasNextBoolean());
        System.out.println("Last word is - " + scanner.next());
    }

    /*
        Чтобы проверить все примеры можно ввести две следующие строки:
        Russian University of Transport
        MIIT 1 true 2 false Symbol end
    */

}
