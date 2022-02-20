package examples;

public class CycleExample {
    public static void main(String[] args) {

        int counter = 0;

        /*
            Цикл с предусловием - while ([condition]) [do something]
         */
        System.out.println("While-do started with counter = " + counter);
        while (counter < 10){
            counter++;
            System.out.println("While-do iteration " + counter);
        }
        System.out.println("While-do finished with counter = " + counter + "\n");


        /*
            Цикл с постусловием - do [something] while ([condition])
            "Тело цикла" выполнится хотя бы раз
         */
        System.out.println("Do-while started with counter = " + counter);
        do {
            counter++;
            System.out.println("Do-while iteration " + counter);
        } while (counter < 10);
        System.out.println("Do-while finished with counter = " + counter + "\n");


        /*
            Цикл со счетчиком - for ([start], [stop], [step]) [do something]
            Выполняется фиксированное количество раз
            0 - задается начальное значение счетчика
            1 - проверяется выполнение условия, или конец цикла
            2 - выполняется тело цикла
            3 - изменение счетчика, возврат к п.1
         */
        System.out.println("For started");
        for (int i = 0; i < 10; i++){
            System.out.println("For iteration " + i);
        }
        System.out.println("For finished \n");


        /*
            Операторы прерывания:
            continue - прерывание итерации. Код за этим оператором не существует
            break - прерывание цикла. Принудительный выход из текущего цикла
         */
        int iterator = 11;
        while (iterator > 0){
            iterator--;
            if (iterator == 2) {
                System.out.println("While-do BREAK");
                break;
            }
            if (iterator == 5) {
                System.out.println("While-do CONTINUE");
                continue;
            }
            System.out.println("While-do work iteration " + iterator);
        }
        System.out.println("While-do finished with counter = " + iterator + "\n");


        // оператор break прерывает выполнение того цикла в котором он находится
        char symbol = 'a';
        int repeater;
        while (symbol < 'f'){
            repeater = 0;

            // вложенный цикл
            while (repeater < 5){
                repeater++;
                if (symbol == 'c') break; // содержащий оператор прерывания
                System.out.print(symbol);
            }

            System.out.println(Character.toUpperCase(symbol));
            symbol++;
        }


        // Как можно модифицировать?
        int i = 0;  // счетчик проинициализирован заранее
        for (; i < 2; i++){
            System.out.println("For 1 iteration " + i);
        }

        // увеличениче счетчика for внесено в "тело цикла"
        for (; i < 4;){
            System.out.println("For 2 iteration " + i);
            i++; // увеличение цикла в конце цикла for по умолчанию
        }

        /*
            TODO: Бесконечный цикл!
            Внимание, чтобы убить запущенный процесс используйте
            комбинацию клавиц Ctrl+F2
            или значок красного квадрата в окне консоли
         */
//        for (;;){
//            System.out.println("Сон");
//            System.out.println("Учеба");
//        }

//        while (true){
//            System.out.println("Посмотрю еще одну серию и сразу спать");
//        }

//        do {
//            System.out.println("В следующем семестре я сразу возьмусь за учебу");
//        } while (true);

    }
}
