package Entities;

public enum Gender {
    MALE("Mr"),
    FEMALE("Ms");

    private final String title;

    Gender(String title) {
        this.title = title;
    }


    public String getPrefix() {
        return this.title;
    }
}
