package forks;

import java.util.Scanner;

// Условный оператор множественного выбора switch
public class SwitchExample {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Базовая нотация
        // Название дня недели по его номеру
        System.out.println("Введите день недели:");
        int day = scanner.nextInt();
        switch (day){
            case 1:
                System.out.println("Monday"); break;
            case 2:
                System.out.println("Tuesday"); break;
            case 3:
                System.out.println("Wednesday"); break;
            case 4:
                System.out.println("Thursday"); break;
            case 5:
                System.out.println("Friday"); break;

            case 6:
                System.out.println("Saturday");
                break;
            case 7:
                System.out.println("Sunday");
                break;

            default: System.out.println("Неделя состоит из 7 дней");
        }

        /*
            Если в кейсе нет завершающего оператора прерывания break,
            то переходим к инструкции следующего кейса
         */
        switch (day){
            case 1:
            case 2:
            case 3:
            case 4:
            case 5: {
                System.out.println("Working day");
                break;
            }

            case 6:
            case 7: {
                System.out.println("Day off");
                break;
            }

            default: System.out.println("Неделя состоит из 7 дней");
        }


        /*
            TODO: С версии jdk 14
            Условный оператор множественного выбора switch еще и выражение,
            т.е. он возвращает значение. В этом случае ветвь "default" обязательна

            Чтобы следующий код скомпилировался, вам нужно в
                File - Project Structure - Project
            указать следующие параметры:
                Project SDK - openjdk-17 или скачать такую через команду "Add jdk"
                Project language level - Default sdk
         */
        String label = switch (day) {
            case 6 -> "Суббота";
            case 1, 2, 3, 4, 5 -> "День рабочей недели";
            case 7 -> {
                // несколько инструкций можно также исполнять в кейсе
                System.out.println("Как же быстро пролетают выходные :(");
                /*
                    в этом случае возвращение значения
                    откладывается оператором yield
                    до выполнения предшествующего кода блока
                 */
                yield "Воскресенье";
            }
            default -> "Неделя состоит из 7 дней";
        };
        System.out.println(label);
    }
}
