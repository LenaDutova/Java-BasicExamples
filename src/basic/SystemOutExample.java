package basic;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class SystemOutExample {

    /*
        psvm + tab или psvm + ctrl + space
        "Входная точка" или стартовый метод, с которого запускается java-программа
     */
    public static void main(String[] args) {

        /**
         * Вывод данных с помощью системного объекта System.out
         * методами печати и печати с переводом каретки
         */
        // region // Методы печати объекта System.out

        int i = 123456789;
        double d = 1234.56789;

        // перевод строки
        char newlineSymbol = '\n';                      // как символ
        String newLineString = System.lineSeparator();  // или как строка

        // Вывод строки без перевода каретки.
        // Для перехода на новую строку, нужно использовать специальный символ.
        System.out.print("i = " + i);
        System.out.print(", d = " + d + newlineSymbol + newlineSymbol);

        // sout + tab или sout + ctrl + space -> Вывод строки с переводом на новую строку
        System.out.println("i = " + i);
        System.out.println("d = " + d + newlineSymbol);

        // endregion

        /**
         *  Форматированный вывод данных
         *  souf + tab или souf + ctrl + space
         *  print format - использование шаблона вывода,
         *  без перевода курсора на новую строку, где:
         *      %x - для вывода шестнадцатеричных чисел
         *      %f - для вывода чисел с плавающей точкой
         *      %e - для вывода чисел в экспоненциальной форме, например, 1.3e+01
         *      %c - для вывода одиночного символа
         *      %s - для вывода строковых значений
         *  для %f обязательно указание размерности вывода
         */
        // region // Метод печати по шаблоны System.out
        // souf + tab -> Вывод шаблонной строки без перевода каретки.
        System.out.printf("i = %d\n", i);

        // '%n' - специальный символ, обозначающий перевод строки.
        // Аналогично '\n', но может отличаться от локали вывода, как и "запятая"
        System.out.printf("d = %f%n", d);

        // При указании количества символов после "запятой" округляет по математическим законам,
        // т.е. если меньше 0.5, то отбрасываем, иначе округляем в большую сторону
        System.out.printf("d = %.1f%n", d);

        // Смена локали вывода.
        // Русский язык к сожалению не прописан в Java по умолчанию - она путается в том, что нужно делать.
        System.out.printf(Locale.US,"d = %.2f%n", d);

        // System.out.printf() на самом деле вызывает метод System.out.format(), передавая ему все свои значения.
        // Это т.н. "синтаксический сахар", который привязан к комбинации "горячих клавиш" souf + tab
        System.out.format(Locale.US,"d = %028.2f%n", d);

        // В шаблонных методах вывода можно также склеивать строку из кусочков,
        // но операции форматирования будут произведены только над теми объектами,
        // которые переданы в метод как переменные метода
        System.out.format(Locale.US,"d = " + d + ", but d = %+.2f%n%n", d);

        // endregion


        /**
         * Если стандартные форматы вывода символов и данных не подходят,
         * можно кастомизировать вывод вручную
         */
        // region // Ручная настройка вывода данных

        // Шаблон вывода для исчислимых значений, где '.' отделяет дробную часть, а ',' группы знаков.
        // Символ решетки обозначает возможное наличие цифры.
        // Примечательно, что эти символы так же зависят от локализации устройства,
        // которую следует сменить до инициализации переменной типа DecimalFormat
        String pattern = "#.####";
        DecimalFormat decimalFormat = new DecimalFormat(pattern);
        System.out.println(decimalFormat.format(d));
        System.out.println(decimalFormat.format(5.00009));
        System.out.println(decimalFormat.format(5.00001) + newlineSymbol);


        // Ручная настройка шаблона
        DecimalFormatSymbols symbols = new DecimalFormatSymbols();
        symbols.setDecimalSeparator('.');
        symbols.setGroupingSeparator(' ');

        decimalFormat.setDecimalFormatSymbols(symbols);
        decimalFormat.setGroupingSize(3);
        decimalFormat.setGroupingUsed(true);

        decimalFormat.setMaximumFractionDigits(4);
        decimalFormat.setRoundingMode(RoundingMode.DOWN);

        System.out.println(decimalFormat.format(i));
        System.out.println(decimalFormat.format(d));
        System.out.println(decimalFormat.format(d-0.5678));
        // endregion
    }
}
