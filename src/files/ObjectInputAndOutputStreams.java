package files;

import java.io.*;
import java.nio.charset.Charset;

/**
 * Классы ObjectOutputStream и ObjectInputStream отвечают за то,
 * как представить состояние объекта для его последующей записи
 * в файл или чтения из файла
 *
 * При открытии ObjectOutputStream или ObjectInputStream
 * требуется передать поток, в который производится запись,
 * или из которого считывается запись
 */
public class ObjectInputAndOutputStreams {

    public static boolean writeTo(String dir, String name, String extension, DataObject object) {

        // откроем и закрываем поток вывода java.io блоком try/catch
        // для записи данных, кто-то должен уметь записывать байты
        try(ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(dir + name + extension))){

            System.out.println("Кодировка в которой записывается файл: " + Charset.defaultCharset());
            // записываем данные в файл
            out.writeObject(object);

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

    public static DataObject readFrom(String dir, String name, String extension) {

        // откроем и закрываем поток ввода java.io блоком try/catch
        try(ObjectInputStream in = new ObjectInputStream(new FileInputStream(dir + name + extension))) {

            // выделим место под данные
            DataObject data = null;

            // считываем данные
            data = (DataObject) in.readObject();

            // вернем считанные данные
            return data;
        } catch (ClassNotFoundException ex) {
            // Считанные данные оказались иного формата
            System.out.println(ex.getMessage());
        } catch(IOException ex){
            // Произошла какая-то ошибка, например, отсутствие прав доступа к файлу
            System.out.println(ex.getMessage());
        }

        return null;
    }
}
