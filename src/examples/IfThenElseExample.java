package examples;

import java.util.Scanner;

public class IfThenElseExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();
        int y = scanner.nextInt();

        // region // Синтаксис условных операторов
        /*
            Формы записи условий:
            if (true) - аргумент - булевый тип данных
            if (condition == true) - оператор отношений: >, =>, ==, !=, <=, <
            if (true || false) - логические операции: |, ||, &&, &, !
         */

        // "если" условие выполеняется
        if (x > y) System.out.println("First value a = " + x + " is bigger then next value b = " + y);

        // "если" условие выполеняется и "иначе"
        int difference = 0;
        if (x > y) difference = x - y;
        else difference = y - x;
        System.out.println("difference = | a - b | = " + difference);


        // независимые последовательные условия
        if (x < 0) System.out.println("Число меньше нуля");
        if (x == 0) System.out.println("Число равно нулю");
        if (x > 0) System.out.println("Число больше нуля");

        // вложенные условия
        if (x < 0) System.out.println("Число меньше нуля");
        else
            if (x == 0) System.out.println("Число равно нулю");
            else System.out.println("Число больше нуля");

        {
            //блоки
            // многострочного
            // кода
        }

        // endregion

        /**
         * Нахождение корней квадратного уравнения
         * через вычисление дискриминанта
         */
        // {2, 1, 2}, {1, -4, 4}, {1, -5, 6}
        System.out.println("Введите коэффициенты уравнения a, b и с:");
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        double discriminant = b*b-4*a*c;
        if (discriminant < 0) System.out.println("Действительных корней нет");
        else
            if (discriminant == 0){
                double x0 = -b/((double)2*a);
                System.out.println("Действительный корень x = " + x0);
            } else {
                double x1 = (-b + Math.sqrt(discriminant))/((double)2*a);
                double x2 = (-b - Math.sqrt(discriminant))/((double)2*a);
                System.out.println("Действительные корени x1 = " + x1 +", x2 = " + x2);
            }

        // region // Логические операции
        /*
            Логические операции
            Результат операции оценивается по значениям слева на право,
            или приоритет у скобок, как и в математике
         */

        if (false && true && true || true) System.out.println("if");
        else System.out.println("else");

        if ((false && true) && (true || true)) System.out.println("if");
        else System.out.println("else");

        if (false && (true && true) || true) System.out.println("if");
        else System.out.println("else");

        // endregion

        /**
         * Название дня недели по его номеру
         */
        System.out.println("Введите день недели:");
        int day = scanner.nextInt();
        if (day > 0 && day < 8){
            if (day == 1) System.out.println("Monday");
            if (day == 2) System.out.println("Tuesday");
            if (day == 3) System.out.println("Wednesday");
            if (day == 4) System.out.println("Thursday");
            if (day == 5) System.out.println("Friday");

            if (day == 6) System.out.println("Saturday");
            if (day == 7) System.out.println("Sunday");
        } else System.out.println("Неделя состоит из 7 дней");


        /**
         * Тернарный оператор или
         * Сокращенная запись условного оператора
         * [condition]?[then]:[else]
         *
         * Только одна операция в зависимости от выполнения условия.
         * Удобно использовать при добавлении скидки, обращениях и пр.
         * В вычислениях команда становится "слишком сложной" для прочтения
         * и такое применение не рекомендуется
         */
        boolean gender = scanner.nextBoolean();
        String contacting = gender ? "Mr." : "Ms.";
        System.out.println("Dear " + contacting + " Anonymous");
    }
}
