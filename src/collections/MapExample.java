package collections;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * Пример работы со словарями данных,
 * содержащими пару уникальный ключ
 * и соответствующее ему значение
 *
 * Экземпляр класса Map создать нельзя,
 * но можно создать словарь,
 * соответствующий его дочерним классам
 */
public class MapExample {

    private static int key = 0;

    public static void main(String[] args) {
        Map<Integer, Person> map =
                createHashMap();
//                createTreeMap();

        // region // put or replace

        /*
            Метод put() добавляет элемент с заданным ключом
         */
        map.put(key++, new Person("John", "Neumann"));
        map.put(key++, new Person("Augustin", "Cauchy"));
        map.put(key++, new Person("Alan", "Turing"));
        System.out.println(map.toString());
        System.out.println();

        /*
            Можно добавить в один словарь элементы другого словаря
            методом putAll()

            Если ключи элементов одного не совпадают
            с ключами другого, то элемент будет добавлен.
            Но если ключ уже использовался,
            то изменится значение элемента
         */
        Map<Integer, Person> tempMap = createHashMap();
        tempMap.put(key++, new Person("Konrad", "Zuse"));
        tempMap.put(0, new Person("John", "Mauchly"));

        map.putAll(tempMap);
        System.out.println(map.toString());
        System.out.println();


        /*
            Кстати, если вы "случайно" попытаетесь методом put()
            добавить элемент по использованному ключу,
            то значение элемента также изменится

            А сам метод вернет (вытолкнет) значение,
            которое он перетрет по этому ключу.
            Когда метод put() добавлял элемент,
            он возвращал null
         */
        System.out.println(map.put(key++, new Person("Charles", "Babbage")));
        System.out.println(map.put(1, new Person("Ada", "Lovelace")));
        System.out.println(map.toString());
        System.out.println();

        /*
            Чтобы явно изменить значение элемента
            по определенному ключу, то можно сразу
            использовать метод replace()

            Если будет найден заданный ключ,
            то метод вернет значение,
            которое будет заменено.
            Но метод replace() не добавляет значение,
            если ключ в словаре отсутствовал
         */
        System.out.println(map.replace(0, new Person("John", "Eckert")));
        System.out.println(map.replace(key++, new Person("John", "Eckert")));
        System.out.println(map.toString());
        System.out.println();

        // endregion

        // region // get & remove

        /*
            Посмотреть какое значение
            соответствует ключу, можно
            с помощью метода get()
         */
        System.out.println(map.get(0));
        System.out.println();

        /*
            Метод remove() удаляет значение,
            соответствующее ключу.

            Если удалось найти такой ключ,
            то метод сообщит какой объект он удаляет,
            иначе вернет null
         */
        System.out.println(map.remove(0));
        System.out.println(map.toString());
        System.out.println();

        // endregion

        // region // sizing

        /*
            В отличие от массивов,
            длину словарей возрващает метод size()

            А метод isEmpty() уточняет, есть ли элементы в словаре
         */
        System.out.println("Map length = " + map.size());
        System.out.println("Map is empty = " + map.isEmpty());
        System.out.println();

        // endregion

        // region // contains

        System.out.println(map.containsKey(1));
        System.out.println(map.containsValue(new Person("Ada", "Lovelace")));
        System.out.println();

        // endregion

        // region // keys & values

        /*
            Метод values() вернет
            коллекцию (java.util.Collection)
            значений словаря
         */
        System.out.println(map.values().toString());

        /*
            А метод keySet() вернет
            набор (java.util.Set)
            ключей словаря
         */
        System.out.println(map.keySet().toString());
        System.out.println();

        // endregion

    }

    /**
     * Хеш-таблица представляет такую структуру данных,
     * в которой все объекты имеют
     * уникальный ключ
     *
     * Данные располагаются согласно правилу
     * возрастания хеш-кода (hashCode()) ключей
     *
     * @return - пустая хеш-таблица
     */
    private static HashMap createHashMap (){
        HashMap<Integer, Person> hashMap = new HashMap();
        hashMap.put(0, new Person("John", "Neumann"));
        hashMap.put(2, new Person("Augustin", "Cauchy"));
        hashMap.put(1, new Person("Alan", "Turing"));

        System.out.println(hashMap.toString());
        System.out.println();

        hashMap.clear();
        return new HashMap();
    }

    /**
     * Дерево, в котором все объекты
     * сортируются по значеням их ключей
     *
     * Для того чтобы сортировать объекты,
     * TreeMap требует, чтобы объекты указали
     * правило сортировки в соответствии с
     * интерфейсом java.lang.{@link Comparable}
     *
     * @return - пустое отсортированное дерево
     */
    private static TreeMap createTreeMap() {

        // В том случае, если тип ключей
        // уже реализует интерфейс java.lang.{@link Comparable}
        TreeMap<Integer, Person> treeMap = new TreeMap<Integer, Person>();

        // Или указать в конструкторе
        // объект java.lang.{@link Comparator}
        // или метод соответствующего класса,
        // который будет сравнивать два ключа
        treeMap = new TreeMap(Person :: compareFromId);

        treeMap.put(10, new Person("John", "Neumann"));
        treeMap.put(3, new Person("Augustin", "Cauchy"));
        treeMap.put(40, new Person("Alan", "Turing"));
        System.out.println(treeMap.toString());

        /*
            Для сортированных коллекций мы также можем
            говорить о наличии специфических методов
            нахождения минимальных и максимальных
            значений и их ключей
         */
        System.out.println(treeMap.firstKey());
        System.out.println(treeMap.firstEntry());
        System.out.println();

        System.out.println(treeMap.lastKey());
        System.out.println(treeMap.firstEntry());
        System.out.println();

        /*
            Метод tailMap() возвращает все значения,
            которые стоят до объекта с заданным ключом
         */
        System.out.println(treeMap.headMap(11)); // хотя ключа 11 нет

        /*
            Метод tailMap() возвращает все значения,
            которые расположены начиная с заданного ключа
         */
        System.out.println(treeMap.tailMap(10));

        return treeMap;
    }
}
