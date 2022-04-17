package files;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.text.SimpleDateFormat;
import java.util.Date;

public class FilesExample {

    private static final String DIR_PATH_RELATIVE = "src\\resources\\";             // Относительный адрес
    private static final String DIR_PATH_ABSOLUTE = "C:\\Users\\Public\\Documents"; // Абсолютный адрес
    private static final String DIR_PATH = DIR_PATH_RELATIVE;                       // "./src/resources/";

    private static final String IMAGE_FILE_NAME = "image";
    private static final String IMAGE_FILE_EXTENSION = ".jpg";

    private static final String TEXT_FILE_NAME = "log";
    private static final String TEXT_FILE_EXTENSION = ".txt";
    private static final String TEXT_CONTENT = """
 
                    I see skies of blue
                    and clouds of white.
                    The bright blessed day.
                    The dark sacred night.
                    And I think to myself
                    what a wonderful world

            """;

    private static final String OBJECT_FILE_NAME = "data";
    private static final String JSON_FILE_NAME = "json";

    public static void main(String[] args) {
//        cloneImage();
//        loggingText();
//        saveObject();
        saveJson();
    }

    /**
     * Временная метка для логирования записи в файл
     *
     * Обратите внимание на варианты работы с датой:
     * Паттерны шаблонов описаны в комментариях к классам
     * {@link SimpleDateFormat} и {@link java.util.Formatter}
     *
     * @return - строка
     */
    public static String getPrefix (){
        // Время отсчитывается в миллисекундах от 1 января 1970 года
        String timestamp = String.valueOf(System.currentTimeMillis()) + '\n';

        Date currentMoment = new Date();
        timestamp += currentMoment.toString() + '\n';

        // Форматирование с помощью класса SimpleDateFormat
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd G', 'E HH:mm:ss a");
        timestamp += format.format(currentMoment) + '\n';

        // Форматирование доступное для строки, где цифра 1 - номер переменной после шаблона
        timestamp += String.format("%1$td %1$tB %1$tY, %1$tA\n", currentMoment);

        return timestamp;
    }

    /**
     * Считываем байты файла resources/image.jpg
     * и копируем их в другой файл resources/image_new.jpg
     */
    private static void cloneImage() {
        byte[] image =  FileInputAndOutputStreams.modernReadFrom(DIR_PATH, IMAGE_FILE_NAME, IMAGE_FILE_EXTENSION);
        System.out.println(FileInputAndOutputStreams.modernWriteTo(DIR_PATH, IMAGE_FILE_NAME + "_new", IMAGE_FILE_EXTENSION, image));
    }

    /**
     * Приписываем данные в файл resources/log.txt
     * (в формате временная метка + текст куплета песни),
     * затем считываем, что получилось
     */
    private static void loggingText(){
        System.out.println(ReaderAndWriter.addToFile(DIR_PATH, TEXT_FILE_NAME, TEXT_FILE_EXTENSION, getPrefix() + TEXT_CONTENT));
        System.out.println(ReaderAndWriter.readFromFile(DIR_PATH, TEXT_FILE_NAME, TEXT_FILE_EXTENSION));
    }

    /**
     * Создаем произвольный объект,
     * сохраняем его в файл resources/data.txt
     * и читаем из этого файла
     *
     * Обратите внимание, что данные кодируются,
     * а не читаются как текст
     */
    private static void saveObject() {
        DataObject data = new DataObject("Иванов", "Иван", "Иванович");
        System.out.println(data);
        System.out.println(ObjectInputAndOutputStreams.writeTo(DIR_PATH, OBJECT_FILE_NAME, TEXT_FILE_EXTENSION, data));

        data = null;
        data = ObjectInputAndOutputStreams.readFrom(DIR_PATH, OBJECT_FILE_NAME, TEXT_FILE_EXTENSION);

        System.out.println(data);
    }

    /**
     * Сохранение состояния объекта в формате json
     *
     * Для выполнения следующего кода необходимо
     * подключить библиотеку Gson от Google
     * https://github.com/google/gson
     *
     * Для этого
     * 1. File -> Project Structure -> Project Settings - Libraries
     * 2. + (Alt + Insert - New project library) -> From Maven
     * 3. В строке поиска ввести "com.google.code.gson" и выбрать последнюю версию библиотеки
     * 4. Ок
     */
    private static void saveJson() {
        // зададим массив данных на три персоны
        DataObject[] array = new DataObject[3];
        array[0] = new DataObject("Иванов", "Иван", "Иванович");
        array[1] = new DataObject("Петров", "Петр", "Петрович");
        array[2] = new DataObject("Сидоров", "Сидор", "Сидорович");

        // настроим формат сохранения
        GsonBuilder builder =
                new GsonBuilder()
                        .setPrettyPrinting()    // поддерживает отступы в строках
                        .serializeNulls();      // не игнорирует поля без значений
        Gson gson = builder.create();           // или Gson gson = new Gson();
        System.out.println(ReaderAndWriter.writeToFile(DIR_PATH, JSON_FILE_NAME, TEXT_FILE_EXTENSION, gson.toJson(array)));

        array = null;
        array = gson.fromJson(ReaderAndWriter.readFromFile(DIR_PATH, JSON_FILE_NAME, TEXT_FILE_EXTENSION), DataObject[].class);
        for (DataObject object : array) {
            System.out.println(object.toString());
        }
    }
}
