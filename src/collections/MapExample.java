package collections;

import java.util.HashMap;
import java.util.Map;

public class MapExample {
    public static void main(String[] args) {
        Map<Integer, Person> map =
                createHashMap();

        // region // add

        /*
            Метод put() добавляет элемент с заданным ключом
         */
        map.put(1, new Person("Alan", "Turing"));
        map.put(0, new Person("Augustin", "Cauchy"));
        map.put(2, new Person("Charles", "Babbage"));
        System.out.println(map.toString());

        /*
            Но если ключ уже использовался - тогда заменяет значений
         */
        map.put(0, new Person("Ada", "Lovelace"));
        System.out.println(map.toString());

         /*
            Можно добавить в один список элементы другого списка
            методом putAll()
         */

        // endregion

        // region // add



        // region // add
        // region // add
        // region // add
        // region // add

    }

    private static HashMap createHashMap (){
        return new HashMap();
    }
}
