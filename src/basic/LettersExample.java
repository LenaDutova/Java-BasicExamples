package basic;

public class LettersExample {
    /*
        psvm + tab или psvm + ctrl + space
        "Входная точка" или стартовый метод, с которого запускается java-программа
     */
    public static void main(String[] args) {

        /**
         * Символы - char - являются Примитивным типом,
         * указываются в одинарных кавычках.
         * Каждому символу ставиться в соответствие целочисленный код
         */
        // region // Создание символов и операции над ними
        char letter1 = 'A';     // непосредственно символ
        char letter2 = 65;      // код символа
        char letter3 = '\u0041';// 16-ричное представление кода

        // Код символа положительное целое число:
        int code = 'B';
        System.out.println(code + " code of '" + ((char) code) + "'");

        // Над кодами символов можно производить арифметические операции
        // и получить целочисленный результат
        int result1 = ((letter1 + 1 ) * 3 )/ 2;
        System.out.println(result1 + " code of '" + ((char) result1) + "'");

        // если в выражении присутствуют только символы
        // результат операций над их кодами,
        // легко преобразуется обратно в символ
        char result2 = 'z' - '0';
        System.out.println(result2);
        // endregion


        /**
         * Строки - String - являются Ссылочным типом
         * и указываются в двойных кавычках.
         * Помимо хранения строки,
         * доступны различные операции над строками.
         */
        // region // Создание и объединение строк
        String str1 = new String("Moscow institute of railway engineers");  // явное создание нового объекта
        String str2 = "Moscow institute of railway engineers";  // неявное создание нового объекта
        String str3 = "";   // Все еще строка, просто пустая

        // Конкатенация - объединение строк
        // Если у оператора плюс, хотя бы один аргумент строка,
        // то и результат строка.
        String msg1 = str1 + str3;
        String msg2 = str1 + '!';
        String msg3 = str3 + 1;
        // endregion


        /**
         * Строки являются неизменяемыми объектами в памяти.
         * Операции над строками порождает новые строки,
         * без изменения первоначальной строки.
         *
         * Если нужен результат,
         * то не забудьте его сохранить в переменную
         */
        // region // Операции над строками

        // Длина строки - количество символов
        System.out.println(str1.length());

        // Определение пустой и бессмысленной строки
        String word1 = "";
        String word2 = "  ";
        System.out.println(word1.isEmpty() + "/" + word1.isBlank());
        System.out.println(word2.isEmpty() + "/" + word2.isBlank());

        // Можно изменять регистры в строке
        String word3 = "Miit";
        System.out.println(word3.toUpperCase() + "/" + word3.toLowerCase());

        // Конкатенация как метод объединения текущей строки с другой
        String msg = str1.concat(".");

        // Индексация позиций символов в строке начинается с нуля:
        char first = word3.charAt(0);       // 'M'
        int index = word3.indexOf('M');    // 0

        // На основании индексов можно получить подстроку,
        // начиная с одного указанного индекса до другого
        String digits = "01234567890";
        String subDigits1 = digits.substring(5);    // "567890"
        String subDigits2 = digits.substring(5, 7);         // "56"

        // Можно корректировать строки
        String str4 = "   abba   ".strip(); // "abba" - удалить лишние пробелы в начале и конце
        String str5 = str4.replace('b', 'B');   // "aBBa" - заменить символ на другой
        String str6 = str2.replaceAll("institute", "university"); // или заменить подстроки на другие
        System.out.println(str6);
        // endregion
    }
}
