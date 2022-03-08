package oop.foods;

/**
 * Родительский класс Пищи для Животных
 */
public class Food {

    private int satiety;

    public Food(int satiety) {
        if (satiety < 1)
            throw new Error("Что ж это за еда, если ее есть бесполезно?");
        this.satiety = satiety;
    }

    public boolean isUsed() {
        return satiety == 0;
    }

    public int eatFood(int hungry) {
        if (hungry < satiety){
            this.satiety -= hungry;
        } else {
            // уточним, сколько сможем съесть
            hungry = satiety;
            this.satiety = 0;
        }
        return hungry;
    }

    @Override
    public String toString() {
        return "[" +
                "satiety=" + satiety +
                (isUsed() ? ", USED" : "") +
                ']';
    }
}
