package errors;

/**
 * Хомяк
 */
public class Hamster {

    private static final String[] breeds = {
            "Обыкновенный",
            "Джунгарский",
            "Русский карликовый"
    };

    private int age;        // до 4 лет живут Джунгарики
    private int length;     // до 35 см вытягивается Обыкновенный (дикий) хомяк
    private int weight;     // до 700 гр. достигает средний вес Обыкновенного (дикого) хомяка
    private String nickname;   // кличка зверька
    private String breed;      // порода

    public Hamster(int breed,
                   String nickname,
                   int age, int length, int weight)
            throws OverflowArgumentException, NegativeArgumentException,
            EmptyArgumentException, InvalidArgumentException {
        this.setAge(age);
        this.setLength(length);
        this.setWeight(weight);
        this.setNickname(nickname);
        this.setBreed(breed);
    }

    public void setNickname(String nickname)
            throws EmptyArgumentException {
        if (nickname == null || nickname.isEmpty())
            throw new EmptyArgumentException("nickname");
        this.nickname = nickname;
    }

    public void setBreed(int breed)
            throws InvalidArgumentException {
        if (breed < breeds.length){
            this.breed = breeds[breed];
        } else throw new InvalidArgumentException("Invalid value for field 'breed'");
    }

    public void setAge(int age)
            throws NegativeArgumentException, OverflowArgumentException {
        if (age < 0)
            throw new NegativeArgumentException("age");
        if (age > 4)
            throw new OverflowArgumentException("age", 4);
        this.age = age;
    }

    public void setLength(int length)
            throws NegativeArgumentException, OverflowArgumentException {
        if (length < 0)
            throw new NegativeArgumentException("length");
        if (length > 35)
            throw new OverflowArgumentException("length", 35);
        this.length = length;
    }

    public void setWeight(int weight)
            throws NegativeArgumentException, OverflowArgumentException {
        if (weight < 0)
            throw new NegativeArgumentException("weight");
        if (weight > 700)
            throw new OverflowArgumentException("weight", 700);
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Упитаный (до " + weight + " грамм и " + length + " см) " +
                breed + " хомяк, известный всем как " + nickname + ", живет своей хомячьей жизнью уже " + age + " " + getYearStr();
    }

    private String getYearStr (){
        switch (age % 10){
            case 1 :
                return "год";
            default :
                return "года";
        }
    }
}
