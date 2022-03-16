package oop.foods;

/**
 * Родительский класс Пищи для Животных
 */
public class Food {

    private int calories;

    public Food(int calories) {
        if (calories < 1)
            throw new Error("Что ж это за еда, если ее есть бесполезно?");
        this.calories = calories;
    }

    public boolean isUsed() {
        return calories == 0;
    }

    public int eatFood(int hungry) {
        if (hungry < calories){
            this.calories -= hungry;
        } else {
            // уточним, сколько сможем съесть
            hungry = calories;
            this.calories = 0;
        }
        return hungry;
    }

    @Override
    public String toString() {
        return "[" +
                "calories=" + calories +
                (isUsed() ? ", USED" : "") +
                ']';
    }
}
