package entities;

public class Age {
    private final int age;

    public Age(int age) {
        this.age = age;
    }
    public boolean isLegalDrinker(int drinkingAge){
        return age>drinkingAge;
    }
}
