package errors;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ErrorsExample {
    private static Scanner scanner = new Scanner(System.in);
    private static List<Hamster> hamsters = new ArrayList<>();

    public static void main(String[] args) {
        // Количество записей
        int count = Integer.parseInt(scanner.nextLine());

        // Считываем заданное количество строк
        for (int i = 0; i < count; i++) {
            scanNewHamster(scanner.nextLine());
        }

        for (Hamster hamster: hamsters) {
            System.out.println(hamster.toString());
        }
    }

    private static void scanNewHamster(String str) {
        String[] args = str.split(" ");
        try {
            Hamster hamster = new Hamster(
                    Integer.parseInt(args[0]),
                    args[1],
                    Integer.parseInt(args[2]), Integer.parseInt(args[3]), Integer.parseInt(args[4])
                    );
            hamsters.add(hamster);
        } catch (NumberArgumentException e) {
            // От более "частных" ошибок
            // ошибки при вводе чисел
            System.out.println(e);
        } catch (EmptyArgumentException e) {
            // ошибка при вводе строки
            System.out.println(e);
        } catch (InvalidArgumentException e){
            // неправильно указанная порода хомячка
            System.out.println(e);
        } catch (Exception e) {
            // К наиболее "объемным" ошибкам
            // ошибки при чтении строки с консоли: неверный порядок, недостаточно аргументов
            System.out.println(e.getMessage());
        }
        finally {
            // выполняется и если ошибка выпала, и если ошибок не было
            System.out.printf("try create a hamster");
        }
    }
}
