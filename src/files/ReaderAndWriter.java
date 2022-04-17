package files;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * Абстрактные классы Reader и Writer предоставляет функционал
 * для чтения и записи текстовой информации.
 */
public class ReaderAndWriter {

    /**
     * Вызов метода writeTo(...) с указанием переписывать файл
     */
    public static boolean writeToFile(String dir, String name, String extension, String text) {
        return writeTo(dir, name, extension, text, false);
    }

    /**
     * Вызов метода writeTo(...) с указанием дополнять файл
     */
    public static boolean addToFile(String dir, String name, String extension, String text) {
        return writeTo(dir, name, extension, text, true);
    }


    private static boolean writeTo(String dir, String name, String extension, String text, boolean append) {

        // syntax of try-with-resources/catch
        // откроем и закрываем поток вывода java.io блоком try/catch
        try(Writer out = new FileWriter(dir + name + extension, StandardCharsets.UTF_8, append)) {

            // Если вы не задавали кодировку потока сами,
            // то можно узнать с какой кодировкой создавалась виртуальная машина
            System.out.println("Кодировка JVM: " + ((FileWriter)out).getEncoding());
            out.write(text);                      // запись всей строки
            out.append('\n');                     // запись символа

            // выбрасывает содержимое из буфера обмена в поток вывода,
            // если осталось содержимое, еще не записанное в файл
            out.flush();

            // подтверждаем запись
            return true;
        } catch (FileNotFoundException ex) {
            // неверная директория, название или расширение файла
            System.out.println(ex.getMessage());
        } catch(IOException ex){
            // Произошла какая-то ошибка, например, нет прав доступа к файлу
            System.out.println(ex.getMessage());
        }

        // информируем, что записать данные не удалось
        return false;
    }

    public static String readFromFile(String dir, String name, String extension) {

        // syntax of try-with-resources/catch
        // откроем и закрываем поток ввода java.io блоком try/catch
        try(Reader in = new FileReader(dir + name + extension, StandardCharsets.UTF_8)){

            // Если вы не задавали кодировку потока сами,
            // то можно узнать с какой кодировкой создавалась виртуальная машина
            System.out.println("Кодировка JVM: " + ((FileReader)in).getEncoding());

            String content = "";    // В эту строку будем аккумулировать содержание файла

            int c;
            // читаем посимвольно, либо считали код символа, либо "-1" - конец файла
            while((c = in.read()) != -1){
                content += (char) c;
            }

            return content;
        } catch (FileNotFoundException ex) {
            // Неверная директория, название или расширение файла
            System.out.println(ex.getMessage());
        } catch(IOException ex){
            // Произошла какая-то ошибка, например, нет прав доступа к файлу
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
