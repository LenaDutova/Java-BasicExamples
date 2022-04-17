package files;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.Random;

/**
 * Сериализация представляет процесс записи состояния объекта в поток,
 * соответственно процесс извлечения или восстановления состояния объекта из потока называется десериализацией.
 * Сериализация очень удобна, когда идет работа со сложными объектами
 *
 * Сериализовать можно только те объекты, которые реализуют интерфейс Serializable
 */
public class DataObject
        implements Serializable {

    // служебное поле, которое не нужно хранить,
    // помечается ключевым словом transient
    private transient Random random = new Random();

    public String name;         // имя
    public String surname;      // фамилия
    public String patronymic;   // отчество

//    @SerializedName("object_id")// можно изменить имя поля при сохранении в json-формате
    public int id;              // идентификатор данных

    // Конструктор создающий новую запись с некоторым последовательным идентификатором
    public DataObject(String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

        this.id = random.nextInt();
    }

    // Конструктор воссоздающий определенную запись
    public DataObject(int id, String surname, String name, String patronymic) {
        this.name = name;
        this.surname = surname;
        this.patronymic = patronymic;

        this.id = id;
    }

    @Override
    public String toString() {
        return "DataObject [" +
                "id = " + id + ", " +
                "surname = '" + surname + "', " +
                "name = '" + name + "', " +
                "patronymic = '" + patronymic + "']";
    }
}
