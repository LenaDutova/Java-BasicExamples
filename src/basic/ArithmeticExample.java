package basic;

public class ArithmeticExample {
    public static void main(String[] args) {

        /**
         * Демонстрация различных математических операций
         */
        // region // Типы и арифметические операции

        /*
            Типы данных в Java расширяют диапазоны друг друга
            double -> float -> long -> int -> short -> byte
         */

        // Целочисленные
        int count = 0;
        int paramI1 = 5;
        int paramI2 = 2;
        int paramMax = Integer.MAX_VALUE; // 2 147 483 647;

        // Дробные
        double zero = 0.0;
        double paramD1 = 5.0;
        double paramD2 = 2.0;

        // "+" - Сложение
        int valueSumI = paramI1 + paramI2;
        double valueSumD = paramD1 + paramD2;

        /*
            Арифметические операции расширяются до большего типа аргументов
            Компилятор следит, чтобы результат арифметической операции
            не был утерян при записи в тип меньшего диапазона
         */
//        int valueSumID = paramI1 + paramD2; // не скомпилируется - тип суммы не соответствует типу переменной valueSumID
        double valueSumID = paramI1 + paramD2;

        System.out.println(paramI1 + " + " + paramI2 + " = " + valueSumI);
        System.out.println(paramD1 + " + " + paramD2 + " = " + valueSumD);
        System.out.println(paramI1 + " + " + paramD2 + " = " + valueSumID + "\n");

        int valueSumOverflowI = paramMax + paramI2;
        double valueSumOverflowD = paramMax + paramD2;

        System.out.println(paramMax + " + " + paramI2 + " = " + valueSumOverflowI);
        System.out.println(paramMax + " + " + paramD2 + " = " + valueSumOverflowD + "\n");


        // "-" - Вычитание
        double valueSumDI = paramD1 - paramI2;

        System.out.println(paramD1 + " - " + paramI2 + " = " + valueSumDI + "\n");


        // "*" - Умножение
        int valueMult = paramI1 * paramI2;

        System.out.println(paramI1 + " * " + paramI2 + " = " + valueMult + "\n");


        // "/" - Деление
        int valueDivI = paramI1 / paramI2;      // остаток отбросится
        double valueDivD = paramD1 / paramD2;
        double valueDivID = paramI1 / paramD2;

        System.out.println(paramI1 + " / " + paramI2 + " = " + valueDivI);
        System.out.println(paramD1 + " / " + paramD2 + " = " + valueDivD);
        System.out.println(paramI1 + " / " + paramD2 + " = " + valueDivID + "\n");

        // TODO But catch Exception as int zero
        double valueDivError1 = paramI1 / zero;   // x/0.0 = ArithmeticException
        System.out.println(paramI1 + " / " + zero + " = " + valueDivError1);

        double valueDivError2 = zero / zero;     // 0.0/0.0 = ?
        System.out.println(zero + " / " + zero + " = " + valueDivError2 + "\n");


        // "%" - Остаток от деления
        int valueDivRemainderI = paramI1 % paramI2;
        double valueDivRemainderD = paramD1 % paramD2;

        System.out.println(paramI1 + " % " + paramI2 + " = " + valueDivRemainderI);
        System.out.println(paramD1 + " % " + paramD2 + " = " + valueDivRemainderD + "\n");


        // Инкремент и декремент
        int stage = 0;

        System.out.println("stage = " + stage + ", count = " + count );
        stage = count++;    // постфиксная запись
        System.out.println("stage = " + stage + ", count = " + count + "\n");

        System.out.println("stage = " + stage + ", count = " + count );
        stage = ++ count;       // префиксная запись
        System.out.println("stage = " + stage + ", count = " + count + "\n" );

        System.out.println("stage = " + stage + ", count = " + count );
        stage = count --;
        System.out.println("stage = " + stage + ", count = " + count + "\n" );

        System.out.println("stage = " + stage + ", count = " + count );
        stage = --count;
        System.out.println("stage = " + stage + ", count = " + count + "\n" );

        // endregion


        /**
         * Вычисление значения дроби.
         *
         * Данный пример демонстрирует логику неявного расширения типов данных
         * при арифметических операциях,
         * а также явные преобразования типов
         */
        // region // Порядок операций
        // double -> float -> long -> int -> short -> byte

        // целочисленные параметры
        int param1 = 3;
        int param2 = 5;

        // вычисление производятся слева на право
        int value1 = param2*param1/param1;
        /*
            если два оператора целочисленные,
            то и результат арифметической операции
            останется целочисленным
         */
        int value2 = param2/param1*param1;
        System.out.println("(5x3)/3 = " + value1);
        System.out.println("(5/3)x3 = " + value2 + "\n");

        // правая часть (относительно равно) приоритетнее левой
        double value3 = param2/param1*param1;
        System.out.println("(5/3)x3 = " + value3);


        // дробный параметр
        double param3 = 5.0; // == param2

        double value4 = param3/param1*param1;
        System.out.println("(5.0/3)x3 = " + value4 + "\n");

        // явное приведение типов
        int value5 = (int) (param3/param1*param1);
        System.out.println("(5.0/3)x3 = " + value5 + "\n");

        int value6 = (int) (((double)param2)/param1*param1);
        int value7 = (int) (param2/((double)param1)*param1);
        int value8 = (int) (param2/param1*((double)param1));
        System.out.println("(5.0/3)x3 = " + value6);
        System.out.println("(5/3.0)x3 = " + value7);
        System.out.println("(5/3)x3.0 = " + value8);
        // endregion


        /**
         * Демонстрация методов класса {@link Math},
         * который содержит множество констант и математических операций,
         * заботливо созданных, протестированных и собранных программистами
         */
        // region // Math

        double param4 = 3.525;
        int param5 = -180;
        int param6 = 4;

//        char pi = 'π';  // as Symbol
//        char pi = '\u03C0'; // as Unicode
        char pi = 960;  // as Unicode number

        // Alt + Enter импорт класса/метода
        System.out.println(pi + " = " + Math.PI + "\n");

        // Округление в меньшую сторону, математическое и большую сторону соответственно
        System.out.println("Math.floor(" + param4 + ") = " + Math.floor(param4));
        System.out.println("Math.round(" + param4 + ") = " + Math.round(param4));
        System.out.println("Math.ceil(" + param4 + ") = " + Math.ceil(param4) + "\n");

        /*
            Math.floor(), Math.ceil() - хотя и округляют до целого, возвращают дробное число;
            Math.round() - не только округляет, но и возвращает целочисленное значение
         */

        // Модуль числа - возвращает значение такого же типа
        System.out.println("Math.abs(" + param5 + ") = " + Math.abs(param5) + "\n");

        // Корень и возведение числа в степень - возвращает double
        System.out.println("Math.sqrt(" + param6 + ") = " + Math.sqrt(param6));
        System.out.println("Math.pow(" + param6 + ", 2) = " + Math.pow(param6, 2));
        System.out.println("Math.pow(" + param6 + ", 3) = " + Math.pow(param6, 3) + "\n");

        // Тригонометрические функции - требует угол в радианах, возвращает double
        System.out.printf("Math.sin(%d) = %.2f\n", param2, Math.sin(Math.toRadians(param5)));
        System.out.printf("Math.cos(%d) = %.2f\n", param2, Math.cos(Math.toRadians(param5)));
        System.out.printf("Math.tan(%d) = %.2f\n", param2, Math.tan(Math.toRadians(param5)));    // tg

        // Из радиан в градусы тоже можно :)
        System.out.println("\nMath.toDegrees(PI) = " + Math.toDegrees(Math.PI));

        // endregion

    }
}
