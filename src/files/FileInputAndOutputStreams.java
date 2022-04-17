package files;

import java.io.*;

/**
 * В основе всех классов, управляющих потоками байтов,
 * находятся два абстрактных класса:
 * InputStream (представляющий потоки ввода - объект, из которого можно считать данные)
 * и OutputStream (представляющий потоки вывода - объект, в который можно записывать данные)
 *
 * Классы FileOutputStream и FileInputStream предназначены
 * для записи байтов в файл и чтения байтов из файла
 */
public class FileInputAndOutputStreams {

    // region // old syntax of try/catch

    public static boolean classicWriteTo(String dir, String name, String extension, byte[] content) {

        FileOutputStream out = null; // с помощью этого класса записываем содержимое в файл
        try {

            // а есть ли указанный файл в указанной директории?
            File file = new File(dir + name + extension);
            if (!file.exists()){
                // если файла нет, то создаем его
                file.createNewFile();
                System.out.println("File created: " + file.getPath());
            }

            // открываем поток вывода данных java.io, где последний параметр:
            // true - файл будет дополняться
            // false - файл будет перезаписываться (по умолчанию)
            out = new FileOutputStream(dir + name + extension, false);

            // записываем данные в файл
            out.write(content, 0, content.length);

            // выбрасывает содержимое из буфера обмена в поток вывода,
            // если осталось содержимое, еще не записанное в файл
            out.flush();

            // закрываем поток вывода java.io
            out.close();

            // данные удачно внесли в файл
            return true;
        } catch (IOException ex) {
            // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
            System.out.println(ex.getMessage());

            // если поток вывода данных удалось открыть
            if (out != null) {
                // закрываем поток вывода java.io
                try {
                    out.close();
                } catch (IOException e) {
                    // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
                    System.out.println(ex.getMessage());
                }

            }
        }

        // произошла какая-то ошибка
        return false;
    }

    public static byte[] classicReadFrom(String dir, String name, String extension) {

        // а есть ли указанный файл в указанной директории?
        File file = new File(dir + name + extension);
        if (!file.exists()){
            System.out.println("File does not exist: " + file.getPath());
            return null;
        }

        FileInputStream in = null;  // с помощью этого класса читаем содержимое
        try {

            // откроем поток ввода java.io
            in = new FileInputStream(dir + name + extension);

            // метод available() возвращает не размер данных,
            // а количество данных от указателя до конца файла
            System.out.println("До конца файла " + in.available() + " байт");

            // выделим место под данные
            byte[] buffer = new byte[in.available()];

            // считаем побайтно данные из файла и запишем в массив
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = (byte) (in.read());
            }

            // закрываем поток ввода java.io
            in.close();

            // вернем считанные данные
            return buffer;
        } catch(IOException ex){
            // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
            System.out.println(ex.getMessage());

            // если поток ввода данных удалось открыть
            if (in != null) {

                // закрываем поток ввода java.io
                try {
                    in.close();
                } catch (IOException e) {
                    // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
                    System.out.println(ex.getMessage());
                }
            }
        }

        return null;
    }

    // endregion


    // region // syntax of try-with-resources/catch

    public static boolean modernWriteTo(String dir, String name, String extension, byte[] content) {

        // откроем и закрываем поток вывода java.io блоком try/catch
        try(OutputStream out = new FileOutputStream(dir + name + extension)){

            // записываем данные в файл
            out.write(content, 0, content.length);

            // выбрасывает содержимое из буфера обмена в поток вывода,
            // если осталось содержимое, еще не записанное в файл
            out.flush();

            return true;
        } catch(IOException ex){
            // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
            System.out.println(ex.getMessage());
        }
        // endregion

        return false;
    }

    public static byte[] modernReadFrom(String dir, String name, String extension) {

        // откроем и закрываем поток ввода java.io блоком try/catch
        try(InputStream in = new FileInputStream(dir + name + extension)) {
            System.out.println("До конца файла " + in.available() + " байт");

            // выделим место под данные
            byte[] buffer = new byte[in.available()];

            // считываем все данные разом
            in.read(buffer);

            // вернем считанные данные
            return buffer;
        } catch(IOException ex){
            // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
            System.out.println(ex.getMessage());
        }

        return null;
    }

    //endregion
}
